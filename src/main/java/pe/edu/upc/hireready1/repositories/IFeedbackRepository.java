package pe.edu.upc.hireready1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hireready1.entities.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Long> {
// US24 / US37: Retorna el historial completo de simulaciones de un usuario
    // incluyendo puntajes del resultado y feedback, ordenado por fecha descendente.
    // Cruza: Feedback → SimulationResult → Simulation → User
    @Query("SELECT f FROM Feedback f " +
            "JOIN f.simResult sr " +
            "JOIN sr.simulation s " +
            "JOIN s.user u " +
            "WHERE u.userId = :userId " +
            "ORDER BY s.simulationDate DESC")
    List<Feedback> findFeedbackHistoryByUserId(@Param("userId") Long userId);
}
