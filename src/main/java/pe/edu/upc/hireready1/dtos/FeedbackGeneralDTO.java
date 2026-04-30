package pe.edu.upc.hireready1.dtos;

public class FeedbackGeneralDTO {
    private Long feedbackId;
    private Long resultId;
    private String frequentErrors;
    private String recommendation;

    // Constructor vacío
    public FeedbackGeneralDTO() {}

    // Constructor completo
    public FeedbackGeneralDTO(Long feedbackId, Long resultId, String frequentErrors, String recommendation) {
        this.feedbackId = feedbackId;
        this.resultId = resultId;
        this.frequentErrors = frequentErrors;
        this.recommendation = recommendation;
    }

    // Getters y Setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFrequentErrors() {
        return frequentErrors;
    }

    public void setFrequentErrors(String frequentErrors) {
        this.frequentErrors = frequentErrors;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }
}
