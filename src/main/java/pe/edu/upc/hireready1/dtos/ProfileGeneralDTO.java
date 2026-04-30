package pe.edu.upc.hireready1.dtos;

public class ProfileGeneralDTO {
    private Long profileId;
    private String profilePictureUrl;
    private String linkedinUrl;
    private String facebookUrl;
    private String career;
    private boolean hasExperience;
    private String eduInstitution;
    private String degree;
    private String curriculumUrl;

    // En lugar de enviar el objeto User completo
    private Long userId;

    // Constructor vacío
    public ProfileGeneralDTO() {}

    // Constructor completo
    public ProfileGeneralDTO(Long profileId, String profilePictureUrl, String linkedinUrl, String facebookUrl,
                      String career, boolean hasExperience, String eduInstitution,
                      String degree, String curriculumUrl, Long userId) {
        this.profileId = profileId;
        this.profilePictureUrl = profilePictureUrl;
        this.linkedinUrl = linkedinUrl;
        this.facebookUrl = facebookUrl;
        this.career = career;
        this.hasExperience = hasExperience;
        this.eduInstitution = eduInstitution;
        this.degree = degree;
        this.curriculumUrl = curriculumUrl;
        this.userId = userId;
    }

    // Getters y Setters

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
