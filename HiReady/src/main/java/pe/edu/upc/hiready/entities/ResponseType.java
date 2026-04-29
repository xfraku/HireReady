package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "response_type")
public class ResponseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_type_id")
    private Integer responseTypeId;

    @OneToOne
    @JoinColumn(name = "response_id", nullable = false)
    private SimResponse simResponse;

    @Column(name = "response_type_name", nullable = false, length = 50)
    private String responseTypeName;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "audio", length = 255)
    private String audio;

    public ResponseType() {
    }

    public Integer getResponseTypeId() {
        return responseTypeId;
    }

    public void setResponseTypeId(Integer responseTypeId) {
        this.responseTypeId = responseTypeId;
    }

    public SimResponse getSimResponse() {
        return simResponse;
    }

    public void setSimResponse(SimResponse simResponse) {
        this.simResponse = simResponse;
    }

    public String getResponseTypeName() {
        return responseTypeName;
    }

    public void setResponseTypeName(String responseTypeName) {
        this.responseTypeName = responseTypeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
