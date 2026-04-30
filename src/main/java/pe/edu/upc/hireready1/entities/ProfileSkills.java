package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProfileSkills")
public class ProfileSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(name = "skillName", length = 60, nullable = false)
    private String skillName;

    @Column(name = "skillType", length = 30, nullable = false)
    private String skillType;

    @Column(name = "skillDescription", length = 200, nullable = false)
    private String skillDescription;

    //Muchas habilidades pertenecen a un perfil
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    public ProfileSkills() {
    }

    public ProfileSkills(Long skillId, String skillName, String skillType, String skillDescription, Profile profile) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillDescription = skillDescription;
        this.profile = profile;
    }

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
