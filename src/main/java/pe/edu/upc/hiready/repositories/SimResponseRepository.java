package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.SimResponse;

import java.util.List;

public interface SimResponseRepository extends JpaRepository<SimResponse, Integer> {
    List<SimResponse> findBySimulationSimulationId(Integer simulationId);
    long countBySimulationSimulationId(Integer simulationId);
}
