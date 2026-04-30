package pe.edu.upc.hireready1.dtos;

public class ProfileSkillsGeneralDTO {
    private Long skillId;
    private String skillName;
    private String skillType;
    private String skillDescription;

    // En lugar del objeto Profile completo
    private Long profileId;

    // Constructor vacío
    public ProfileSkillsGeneralDTO() {}

    // Constructor completo
    public ProfileSkillsGeneralDTO(Long skillId, String skillName, String skillType,
                            String skillDescription, Long profileId) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillDescription = skillDescription;
        this.profileId = profileId;
    }

    // Getters y Setters

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
