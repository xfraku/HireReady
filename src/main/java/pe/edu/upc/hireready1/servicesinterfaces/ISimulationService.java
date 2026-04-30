package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Simulation;

import java.util.List;
import java.util.Optional;

public interface ISimulationService {
    public Simulation insert(Simulation s);
    public List<Simulation> list();
    public Optional<Simulation> listById(Long id);
    public void update(Simulation s);
    public void delete(Long id);
}
