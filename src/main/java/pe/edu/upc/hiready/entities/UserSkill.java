package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user_skill")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_skill_id")
    private Integer userSkillId;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "skill_name", nullable = false, length = 100)
    private String skillName;

    @Column(name = "skill_description", columnDefinition = "TEXT")
    private String skillDescription;

    @Column(name = "skill_type", length = 50)
    private String skillType;

    public UserSkill() {
    }

    public Integer getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(Integer userSkillId) {
        this.userSkillId = userSkillId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
