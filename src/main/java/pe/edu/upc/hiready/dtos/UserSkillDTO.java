package pe.edu.upc.hiready.dtos;

public class UserSkillDTO {
    private Integer userSkillId;
    private String skillName;
    private String skillDescription;
    private String skillType;

    public Integer getUserSkillId() { return userSkillId; }
    public void setUserSkillId(Integer userSkillId) { this.userSkillId = userSkillId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getSkillDescription() { return skillDescription; }
    public void setSkillDescription(String skillDescription) { this.skillDescription = skillDescription; }

    public String getSkillType() { return skillType; }
    public void setSkillType(String skillType) { this.skillType = skillType; }
}
