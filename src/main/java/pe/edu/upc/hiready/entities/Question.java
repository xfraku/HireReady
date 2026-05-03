package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "model_answer_id", nullable = true)
    private ModelAnswer modelAnswer;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    public Question() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public ModelAnswer getModelAnswer() {
        return modelAnswer;
    }

    public void setModelAnswer(ModelAnswer modelAnswer) {
        this.modelAnswer = modelAnswer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
