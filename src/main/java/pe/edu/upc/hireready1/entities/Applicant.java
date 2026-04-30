package pe.edu.upc.hireready1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Applicant")
@PrimaryKeyJoinColumn(name = "userId") //Esto le dice a JPA que el ID de Applicant se une al ID de User
public class Applicant extends User{
    @Column(name = "applicantId", unique = true, nullable = false)
    private Long applicantId;

    @Column(name = "universityName", length = 100, nullable = false)
    private String universityName;

    @Column(name = "universityEmail", length = 70, nullable = false)
    private String universityEmail;

    @Column(name = "universityCertificateUrl", length = 1000, nullable = false)
    private String universityCertificateUrl;

    public Applicant() {
    }

    //Constructor padre + hijo
    public Applicant(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                     String secondName, String paternalSurname, String maternalSurname, String languagePref,
                     boolean onboardingDone, boolean isVerified, boolean isDeleted, List<Rol> roles, Profile profile,
                     Long applicantId, String universityName, String universityEmail, String universityCertificateUrl) {
        //Llama a la clase padre User
        super(userId, dni, personalEmail, passwordHash, firstName, secondName, paternalSurname, maternalSurname,
                languagePref, onboardingDone, isVerified, isDeleted, roles, profile);

        //Inicializa atributos propios de Applicant
        this.applicantId = applicantId;
        this.universityName = universityName;
        this.universityEmail = universityEmail;
        this.universityCertificateUrl = universityCertificateUrl;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
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
