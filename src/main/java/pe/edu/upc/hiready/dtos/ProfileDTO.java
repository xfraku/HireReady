package pe.edu.upc.hiready.dtos;

import java.util.List;

public class ProfileDTO {
    private Integer profileId;
    private Integer userId;
    private String linkedinUrl;
    private String facebookUrl;
    private String career;
    private String experience;
    private Integer experienceYears;
    private String eduInstitution;
    private String degree;
    private List<UserSkillDTO> skills;

    public Integer getProfileId() { return profileId; }
    public void setProfileId(Integer profileId) { this.profileId = profileId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getLinkedinUrl() { return linkedinUrl; }
    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public String getFacebookUrl() { return facebookUrl; }
    public void setFacebookUrl(String facebookUrl) { this.facebookUrl = facebookUrl; }

    public String getCareer() { return career; }
    public void setCareer(String career) { this.career = career; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public Integer getExperienceYears() { return experienceYears; }
    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }

    public String getEduInstitution() { return eduInstitution; }
    public void setEduInstitution(String eduInstitution) { this.eduInstitution = eduInstitution; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public List<UserSkillDTO> getSkills() { return skills; }
    public void setSkills(List<UserSkillDTO> skills) { this.skills = skills; }
}
