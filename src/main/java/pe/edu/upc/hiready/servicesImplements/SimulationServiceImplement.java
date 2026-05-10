package pe.edu.upc.hiready.servicesImplements;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.hiready.dtos.*;
import pe.edu.upc.hiready.entities.*;
import pe.edu.upc.hiready.exceptions.ResourceNotFoundException;
import pe.edu.upc.hiready.repositories.*;
import pe.edu.upc.hiready.servicesInterfaces.IGeminiService;
import pe.edu.upc.hiready.servicesInterfaces.ISimulationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class SimulationServiceImplement implements ISimulationService {

    private final SimulationRepository simulationRepository;
    private final SimResponseRepository simResponseRepository;
    private final SimResultRepository simResultRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final FeedbackRepository feedbackRepository;
    private final IGeminiService geminiService;

    public SimulationServiceImplement(SimulationRepository simulationRepository,
                                      SimResponseRepository simResponseRepository,
                                      SimResultRepository simResultRepository,
                                      QuestionRepository questionRepository,
                                      UserRepository userRepository,
                                      FeedbackRepository feedbackRepository,
                                      IGeminiService geminiService) {
        this.simulationRepository = simulationRepository;
        this.simResponseRepository = simResponseRepository;
        this.simResultRepository = simResultRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.feedbackRepository = feedbackRepository;
        this.geminiService = geminiService;
    }

    @Override
    @Transactional
    public SimulationDTO startSimulation(Integer userId, SimulationStartRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Simulation simulation = new Simulation();
        simulation.setUser(user);
        simulation.setMode(request.getMode());
        simulation.setDurationMins(request.getDurationMins());
        simulation.setDifficulty(request.getDifficulty());
        simulation.setSimLanguage(request.getSimLanguage());
        simulation.setStatus("IN_PROGRESS");
        simulation.setCoachActive(request.getCoachActive());
        simulation.setSimulationDate(LocalDate.now());
        Simulation saved = simulationRepository.save(simulation);

        String firstQuestion = geminiService.generateInterviewQuestion(
                request.getDifficulty(), request.getMode(),
                request.getSkills(), request.getSimLanguage());

        Question question = new Question();
        question.setContent(firstQuestion);
        questionRepository.save(question);

        SimulationDTO dto = toDTO(saved);
        dto.setCurrentQuestion(firstQuestion);
        dto.setQuestionNumber(1);
        return dto;
    }

    @Override
    @Transactional
    public SimulationDTO answerQuestion(Integer simulationId, AnswerRequest request) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new ResourceNotFoundException("Simulación no encontrada"));

        if (!"IN_PROGRESS".equals(simulation.getStatus())) {
            throw new IllegalStateException("La simulación no está activa");
        }

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada"));

        String evaluation = geminiService.evaluateAnswer(
                question.getContent(), request.getResponseContent(),
                question.getModelAnswer() != null ? question.getModelAnswer().getContent() : null,
                simulation.getSimLanguage());

        SimResponse response = new SimResponse();
        response.setSimulation(simulation);
        response.setQuestion(question);
        response.setResponseContent(request.getResponseContent());
        response.setAiEvaluation(evaluation);
        response.setAiHintUsed(request.getAiHintUsed());
        simResponseRepository.save(response);

        long answeredCount = simResponseRepository.countBySimulationSimulationId(simulationId);
        String nextQuestion = geminiService.generateInterviewQuestion(
                simulation.getDifficulty(), simulation.getMode(),
                null, simulation.getSimLanguage());

        Question nextQ = new Question();
        nextQ.setContent(nextQuestion);
        questionRepository.save(nextQ);

        SimulationDTO dto = toDTO(simulation);
        dto.setCurrentQuestion(nextQuestion);
        dto.setQuestionNumber((int) answeredCount + 1);
        return dto;
    }

    @Override
    public String getHint(Integer simulationId, Integer questionId) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new ResourceNotFoundException("Simulación no encontrada"));
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta no encontrada"));

        return geminiService.generateHint(question.getContent(), simulation.getSimLanguage());
    }

    @Override
    @Transactional
    public SimResultDTO completeSimulation(Integer simulationId) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new ResourceNotFoundException("Simulación no encontrada"));

        simulation.setStatus("COMPLETED");
        simulationRepository.save(simulation);

        List<SimResponse> responses = simResponseRepository.findBySimulationSimulationId(simulationId);

        List<BigDecimal> verbals = new ArrayList<>();
        List<BigDecimal> emotionals = new ArrayList<>();
        List<BigDecimal> technicals = new ArrayList<>();
        List<String> qaList = new ArrayList<>();

        for (SimResponse r : responses) {
            qaList.add("P: " + r.getQuestion().getContent() + "\nR: " + r.getResponseContent());
            extractScores(r.getAiEvaluation(), verbals, emotionals, technicals);
        }

        BigDecimal verbalAvg = average(verbals);
        BigDecimal emotionalAvg = average(emotionals);
        BigDecimal technicalAvg = average(technicals);
        // Cálculo de puntaje general promediando áreas verbal, emocional y técnica
        BigDecimal overall = verbalAvg.add(emotionalAvg).add(technicalAvg)
                .divide(BigDecimal.valueOf(3), 2, java.math.RoundingMode.HALF_UP);

        String summary = geminiService.generateSimulationSummary(qaList, simulation.getSimLanguage());

        SimResult result = new SimResult();
        result.setSimulation(simulation);
        result.setOverallScore(overall);
        result.setVerbalScore(verbalAvg);
        result.setEmotionalScore(emotionalAvg);
        result.setTechnicalScore(technicalAvg);
        result.setAiSummary(summary);
        result.setResultDate(LocalDate.now());
        SimResult saved = simResultRepository.save(result);

        List<String> weakAreas = new ArrayList<>();
        if (verbalAvg.compareTo(BigDecimal.valueOf(60)) < 0) weakAreas.add("comunicación verbal");
        if (emotionalAvg.compareTo(BigDecimal.valueOf(60)) < 0) weakAreas.add("inteligencia emocional");
        if (technicalAvg.compareTo(BigDecimal.valueOf(60)) < 0) weakAreas.add("conocimiento técnico");

        String recommendations = geminiService.generateRecommendations(summary, weakAreas, simulation.getSimLanguage());

        Feedback feedback = new Feedback();
        feedback.setSimResult(saved);
        feedback.setRecommendation(recommendations);
        feedback.setFrequentErrors(weakAreas.isEmpty() ? "Sin errores frecuentes detectados" : String.join(", ", weakAreas));
        feedbackRepository.save(feedback);

        return toResultDTO(saved);
    }

    @Override
    @Transactional
    public SimulationDTO resumeSimulation(Integer simulationId) {
        Simulation simulation = simulationRepository.findById(simulationId)
                .orElseThrow(() -> new ResourceNotFoundException("Simulación no encontrada"));

        if ("COMPLETED".equals(simulation.getStatus())) {
            throw new IllegalStateException("La simulación ya fue completada");
        }

        simulation.setStatus("IN_PROGRESS");
        simulationRepository.save(simulation);

        long answered = simResponseRepository.countBySimulationSimulationId(simulationId);
        String nextQuestion = geminiService.generateInterviewQuestion(
                simulation.getDifficulty(), simulation.getMode(), null, simulation.getSimLanguage());

        Question nextQ = new Question();
        nextQ.setContent(nextQuestion);
        questionRepository.save(nextQ);

        SimulationDTO dto = toDTO(simulation);
        dto.setCurrentQuestion(nextQuestion);
        dto.setQuestionNumber((int) answered + 1);
        return dto;
    }

    @Override
    public List<SimulationDTO> getUserSimulations(Integer userId) {
        return simulationRepository.findByUserUserIdOrderBySimulationDateDesc(userId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public SimResultDTO getSimulationResult(Integer simulationId) {
        SimResult result = simResultRepository.findBySimulationSimulationId(simulationId)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado no encontrado"));
        return toResultDTO(result);
    }

    private SimulationDTO toDTO(Simulation s) {
        SimulationDTO dto = new SimulationDTO();
        dto.setSimulationId(s.getSimulationId());
        dto.setUserId(s.getUser().getUserId());
        dto.setMode(s.getMode());
        dto.setDurationMins(s.getDurationMins());
        dto.setDifficulty(s.getDifficulty());
        dto.setSimLanguage(s.getSimLanguage());
        dto.setStatus(s.getStatus());
        dto.setCoachActive(s.getCoachActive());
        dto.setSimulationDate(s.getSimulationDate());
        return dto;
    }

    private SimResultDTO toResultDTO(SimResult r) {
        SimResultDTO dto = new SimResultDTO();
        dto.setResultId(r.getResultId());
        dto.setSimulationId(r.getSimulation().getSimulationId());
        dto.setOverallScore(r.getOverallScore());
        dto.setVerbalScore(r.getVerbalScore());
        dto.setEmotionalScore(r.getEmotionalScore());
        dto.setTechnicalScore(r.getTechnicalScore());
        dto.setAiSummary(r.getAiSummary());
        dto.setResultDate(r.getResultDate());
        return dto;
    }

    private void extractScores(String evaluation, List<BigDecimal> verbals,
                                List<BigDecimal> emotionals, List<BigDecimal> technicals) {
        if (evaluation == null) return;
        try {
            Pattern p = Pattern.compile("VERBAL:(\\d+).*?EMOCIONAL:(\\d+).*?TECNICO:(\\d+)",
                    Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(evaluation);
            if (m.find()) {
                verbals.add(new BigDecimal(m.group(1)));
                emotionals.add(new BigDecimal(m.group(2)));
                technicals.add(new BigDecimal(m.group(3)));
            } else {
                verbals.add(BigDecimal.valueOf(70));
                emotionals.add(BigDecimal.valueOf(70));
                technicals.add(BigDecimal.valueOf(70));
            }
        } catch (Exception e) {
            verbals.add(BigDecimal.valueOf(70));
            emotionals.add(BigDecimal.valueOf(70));
            technicals.add(BigDecimal.valueOf(70));
        }
    }

    private BigDecimal average(List<BigDecimal> values) {
        if (values.isEmpty()) return BigDecimal.valueOf(0);
        return values.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(values.size()), 2, java.math.RoundingMode.HALF_UP);
    }
}
