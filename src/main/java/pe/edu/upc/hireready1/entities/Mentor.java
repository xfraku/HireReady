package pe.edu.upc.hireready1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Mentor")
@PrimaryKeyJoinColumn(name = "userId")
public class Mentor extends User {
    @Column(name = "mentorId", unique = true, nullable = false)
    private Long mentorId;

    @Column(name = "bachelorDegreeCertificateUrl", length = 1000, nullable = false)
    private String bachelorDegreeCertificateUrl;

    @Column(name = "professionalDegreeCertificateUrl", length = 1000, nullable = false)
    private String professionalDegreeCertificateUrl;

    @Column(name = "workplaceName", length = 50, nullable = false)
    private String workplaceName;

    @Column(name = "workEmail", length = 70, nullable = false)
    private String workEmail;

    @Column(name = "RUC", length = 11, nullable = true)
    private String RUC;

    //Constructor padre + hijo
    public Mentor(Long userId, String dni, String personalEmail, String passwordHash, String firstName,
                  String secondName, String paternalSurname, String maternalSurname, String languagePref,
                  boolean onboardingDone, boolean isVerified, boolean isDeleted, List<Rol> roles, Profile profile,
                  Long mentorId, String bachelorDegreeCertificateUrl, String professionalDegreeCertificateUrl,
                  String workplaceName, String workEmail, String RUC) {

        super(userId, dni, personalEmail, passwordHash, firstName, secondName, paternalSurname, maternalSurname,
                languagePref, onboardingDone, isVerified, isDeleted, roles, profile);

        this.mentorId = mentorId;
        this.bachelorDegreeCertificateUrl = bachelorDegreeCertificateUrl;
        this.professionalDegreeCertificateUrl = professionalDegreeCertificateUrl;
        this.workplaceName = workplaceName;
        this.workEmail = workEmail;
        this.RUC = RUC;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
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
