package pe.edu.upc.hireready1.dtos;

public class ExperienceDetailGeneralDTO {
    private Long profileDetailId;
    private int experienceYears;
    private String companyName;
    private String jobTitle;
    private String jobDescription;
    private String jobProofUrl;
    private Long profileId;

    // Constructor vacío
    public ExperienceDetailGeneralDTO() {}

    // Constructor completo
    public ExperienceDetailGeneralDTO(Long profileDetailId, int experienceYears, String companyName, String jobTitle,
                                      String jobDescription, String jobProofUrl, Long profileId) {
        this.profileDetailId = profileDetailId;
        this.experienceYears = experienceYears;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobProofUrl = jobProofUrl;
        this.profileId = profileId;
    }

    // Getters y Setters
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
