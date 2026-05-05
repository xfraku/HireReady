package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.Simulation;

import java.util.List;

public interface SimulationRepository extends JpaRepository<Simulation, Integer> {
    List<Simulation> findByUserUserIdOrderBySimulationDateDesc(Integer userId);
    List<Simulation> findByUserUserIdAndStatus(Integer userId, String status);
}
