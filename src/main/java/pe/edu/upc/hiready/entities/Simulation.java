package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "simulation")
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simulation_id")
    private Integer simulationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "mode", nullable = false, length = 50)
    private String mode;

    @Column(name = "duration_mins", nullable = false)
    private Integer durationMins;

    @Column(name = "difficulty", length = 50)
    private String difficulty;

    @Column(name = "sim_language", length = 50)
    private String simLanguage;
// Control de estado (IN_PROGRESS, COMPLETED) para gestionar el flujo de la entrevista
    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "coach_active")
    private Boolean coachActive;

    @Column(name = "simulation_date")
    private LocalDate simulationDate;

    public Simulation() {
    }

    public Integer getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getDurationMins() {
        return durationMins;
    }

    public void setDurationMins(Integer durationMins) {
        this.durationMins = durationMins;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSimLanguage() {
        return simLanguage;
    }

    public void setSimLanguage(String simLanguage) {
        this.simLanguage = simLanguage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCoachActive() {
        return coachActive;
    }

    public void setCoachActive(Boolean coachActive) {
        this.coachActive = coachActive;
    }

    public LocalDate getSimulationDate() {
        return simulationDate;
    }

    public void setSimulationDate(LocalDate simulationDate) {
        this.simulationDate = simulationDate;
    }
}
