package pe.edu.upc.hireready1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserGeneralDTO {
    private Long userId;
    private String dni;
    private String personalEmail;
    private String passwordHash;
    private String firstName;
    private String secondName;
    private String paternalSurname;
    private String maternalSurname;
    private String languagePref;
    private Boolean onboardingDone;

    @JsonProperty("verified")
    private Boolean isVerified;

    @JsonProperty("deleted")
    private Boolean isDeleted;

    private Long rolId;
    private Long profileId;


    // Constructor vacío
    public UserGeneralDTO() {}

    // Constructor completo


    public UserGeneralDTO(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                          String secondName, String paternalSurname, String maternalSurname, String languagePref,
                          Boolean onboardingDone, Boolean isVerified, Boolean isDeleted, Long rolId, Long profileId) {
        this.userId = userId;
        this.dni = dni;
        this.personalEmail = personalEmail;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.languagePref = languagePref;
        this.onboardingDone = onboardingDone;
        this.isVerified = isVerified;
        this.isDeleted = isDeleted;
        this.rolId = rolId;
        this.profileId = profileId;
    }

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public Boolean getOnboardingDone() {
        return onboardingDone;
    }

    public void setOnboardingDone(Boolean onboardingDone) {
        this.onboardingDone = onboardingDone;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
