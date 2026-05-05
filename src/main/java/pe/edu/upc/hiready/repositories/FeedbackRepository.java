package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    Optional<Feedback> findBySimResultResultId(Integer resultId);
    List<Feedback> findBySimResultSimulationUserUserId(Integer userId);
}
