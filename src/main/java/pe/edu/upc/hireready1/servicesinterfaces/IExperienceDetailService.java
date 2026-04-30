package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.ExperienceDetail;

import java.util.List;
import java.util.Optional;

public interface IExperienceDetailService {
    public ExperienceDetail insert(ExperienceDetail e);
    public List<ExperienceDetail> list();
    public Optional<ExperienceDetail> listById(Long id);
    public void update(ExperienceDetail e);
    public void delete(Long id);
}