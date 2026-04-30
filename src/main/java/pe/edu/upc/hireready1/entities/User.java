package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "personalEmail", length = 70, nullable = false)
    private String personalEmail;

    //Algortimo de encriptación: BCrypt (Spring Security), máximo 60 caracteres
    @Column(name = "passwordHash", length = 255, nullable = false)
    private String passwordHash;

    @Column(name = "firstName", length = 30, nullable = false)
    private String firstName;

    @Column(name = "secondName", length = 30, nullable = false)
    private String secondName;

    @Column(name = "paternalSurname", length = 50, nullable = false)
    private String paternalSurname;

    @Column(name = "maternalSurname", length = 50, nullable = false)
    private String maternalSurname;

    @Column(name = "languagePref", length = 20, nullable = false)
    private String languagePref;

    @Column(name = "onboardingDone", nullable = false)
    private Boolean onboardingDone;

    @Column(name = "isVerified", nullable = false)
    private Boolean isVerified;

    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

    // FetchType.EAGER permite que, al buscar un usuario, se haga un Join y se traigan tambien todos los roles del
    // usuario de forma automatica
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userRoles", //Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "userId"), //FK hacia User
            inverseJoinColumns = @JoinColumn(name = "rolId")) //FK hacia Rol
    private List<Rol> roles;

    /* //FK va aqui (con respecto a Tabla Rol)
    @ManyToOne
    @JoinColumn(name = "rolId", nullable = false)
    private Rol rol; */

    //mappedBy para que la relación sea bidireccional (es decir, que desde el objeto user se pueda acceder a profile)
    //CascadeType.ALL para que cuando se elimine un usuario, se borre automaticamente también su perfil
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public User() {
    }

    public User(Long userId, String dni, String personalEmail, String passwordHash, String firstName, String secondName,
                String paternalSurname, String maternalSurname, String languagePref, Boolean onboardingDone,
                Boolean isVerified, Boolean isDeleted, List<Rol> roles, Profile profile) {
        this.userId = userId;
        this.dni = dni;
        this.personalEmail = personalEmail;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.paternalSurname = paternalSurname;
        this.maternalSurname = maternalSurname;
        this.languagePref = languagePref;
        this.onboardingDone = onboardingDone;
        this.isVerified = isVerified;
        this.isDeleted = isDeleted;
        this.roles = roles;
        this.profile = profile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public Boolean isOnboardingDone() {
        return onboardingDone;
    }

    public void setOnboardingDone(Boolean onboardingDone) {
        this.onboardingDone = onboardingDone;
    }

    public Boolean isVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
