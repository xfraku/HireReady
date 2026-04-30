package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.SimulationResult;
import pe.edu.upc.hireready1.repositories.ISimulationResultRepository;
import pe.edu.upc.hireready1.servicesinterfaces.ISimulationResultService;

import java.util.List;
import java.util.Optional;

@Service
public class SimulationResultServiceImpl implements ISimulationResultService {

    @Autowired
    private ISimulationResultRepository simulationResultRepository;

    @Override
    public List<SimulationResult> list() {
        return simulationResultRepository.findAll();
    }

    @Override
    public Optional<SimulationResult> listById(Long id) {
        return simulationResultRepository.findById((Long) id);
    }

    @Override
    public SimulationResult insert(SimulationResult s) {
        return simulationResultRepository.save(s);
    }

    @Override
    public void update(SimulationResult s) {
        simulationResultRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        simulationResultRepository.deleteById((Long) id);
    }
}
