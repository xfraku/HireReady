package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.ProfileSkills;

import java.util.List;
import java.util.Optional;

public interface IProfileSkillsService {
    public ProfileSkills insert(ProfileSkills p);
    public List<ProfileSkills> list();
    public Optional<ProfileSkills> listById(Long id);
    public void update(ProfileSkills p);
    public void delete(Long id);
}
