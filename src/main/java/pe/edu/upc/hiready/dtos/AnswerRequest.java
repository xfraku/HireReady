package pe.edu.upc.hiready.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AnswerRequest {
    @NotNull
    private Integer questionId;

    @NotBlank
    private String responseContent;

    private Boolean aiHintUsed = false;

    public Integer getQuestionId() { return questionId; }
    public void setQuestionId(Integer questionId) { this.questionId = questionId; }

    public String getResponseContent() { return responseContent; }
    public void setResponseContent(String responseContent) { this.responseContent = responseContent; }

    public Boolean getAiHintUsed() { return aiHintUsed; }
    public void setAiHintUsed(Boolean aiHintUsed) { this.aiHintUsed = aiHintUsed; }
}
