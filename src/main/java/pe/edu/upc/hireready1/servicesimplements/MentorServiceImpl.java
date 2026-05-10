package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Mentor;
import pe.edu.upc.hireready1.repositories.IMentorRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IMentorService;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements IMentorService {

    @Autowired
    private IMentorRepository mentorRepository;

    @Override
    public List<Mentor> list() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor insert(Mentor m) {
        return mentorRepository.save(m);
    }

    @Override
    public Optional<Mentor> listId(int id) {
        return mentorRepository.findById((long) id);
    }

    @Override
    public void update(Mentor m) {
        mentorRepository.save(m);
    }

    @Override
    public void delete(int id) {
        mentorRepository.deleteById((long) id);
    }
}
