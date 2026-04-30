package pe.edu.upc.hireready1.dtos;

public class ModelAnswerGeneralDTO {
    private Long modelAnswerId;
    private String answerContent;

    // En lugar de enviar el objeto Question completo
    private Long questionId;

    // Constructor vacío
    public ModelAnswerGeneralDTO() {}

    // Constructor completo
    public ModelAnswerGeneralDTO(Long modelAnswerId, String answerContent, Long questionId) {
        this.modelAnswerId = modelAnswerId;
        this.answerContent = answerContent;
        this.questionId = questionId;
    }

    // Getters y Setters

    public Long getModelAnswerId() {
        return modelAnswerId;
    }

    public void setModelAnswerId(Long modelAnswerId) {
        this.modelAnswerId = modelAnswerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
