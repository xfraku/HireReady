package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {
    public Question insert(Question q);
    public List<Question> list();
    public Optional<Question> listById(Long id);
    public void update(Question q);
    public void delete(Long id);
}
