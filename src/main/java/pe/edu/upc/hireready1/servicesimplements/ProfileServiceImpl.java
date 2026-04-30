package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Profile;
import pe.edu.upc.hireready1.repositories.IProfileRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IProfileService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements IProfileService {

    @Autowired
    private IProfileRepository profileRepository;

    @Override
    public List<Profile> list() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> listById(Long id) {
        return profileRepository.findById((Long) id);
    }

    @Override
    public Profile insert(Profile p) {
        return profileRepository.save(p);
    }

    @Override
    public void update(Profile p) {
        profileRepository.save(p);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById((Long) id);
    }
}
