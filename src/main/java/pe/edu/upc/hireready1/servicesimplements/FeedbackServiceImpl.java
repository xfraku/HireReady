package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Feedback;
import pe.edu.upc.hireready1.repositories.IFeedbackRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IFeedbackService;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> list() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback insert(Feedback f) {
        return feedbackRepository.save(f);
    }

    @Override
    public Optional<Feedback> listId(int id) {
        return feedbackRepository.findById((long) id);
    }

    @Override
    public void update(Feedback f) {
        feedbackRepository.save(f);
    }

    @Override
    public void delete(int id) {
        feedbackRepository.deleteById((long) id);
    }
}
