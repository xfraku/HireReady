package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.SimulationResponse;
import pe.edu.upc.hireready1.repositories.ISimulationResponseRepository;
import pe.edu.upc.hireready1.servicesinterfaces.ISimulationResponseService;

import java.util.List;
import java.util.Optional;

@Service
public class SimulationResponseServiceImpl implements ISimulationResponseService {

    @Autowired
    private ISimulationResponseRepository simulationResponseRepository;

    @Override
    public List<SimulationResponse> list() {
        return simulationResponseRepository.findAll();
    }

    @Override
    public SimulationResponse insert(SimulationResponse s) {
        return simulationResponseRepository.save(s);
    }

    @Override
    public Optional<SimulationResponse> listId(int id) {
        return simulationResponseRepository.findById((long) id);
    }

    @Override
    public void update(SimulationResponse s) {
        simulationResponseRepository.save(s);
    }

    @Override
    public void delete(int id) {
        simulationResponseRepository.deleteById((long) id);
    }
}
