package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.ModelAnswer;
import pe.edu.upc.hireready1.repositories.IModelAnswerRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IModelAnswerService;

import java.util.List;
import java.util.Optional;

@Service
public class ModelAnswerServiceImpl implements IModelAnswerService {

    @Autowired
    private IModelAnswerRepository modelAnswerRepository;

    @Override
    public List<ModelAnswer> list() {
        return modelAnswerRepository.findAll();
    }

    @Override
    public Optional<ModelAnswer> listById(Long id) {
        return modelAnswerRepository.findById((Long) id);
    }

    @Override
    public ModelAnswer insert(ModelAnswer m) {
        return modelAnswerRepository.save(m);
    }

    @Override
    public void update(ModelAnswer m) {
        modelAnswerRepository.save(m);
    }

    @Override
    public void delete(Long id) {
        modelAnswerRepository.deleteById((Long) id);
    }
}
