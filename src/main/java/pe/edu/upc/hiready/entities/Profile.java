package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "linkedin_url", length = 255)
    private String linkedinUrl;

    @Column(name = "facebook_url", length = 255)
    private String facebookUrl;

    @Column(name = "career", nullable = false, length = 100)
    private String career;

    @Column(name = "experience", columnDefinition = "TEXT")
    private String experience;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "edu_institution", length = 100)
    private String eduInstitution;

    @Column(name = "degree", length = 100)
    private String degree;

    public Profile() {}

    public Integer getProfileId() { return profileId; }
    public void setProfileId(Integer profileId) { this.profileId = profileId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

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
}
