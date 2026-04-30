package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Mentor;

import java.util.List;
import java.util.Optional;

public interface IMentorService {
    public Mentor insert(Mentor m);
    public List<Mentor> list();
    public Optional<Mentor> listById(Long id);
    public void update(Mentor m);
    public void delete(Long id);
}
