package pe.edu.upc.hireready1.dtos;

public class SimulationResponseGeneralDTO {
    private Long responseId;
    private boolean AIHintUsed;
    private String audioUrl;
    private String contentMessages;

    // Relaciones convertidas a IDs
    private Long responseTypeId;
    private Long questionId;

    // Constructor vacío
    public SimulationResponseGeneralDTO() {}

    // Constructor completo
    public SimulationResponseGeneralDTO(Long responseId, boolean AIHintUsed, String audioUrl,
                                 String contentMessages, Long responseTypeId, Long questionId) {
        this.responseId = responseId;
        this.AIHintUsed = AIHintUsed;
        this.audioUrl = audioUrl;
        this.contentMessages = contentMessages;
        this.responseTypeId = responseTypeId;
        this.questionId = questionId;
    }

    // Getters y Setters

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

    public Long getResponseTypeId() {
        return responseTypeId;
    }

    public void setResponseTypeId(Long responseTypeId) {
        this.responseTypeId = responseTypeId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
