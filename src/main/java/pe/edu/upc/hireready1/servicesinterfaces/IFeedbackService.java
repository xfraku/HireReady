package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Feedback;

import java.util.List;
import java.util.Optional;

public interface IFeedbackService {
    public Feedback insert(Feedback f);
    public List<Feedback> list();
    public Optional<Feedback> listById(Long id);
    public void update(Feedback f);
    public void delete(Long id);
}
