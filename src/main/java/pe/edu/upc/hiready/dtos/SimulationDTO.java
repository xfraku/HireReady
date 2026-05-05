package pe.edu.upc.hiready.dtos;

import java.time.LocalDate;

public class SimulationDTO {
    private Integer simulationId;
    private Integer userId;
    private String mode;
    private Integer durationMins;
    private String difficulty;
    private String simLanguage;
    private String status;
    private Boolean coachActive;
    private LocalDate simulationDate;
    private String currentQuestion;
    private Integer questionNumber;

    public Integer getSimulationId() { return simulationId; }
    public void setSimulationId(Integer simulationId) { this.simulationId = simulationId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public Integer getDurationMins() { return durationMins; }
    public void setDurationMins(Integer durationMins) { this.durationMins = durationMins; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getSimLanguage() { return simLanguage; }
    public void setSimLanguage(String simLanguage) { this.simLanguage = simLanguage; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Boolean getCoachActive() { return coachActive; }
    public void setCoachActive(Boolean coachActive) { this.coachActive = coachActive; }

    public LocalDate getSimulationDate() { return simulationDate; }
    public void setSimulationDate(LocalDate simulationDate) { this.simulationDate = simulationDate; }

    public String getCurrentQuestion() { return currentQuestion; }
    public void setCurrentQuestion(String currentQuestion) { this.currentQuestion = currentQuestion; }

    public Integer getQuestionNumber() { return questionNumber; }
    public void setQuestionNumber(Integer questionNumber) { this.questionNumber = questionNumber; }
}
