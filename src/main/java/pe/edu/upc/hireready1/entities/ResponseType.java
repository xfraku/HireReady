package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ResponseType")
public class ResponseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseTypeId;

    @Column(name = "responseTypeName", length = 10, nullable = false)
    private String responseTypeName;

    public ResponseType() {
    }

    public ResponseType(Long responseTypeId, String responseTypeName) {
        this.responseTypeId = responseTypeId;
        this.responseTypeName = responseTypeName;
    }

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
