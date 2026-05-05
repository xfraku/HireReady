package pe.edu.upc.hiready.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SimulationStartRequest {
    @NotBlank
    private String mode;

    @NotNull
    private Integer durationMins;

    private String difficulty = "MEDIO";
    private String simLanguage = "es";
    private Boolean coachActive = false;
    private List<String> skills;

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public Integer getDurationMins() { return durationMins; }
    public void setDurationMins(Integer durationMins) { this.durationMins = durationMins; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getSimLanguage() { return simLanguage; }
    public void setSimLanguage(String simLanguage) { this.simLanguage = simLanguage; }

    public Boolean getCoachActive() { return coachActive; }
    public void setCoachActive(Boolean coachActive) { this.coachActive = coachActive; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }
}
