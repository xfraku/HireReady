package pe.edu.upc.hireready1.dtos;

public class QuestionGeneralDTO {
    private Long questionId;
    private String questionType;
    private String questionContent;

    // En lugar del objeto Simulation completo
    private Long simulationId;

    // Constructor vacío
    public QuestionGeneralDTO() {}

    // Constructor completo
    public QuestionGeneralDTO(Long questionId, String questionType, String questionContent, Long simulationId) {
        this.questionId = questionId;
        this.questionType = questionType;
        this.questionContent = questionContent;
        this.simulationId = simulationId;
    }

    // Getters y Setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Long getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Long simulationId) {
        this.simulationId = simulationId;
    }
}
