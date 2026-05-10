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
    public Profile insert(Profile p) {
        return profileRepository.save(p);
    }

    @Override
    public Optional<Profile> listId(int id) {
        return profileRepository.findById((long) id);
    }

    @Override
    public void update(Profile p) {
        profileRepository.save(p);
    }

    @Override
    public void delete(int id) {
        profileRepository.deleteById((long) id);
    }
}
