package pe.edu.upc.hiready.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SimResultDTO {
    private Integer resultId;
    private Integer simulationId;
    private BigDecimal overallScore;
    private BigDecimal verbalScore;
    private BigDecimal emotionalScore;
    private BigDecimal technicalScore;
    private String aiSummary;
    private LocalDate resultDate;

    public Integer getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }

    public Integer getSimulationId() { return simulationId; }
    public void setSimulationId(Integer simulationId) { this.simulationId = simulationId; }

    public BigDecimal getOverallScore() { return overallScore; }
    public void setOverallScore(BigDecimal overallScore) { this.overallScore = overallScore; }

    public BigDecimal getVerbalScore() { return verbalScore; }
    public void setVerbalScore(BigDecimal verbalScore) { this.verbalScore = verbalScore; }

    public BigDecimal getEmotionalScore() { return emotionalScore; }
    public void setEmotionalScore(BigDecimal emotionalScore) { this.emotionalScore = emotionalScore; }

    public BigDecimal getTechnicalScore() { return technicalScore; }
    public void setTechnicalScore(BigDecimal technicalScore) { this.technicalScore = technicalScore; }

    public String getAiSummary() { return aiSummary; }
    public void setAiSummary(String aiSummary) { this.aiSummary = aiSummary; }

    public LocalDate getResultDate() { return resultDate; }
    public void setResultDate(LocalDate resultDate) { this.resultDate = resultDate; }
}
