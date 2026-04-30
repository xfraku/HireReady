package pe.edu.upc.hireready1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name = "questionType", length = 20, nullable = false)
    private String questionType;

    @Column(name = "questionContent", length = 150, nullable = false)
    private String questionContent;

    @ManyToOne
    @JoinColumn(name = "simulationId", nullable = false)
    private Simulation simulation;

    public Question() {
    }

    public Question(Long questionId, String questionType, String questionContent, Simulation simulation) {
        this.questionId = questionId;
        this.questionType = questionType;
        this.questionContent = questionContent;
        this.simulation = simulation;
    }

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

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
