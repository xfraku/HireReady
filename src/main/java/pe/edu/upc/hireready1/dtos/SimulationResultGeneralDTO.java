package pe.edu.upc.hireready1.dtos;

import java.time.LocalDate;

public class SimulationResultGeneralDTO {
    private Long resultId;
    private float overallScore;
    private float verbalScore;
    private float emotionalScore;
    private float technicalScore;
    private String AISummary;
    private LocalDate resultDate;

    // En lugar del objeto Simulation completo
    private Long simulationId;

    // Constructor vacío
    public SimulationResultGeneralDTO() {}

    // Constructor completo
    public SimulationResultGeneralDTO(Long resultId, float overallScore, float verbalScore,
                               float emotionalScore, float technicalScore,
                               String AISummary, LocalDate resultDate, Long simulationId) {
        this.resultId = resultId;
        this.overallScore = overallScore;
        this.verbalScore = verbalScore;
        this.emotionalScore = emotionalScore;
        this.technicalScore = technicalScore;
        this.AISummary = AISummary;
        this.resultDate = resultDate;
        this.simulationId = simulationId;
    }

    // Getters y Setters

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

    public Long getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Long simulationId) {
        this.simulationId = simulationId;
    }
}
