package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Simulation")
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simulationId;

    @Column(name = "mode", length = 15, nullable = false)
    private String mode;

    @Column(name = "durationMins", nullable = false)
    private int durationMins;

    @Column(name = "difficulty", length = 20,nullable = false)
    private String difficulty;

    @Column(name = "simulationLanguage", length = 20, nullable = false)
    private String simulationLanguage;

    @Column(name = "status", length = 15, nullable = false)
    private String status;

    @Column(name = "coachActive", nullable = false)
    private boolean coachActive;

    @Column(name = "simulationDate", nullable = false)
    private LocalDate simulationDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Simulation() {
    }

    public Simulation(Long simulationId, String mode, int durationMins, String difficulty, String simulationLanguage,
                      String status, boolean coachActive, LocalDate simulationDate, User user) {
        this.simulationId = simulationId;
        this.mode = mode;
        this.durationMins = durationMins;
        this.difficulty = difficulty;
        this.simulationLanguage = simulationLanguage;
        this.status = status;
        this.coachActive = coachActive;
        this.simulationDate = simulationDate;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
