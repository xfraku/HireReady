package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface IProfileService {
    public Profile insert(Profile p);
    public List<Profile> list();
    public Optional<Profile> listById(Long id);
    public void update(Profile p);
    public void delete(Long id);
}
