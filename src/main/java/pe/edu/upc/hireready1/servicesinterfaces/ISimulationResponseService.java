package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.SimulationResponse;

import java.util.List;
import java.util.Optional;

public interface ISimulationResponseService {
    public SimulationResponse insert(SimulationResponse s);
    public List<SimulationResponse> list();
    public Optional<SimulationResponse> listById(Long id);
    public void update(SimulationResponse s);
    public void delete(Long id);
}
