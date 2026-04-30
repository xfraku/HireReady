package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(name = "frequentErrors", length = 500, nullable = false)
    private String frequentErrors;

    @Column(name = "recommendation", length = 750, nullable = false)
    private String recommendation;

    //FK
    @OneToOne
    @JoinColumn(name = "resultId", nullable = false)
    private SimulationResult simResult;

    public Feedback() {
    }

    public Feedback(Long feedbackId, String frequentErrors, String recommendation, SimulationResult simResult) {
        this.feedbackId = feedbackId;
        this.frequentErrors = frequentErrors;
        this.recommendation = recommendation;
        this.simResult = simResult;
    }

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

    public SimulationResult getSimResult() {
        return simResult;
    }

    public void setSimResult(SimulationResult simResult) {
        this.simResult = simResult;
    }
}
