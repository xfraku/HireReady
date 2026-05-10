package pe.edu.upc.hiready.servicesInterfaces;

import java.util.List;

public interface IGeminiService {
    String generateInterviewQuestion(String difficulty, String mode, List<String> skills, String language);
    String evaluateAnswer(String question, String answer, String modelAnswer, String language);
    String generateHint(String question, String language);
    String generateSimulationSummary(List<String> questionsAndAnswers, String language);
    String generateRecommendations(String summary, List<String> weakAreas, String language);
}
