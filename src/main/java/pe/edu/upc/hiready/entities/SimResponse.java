package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sim_response")
public class SimResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private Integer responseId;

    @ManyToOne
    @JoinColumn(name = "simulation_id", nullable = false)
    private Simulation simulation;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "ai_hint_used")
    private Boolean aiHintUsed;

    public SimResponse() {
    }

    public Integer getResponseId() {
        return responseId;
    }

    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getAiHintUsed() {
        return aiHintUsed;
    }

    public void setAiHintUsed(Boolean aiHintUsed) {
        this.aiHintUsed = aiHintUsed;
    }
}
