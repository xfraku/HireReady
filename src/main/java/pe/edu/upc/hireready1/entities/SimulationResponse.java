package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SimulationResponse")
public class SimulationResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;

    @Column(name = "AIHintUsed", nullable = false)
    private boolean AIHintUsed;

    @Column(name = "audioUrl", length = 1000, nullable = true)
    private String audioUrl;

    @Column(name = "contentMessages", length = 1000, nullable = true)
    private String contentMessages;

    @ManyToOne
    @JoinColumn(name = "responseTypeId")
    private ResponseType responseType;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public SimulationResponse() {
    }

    public SimulationResponse(Long responseId, boolean AIHintUsed, String audioUrl, String contentMessages,
                              ResponseType responseType, Question question) {
        this.responseId = responseId;
        this.AIHintUsed = AIHintUsed;
        this.audioUrl = audioUrl;
        this.contentMessages = contentMessages;
        this.responseType = responseType;
        this.question = question;
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public boolean isAIHintUsed() {
        return AIHintUsed;
    }

    public void setAIHintUsed(boolean AIHintUsed) {
        this.AIHintUsed = AIHintUsed;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getContentMessages() {
        return contentMessages;
    }

    public void setContentMessages(String contentMessages) {
        this.contentMessages = contentMessages;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
