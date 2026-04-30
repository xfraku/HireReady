package pe.edu.upc.hireready1.dtos;

public class ApplicantGeneralDTO {
    private Long applicantId;
    private Long userId;
    private String universityName;
    private String universityEmail;
    private String universityCertificateUrl;

    // Constructor vacío
    public ApplicantGeneralDTO() {}

    // Constructor completo
    public ApplicantGeneralDTO(Long applicantId, Long userId, String universityName, String universityEmail,
                               String universityCertificateUrl) {
        this.applicantId = applicantId;
        this.userId = userId;
        this.universityName = universityName;
        this.universityEmail = universityEmail;
        this.universityCertificateUrl = universityCertificateUrl;
    }

    // Getters y Setters
    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
    }

    public String getUniversityCertificateUrl() {
        return universityCertificateUrl;
    }

    public void setUniversityCertificateUrl(String universityCertificateUrl) {
        this.universityCertificateUrl = universityCertificateUrl;
    }
}
