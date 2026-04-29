package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ModelAnswer")
public class ModelAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelAnswerId;

    @Column(name = "answerContent", length = 500, nullable = false)
    private String answerContent;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    public ModelAnswer() {
    }

    public ModelAnswer(Long modelAnswerId, String answerContent, Question question) {
        this.modelAnswerId = modelAnswerId;
        this.answerContent = answerContent;
        this.question = question;
    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
