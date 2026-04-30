package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "rolType", length = 10, nullable = false)
    private String rolType; // Admin o Aplicante/Mentor

    // Relación bidireccional: mappedBy apunta al nombre de la lista (roles) en la clase User
    // Además, mappedBy indica que esta entidad no es la dueña de la relación y evita que se cree otra tabla intermedia por error
    @ManyToMany(mappedBy = "roles")
    private List<User> usuarios;

    public Rol() {
    }

    public Rol(Long rolId, String rolType, List<User> usuarios) {
        this.rolId = rolId;
        this.rolType = rolType;
        this.usuarios = usuarios;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolType() {
        return rolType;
    }

    public void setRolType(String rolType) {
        this.rolType = rolType;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }
}
