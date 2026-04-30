package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.ModelAnswer;

import java.util.List;
import java.util.Optional;

public interface IModelAnswerService {
    public ModelAnswer insert(ModelAnswer m);
    public List<ModelAnswer> list();
    public Optional<ModelAnswer> listById(Long id);
    public void update(ModelAnswer m);
    public void delete(Long id);
}