package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Integer feedbackId;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private SimResult simResult;

    @Column(name = "frequent_errors", columnDefinition = "TEXT")
    private String frequentErrors;

    @Column(name = "recommendation", columnDefinition = "TEXT")
    private String recommendation;

    public Feedback() {
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public SimResult getSimResult() {
        return simResult;
    }

    public void setSimResult(SimResult simResult) {
        this.simResult = simResult;
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
}
