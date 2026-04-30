package pe.edu.upc.hireready1.dtos;

public class MentorGeneralDTO extends UserGeneralDTO {
    //private Long mentorId;
    //private Long userId;
    private String bachelorDegreeCertificateUrl;
    private String professionalDegreeCertificateUrl;
    private String workplaceName;
    private String workEmail;
    private String RUC;

    // Constructor vacío
    public MentorGeneralDTO() {}

    // Constructor completo
    public MentorGeneralDTO(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                            String secondName, String paternalSurname, String maternalSurname, String languagePref,
                            Boolean onboardingDone, Boolean isVerified, Boolean isDeleted, Long rolId, Long profileId,
                            String bachelorDegreeCertificateUrl, String professionalDegreeCertificateUrl,
                            String workplaceName, String workEmail, String RUC) {

        super(userId, dni, personalEmail, passwordHash, firstName, secondName, paternalSurname, maternalSurname,
                languagePref, onboardingDone, isVerified, isDeleted, rolId, profileId);

        this.bachelorDegreeCertificateUrl = bachelorDegreeCertificateUrl;
        this.professionalDegreeCertificateUrl = professionalDegreeCertificateUrl;
        this.workplaceName = workplaceName;
        this.workEmail = workEmail;
        this.RUC = RUC;
    }

    // Getters y Setters
    public String getBachelorDegreeCertificateUrl() {
        return bachelorDegreeCertificateUrl;
    }

    public void setBachelorDegreeCertificateUrl(String bachelorDegreeCertificateUrl) {
        this.bachelorDegreeCertificateUrl = bachelorDegreeCertificateUrl;
    }

    public String getProfessionalDegreeCertificateUrl() {
        return professionalDegreeCertificateUrl;
    }

    public void setProfessionalDegreeCertificateUrl(String professionalDegreeCertificateUrl) {
        this.professionalDegreeCertificateUrl = professionalDegreeCertificateUrl;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
}
