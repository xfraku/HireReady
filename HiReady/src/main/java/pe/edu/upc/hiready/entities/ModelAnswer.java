package pe.edu.upc.hiready.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "model_answer")
public class ModelAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_answer_id")
    private Integer modelAnswerId;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    public ModelAnswer() {
    }

    public Integer getModelAnswerId() {
        return modelAnswerId;
    }

    public void setModelAnswerId(Integer modelAnswerId) {
        this.modelAnswerId = modelAnswerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
