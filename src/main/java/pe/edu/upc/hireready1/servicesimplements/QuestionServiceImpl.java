package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Question;
import pe.edu.upc.hireready1.repositories.IQuestionRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IQuestionService;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public List<Question> list() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> listById(Long id) {
        return questionRepository.findById((Long) id);
    }

    @Override
    public Question insert(Question q) {
        return questionRepository.save(q);
    }

    @Override
    public void update(Question q) {
        questionRepository.save(q);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById((Long) id);
    }
}
