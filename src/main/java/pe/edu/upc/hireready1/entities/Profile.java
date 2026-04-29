package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "profilePictureUrl", length = 1000, nullable = false)
    private String profilePictureUrl;

    @Column(name = "linkedinUrl", length = 1000, nullable = false)
    private String linkedinUrl;

    @Column(name = "facebookUrl", length = 1000, nullable = false)
    private String facebookUrl;

    @Column(name = "career", length = 50, nullable = false)
    private String career;

    @Column(name = "hasExperience", nullable = false)
    private boolean hasExperience;

    @Column(name = "eduInstitution", length = 100, nullable = false)
    private String eduInstitution;

    @Column(name = "degree", length = 70, nullable = true)
    private String degree;

    @Column(name = "curriculumUrl", length = 1000, nullable = false)
    private String curriculumUrl;

    //La Foreign Key es definida aqui (Profile es el Dueño)
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Profile() {
    }

    public Profile(Long profileId, String profilePictureUrl, String linkedinUrl, String facebookUrl, String career,
                   boolean hasExperience, String eduInstitution, String degree, String curriculumUrl, User user) {
        this.profileId = profileId;
        this.profilePictureUrl = profilePictureUrl;
        this.linkedinUrl = linkedinUrl;
        this.facebookUrl = facebookUrl;
        this.career = career;
        this.hasExperience = hasExperience;
        this.eduInstitution = eduInstitution;
        this.degree = degree;
        this.curriculumUrl = curriculumUrl;
        this.user = user;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public boolean isHasExperience() {
        return hasExperience;
    }

    public void setHasExperience(boolean hasExperience) {
        this.hasExperience = hasExperience;
    }

    public String getEduInstitution() {
        return eduInstitution;
    }

    public void setEduInstitution(String eduInstitution) {
        this.eduInstitution = eduInstitution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCurriculumUrl() {
        return curriculumUrl;
    }

    public void setCurriculumUrl(String curriculumUrl) {
        this.curriculumUrl = curriculumUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
