package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hiready.entities.ModelAnswer;

@Repository
public interface ModelAnswerRepository extends JpaRepository<ModelAnswer, Integer> {
}
