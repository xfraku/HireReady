package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SimulationResult")
public class SimulationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @Column(name = "overallScore", nullable = false)
    private float overallScore;

    @Column(name = "verbalScore", nullable = false)
    private float verbalScore;

    @Column(name = "emotionalScore", nullable = false)
    private float emotionalScore;

    @Column(name = "technicalScore", nullable = false)
    private float technicalScore;

    @Column(name = "AISummary", length = 800, nullable = false)
    private String AISummary;

    @Column(name = "LocalDate", nullable = false)
    private LocalDate resultDate;

    @OneToOne
    @JoinColumn(name = "simulationId", nullable = false)
    private Simulation simulation;

    public SimulationResult() {
    }

    public SimulationResult(Long resultId, float overallScore, float verbalScore, float emotionalScore,
                            float technicalScore, String AISummary, LocalDate resultDate, Simulation simulation) {
        this.resultId = resultId;
        this.overallScore = overallScore;
        this.verbalScore = verbalScore;
        this.emotionalScore = emotionalScore;
        this.technicalScore = technicalScore;
        this.AISummary = AISummary;
        this.resultDate = resultDate;
        this.simulation = simulation;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public float getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(float overallScore) {
        this.overallScore = overallScore;
    }

    public float getVerbalScore() {
        return verbalScore;
    }

    public void setVerbalScore(float verbalScore) {
        this.verbalScore = verbalScore;
    }

    public float getEmotionalScore() {
        return emotionalScore;
    }

    public void setEmotionalScore(float emotionalScore) {
        this.emotionalScore = emotionalScore;
    }

    public float getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(float technicalScore) {
        this.technicalScore = technicalScore;
    }

    public String getAISummary() {
        return AISummary;
    }

    public void setAISummary(String AISummary) {
        this.AISummary = AISummary;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
