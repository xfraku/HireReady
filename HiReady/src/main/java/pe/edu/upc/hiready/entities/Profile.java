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
}
