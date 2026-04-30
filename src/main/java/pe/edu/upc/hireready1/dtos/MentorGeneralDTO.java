package pe.edu.upc.hireready1.dtos;

public class MentorGeneralDTO {
    private Long mentorId;
    private Long userId;
    private String bachelorDegreeCertificateUrl;
    private String professionalDegreeCertificateUrl;
    private String workplaceName;
    private String workEmail;
    private String RUC;

    // Constructor vacío
    public MentorGeneralDTO() {}

    // Constructor completo
    public MentorGeneralDTO(Long mentorId, Long userId, String bachelorDegreeCertificateUrl,
                            String professionalDegreeCertificateUrl, String workplaceName, String workEmail,
                            String RUC) {

        this.mentorId = mentorId;
        this.userId = userId;
        this.bachelorDegreeCertificateUrl = bachelorDegreeCertificateUrl;
        this.professionalDegreeCertificateUrl = professionalDegreeCertificateUrl;
        this.workplaceName = workplaceName;
        this.workEmail = workEmail;
        this.RUC = RUC;
    }

    // Getters y Setters
    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
