package pe.edu.upc.hireready1.dtos;

import java.time.LocalDate;

public class SimulationGeneralDTO {
    private Long simulationId;
    private String mode;
    private int durationMins;
    private String difficulty;
    private String simulationLanguage;
    private String status;
    private boolean coachActive;
    private LocalDate simulationDate;

    // En lugar del objeto User completo
    private Long userId;

    // Constructor vacío
    public SimulationGeneralDTO() {}

    // Constructor completo
    public SimulationGeneralDTO(Long simulationId, String mode, int durationMins, String difficulty,
                         String simulationLanguage, String status, boolean coachActive,
                         LocalDate simulationDate, Long userId) {
        this.simulationId = simulationId;
        this.mode = mode;
        this.durationMins = durationMins;
        this.difficulty = difficulty;
        this.simulationLanguage = simulationLanguage;
        this.status = status;
        this.coachActive = coachActive;
        this.simulationDate = simulationDate;
        this.userId = userId;
    }

    // Getters y Setters
    public Long getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Long simulationId) {
        this.simulationId = simulationId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(int durationMins) {
        this.durationMins = durationMins;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSimulationLanguage() {
        return simulationLanguage;
    }

    public void setSimulationLanguage(String simulationLanguage) {
        this.simulationLanguage = simulationLanguage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCoachActive() {
        return coachActive;
    }

    public void setCoachActive(boolean coachActive) {
        this.coachActive = coachActive;
    }

    public LocalDate getSimulationDate() {
        return simulationDate;
    }

    public void setSimulationDate(LocalDate simulationDate) {
        this.simulationDate = simulationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
