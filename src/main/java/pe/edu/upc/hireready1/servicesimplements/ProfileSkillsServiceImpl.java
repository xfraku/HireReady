package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.ProfileSkills;
import pe.edu.upc.hireready1.repositories.IProfileSkillsRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IProfileSkillsService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileSkillsServiceImpl implements IProfileSkillsService {

    @Autowired
    private IProfileSkillsRepository profileSkillsRepository;

    @Override
    public List<ProfileSkills> list() {
        return profileSkillsRepository.findAll();
    }

    @Override
    public Optional<ProfileSkills> listById(Long id) {
        return profileSkillsRepository.findById((Long) id);
    }

    @Override
    public ProfileSkills insert(ProfileSkills p) {
        return profileSkillsRepository.save(p);
    }

    @Override
    public void update(ProfileSkills p) {
        profileSkillsRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        profileSkillsRepository.deleteById((Long) id);
    }
}
