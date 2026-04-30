package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Simulation;
import pe.edu.upc.hireready1.repositories.ISimulationRepository;
import pe.edu.upc.hireready1.servicesinterfaces.ISimulationService;

import java.util.List;
import java.util.Optional;

@Service
public class SimulationServiceImpl implements ISimulationService {

    @Autowired
    private ISimulationRepository simulationRepository;

    @Override
    public List<Simulation> list() {
        return simulationRepository.findAll();
    }

    @Override
    public Simulation insert(Simulation s) {
        return simulationRepository.save(s);
    }

    @Override
    public void update(Simulation s) {
        simulationRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        simulationRepository.deleteById((Long) id);
    }

    @Override
    public Optional<Simulation> listById(Long id) {
        return simulationRepository.findById((Long) id);
    }
}
