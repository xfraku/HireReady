package pe.edu.upc.hireready1.dtos;

public class RolGeneralDTO {
    private Long rolId;
    private String rolType;
    private Long userId;

    // Constructor vacío
    public RolGeneralDTO() {}

    // Constructor completo
    public RolGeneralDTO(Long rolId, String rolType, Long userId) {
        this.rolId = rolId;
        this.rolType = rolType;
        this.userId = userId;
    }

    // Getters y Setters
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
