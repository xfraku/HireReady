package pe.edu.upc.hireready1.dtos;

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
    private boolean onboardingDone;
    private boolean isVerified;
    private boolean isDeleted;

    // Se pasan los DTOS, no las clases en sí
    private List<RolGeneralDTO> roles;
    private ProfileGeneralDTO profile;

    // Constructor vacío
    public UserGeneralDTO() {}

    // Constructor completo


    public UserGeneralDTO(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                          String secondName, String paternalSurname, String maternalSurname, String languagePref,
                          boolean onboardingDone, boolean isVerified, boolean isDeleted, List<RolGeneralDTO> roles,
                          ProfileGeneralDTO profile) {
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
        this.roles = roles;
        this.profile = profile;
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

    public boolean isOnboardingDone() {
        return onboardingDone;
    }

    public void setOnboardingDone(boolean onboardingDone) {
        this.onboardingDone = onboardingDone;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<RolGeneralDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolGeneralDTO> roles) {
        this.roles = roles;
    }

    public ProfileGeneralDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileGeneralDTO profile) {
        this.profile = profile;
    }
}
