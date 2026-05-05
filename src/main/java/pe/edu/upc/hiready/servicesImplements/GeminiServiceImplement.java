package pe.edu.upc.hiready.servicesImplements;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pe.edu.upc.hiready.servicesInterfaces.IGeminiService;

import java.util.List;
import java.util.Map;

@Service
public class GeminiServiceImplement implements IGeminiService {

    @Value("${gemini.api-key}")
    private String apiKey;

    @Value("${gemini.model}")
    private String model;

    private static final String GEMINI_BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/";

    private final RestClient restClient;

    public GeminiServiceImplement() {
        this.restClient = RestClient.builder().build();
    }

    private String callGemini(String prompt) {
        String url = GEMINI_BASE_URL + model + ":generateContent?key=" + apiKey;

        Map<String, Object> body = Map.of(
            "contents", List.of(Map.of(
                "role", "user",
                "parts", List.of(Map.of("text", prompt))
            )),
            "generationConfig", Map.of(
                "temperature", 0.7,
                "maxOutputTokens", 1024
            )
        );

        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> response = restClient.post()
                    .uri(url)
                    .header("Content-Type", "application/json")
                    .body(body)
                    .retrieve()
                    .body(Map.class);

            if (response != null && response.containsKey("candidates")) {
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                if (!candidates.isEmpty()) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                    if (!parts.isEmpty()) {
                        return (String) parts.get(0).get("text");
                    }
                }
            }
        } catch (Exception e) {
            return "No se pudo generar respuesta de IA: " + e.getMessage();
        }

        return "Sin respuesta disponible.";
    }

    @Override
    public String generateInterviewQuestion(String difficulty, String mode, List<String> skills, String language) {
        String lang = "es".equalsIgnoreCase(language) ? "español" : language;
        String skillsStr = skills != null && !skills.isEmpty() ? String.join(", ", skills) : "habilidades generales";

        String prompt = String.format(
            "Eres un entrevistador profesional de recursos humanos. " +
            "Genera UNA sola pregunta de entrevista de trabajo de nivel %s " +
            "en modo %s para las habilidades: %s. " +
            "Responde ÚNICAMENTE con la pregunta en %s, sin explicaciones adicionales.",
            difficulty, mode, skillsStr, lang
        );

        return callGemini(prompt);
    }

    @Override
    public String evaluateAnswer(String question, String answer, String modelAnswer, String language) {
        String lang = "es".equalsIgnoreCase(language) ? "español" : language;

        String prompt = String.format(
            "Eres un evaluador de entrevistas de trabajo. " +
            "Pregunta: \"%s\"\n" +
            "Respuesta del candidato: \"%s\"\n" +
            "Respuesta modelo esperada: \"%s\"\n\n" +
            "Evalúa la respuesta del candidato en términos de:\n" +
            "1. Claridad verbal (0-100)\n" +
            "2. Confianza emocional (0-100)\n" +
            "3. Precisión técnica (0-100)\n\n" +
            "Proporciona retroalimentación constructiva y breve en %s. " +
            "Formato: VERBAL:[puntaje] EMOCIONAL:[puntaje] TECNICO:[puntaje]\\nFEEDBACK:[retroalimentación]",
            question, answer, modelAnswer != null ? modelAnswer : "No especificada", lang
        );

        return callGemini(prompt);
    }

    @Override
    public String generateHint(String question, String language) {
        String lang = "es".equalsIgnoreCase(language) ? "español" : language;

        String prompt = String.format(
            "Eres un coach de entrevistas. " +
            "Proporciona una pista útil y breve (máximo 2 oraciones) para responder esta pregunta de entrevista: \"%s\". " +
            "Responde en %s. No des la respuesta directa, solo una orientación.",
            question, lang
        );

        return callGemini(prompt);
    }

    @Override
    public String generateSimulationSummary(List<String> questionsAndAnswers, String language) {
        String lang = "es".equalsIgnoreCase(language) ? "español" : language;
        String content = String.join("\n---\n", questionsAndAnswers);

        String prompt = String.format(
            "Eres un coach de entrevistas profesional. " +
            "Basado en las siguientes preguntas y respuestas de una simulación de entrevista:\n\n%s\n\n" +
            "Genera un resumen ejecutivo del desempeño del candidato en %s, identificando: " +
            "fortalezas principales, áreas de mejora, y una calificación general estimada (0-100). " +
            "Sé constructivo y motivador. Máximo 200 palabras.",
            content, lang
        );

        return callGemini(prompt);
    }

    @Override
    public String generateRecommendations(String summary, List<String> weakAreas, String language) {
        String lang = "es".equalsIgnoreCase(language) ? "español" : language;
        String areas = weakAreas != null ? String.join(", ", weakAreas) : "áreas generales";

        String prompt = String.format(
            "Eres un coach de entrevistas. Basado en este resumen de desempeño: \"%s\" " +
            "y las áreas débiles: %s. " +
            "Proporciona 3 recomendaciones específicas y accionables en %s " +
            "para mejorar en futuras entrevistas. Formato: lista numerada.",
            summary, areas, lang
        );

        return callGemini(prompt);
    }
}
