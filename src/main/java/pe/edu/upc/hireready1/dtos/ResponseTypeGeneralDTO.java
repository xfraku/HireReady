package pe.edu.upc.hireready1.dtos;

public class ResponseTypeGeneralDTO {
    private Long responseTypeId;
    private String responseTypeName;

    // Constructor vacío
    public ResponseTypeGeneralDTO() {}

    // Constructor completo
    public ResponseTypeGeneralDTO(Long responseTypeId, String responseTypeName) {
        this.responseTypeId = responseTypeId;
        this.responseTypeName = responseTypeName;
    }

    // Getters y Setters
    public Long getResponseTypeId() {
        return responseTypeId;
    }

    public void setResponseTypeId(Long responseTypeId) {
        this.responseTypeId = responseTypeId;
    }

    public String getResponseTypeName() {
        return responseTypeName;
    }

    public void setResponseTypeName(String responseTypeName) {
        this.responseTypeName = responseTypeName;
    }
}
