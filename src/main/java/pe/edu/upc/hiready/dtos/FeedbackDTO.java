package pe.edu.upc.hiready.dtos;

public class FeedbackDTO {
    private Integer feedbackId;
    private Integer resultId;
    private String frequentErrors;
    private String recommendation;

    public Integer getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Integer feedbackId) { this.feedbackId = feedbackId; }

    public Integer getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }

    public String getFrequentErrors() { return frequentErrors; }
    public void setFrequentErrors(String frequentErrors) { this.frequentErrors = frequentErrors; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}
