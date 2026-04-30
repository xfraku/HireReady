package pe.edu.upc.hireready1.dtos;

public class ApplicantGeneralDTO extends UserGeneralDTO {
    private String universityName;
    private String universityEmail;
    private String universityCertificateUrl;

    // Constructor vacío
    public ApplicantGeneralDTO() {}

    // Constructor completo
    public ApplicantGeneralDTO(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                               String secondName, String paternalSurname, String maternalSurname, String languagePref,
                               Boolean onboardingDone, Boolean isVerified, Boolean isDeleted, Long rolId,
                               Long profileId, String universityName, String universityEmail,
                               String universityCertificateUrl) {

        super(userId, dni, personalEmail, passwordHash, firstName, secondName, paternalSurname, maternalSurname,
                languagePref, onboardingDone, isVerified, isDeleted, rolId, profileId);

        this.universityName = universityName;
        this.universityEmail = universityEmail;
        this.universityCertificateUrl = universityCertificateUrl;
    }

    // Getters y Setters

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
