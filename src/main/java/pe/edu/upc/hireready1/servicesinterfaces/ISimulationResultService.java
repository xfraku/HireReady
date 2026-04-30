package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.SimulationResult;

import java.util.List;
import java.util.Optional;

public interface ISimulationResultService {
    public SimulationResult insert(SimulationResult s);
    public List<SimulationResult> list();
    public Optional<SimulationResult> listById(Long id);
    public void update(SimulationResult s);
    public void delete(Long id);
}
