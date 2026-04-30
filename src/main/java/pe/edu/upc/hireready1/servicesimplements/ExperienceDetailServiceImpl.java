package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.ExperienceDetail;
import pe.edu.upc.hireready1.repositories.IExperienceDetailRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IExperienceDetailService;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceDetailServiceImpl implements IExperienceDetailService {

    @Autowired
    private IExperienceDetailRepository experienceDetailRepository;

    @Override
    public List<ExperienceDetail> list() {
        return experienceDetailRepository.findAll();
    }

    @Override
    public ExperienceDetail insert(ExperienceDetail e) {
        return experienceDetailRepository.save(e);
    }

    @Override
    public Optional<ExperienceDetail> listId(int id) {
        return experienceDetailRepository.findById((long) id);
    }

    @Override
    public void update(ExperienceDetail e) {
        experienceDetailRepository.save(e);
    }

    @Override
    public void delete(int id) {
        experienceDetailRepository.deleteById((long) id);
    }
}
