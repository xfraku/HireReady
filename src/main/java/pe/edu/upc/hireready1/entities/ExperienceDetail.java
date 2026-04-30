package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ExperienceDetail")
public class ExperienceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileDetailId;

    @Column(name = "experienceYears", nullable = false)
    private int experienceYears;

    @Column(name = "companyName", length = 60, nullable = false)
    private String companyName;

    @Column(name = "jobTitle", length = 60, nullable = false)
    private String jobTitle; //Cargo de trabajo

    @Column(name = "jobDescription", length = 500, nullable = false)
    private String jobDescription;

    @Column(name = "jobProofUrl", length = 1000, nullable = false)
    private String jobProofUrl; //Certificado o algún documento que pruebe que trabajó en lo indicado

    //FK -> Muchos ProfileDetail pueden pertenecer a un solo Profile
    @ManyToOne
    @JoinColumn(name = "profileId", nullable = true)
    private Profile profile1;

    public ExperienceDetail() {
    }

    public ExperienceDetail(Long profileDetailId, int experienceYears, String companyName, String jobTitle,
                            String jobDescription, String jobProofUrl, Profile profile1) {
        this.profileDetailId = profileDetailId;
        this.experienceYears = experienceYears;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobProofUrl = jobProofUrl;
        this.profile1 = profile1;
    }

    public Long getProfileDetailId() {
        return profileDetailId;
    }

    public void setProfileDetailId(Long profileDetailId) {
        this.profileDetailId = profileDetailId;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobProofUrl() {
        return jobProofUrl;
    }

    public void setJobProofUrl(String jobProofUrl) {
        this.jobProofUrl = jobProofUrl;
    }

    public Profile getProfile1() {
        return profile1;
    }

    public void setProfile1(Profile profile1) {
        this.profile1 = profile1;
    }
}
