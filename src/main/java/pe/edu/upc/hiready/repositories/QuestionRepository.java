package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.hiready.entities.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("SELECT q FROM Question q ORDER BY FUNCTION('RANDOM')")
    List<Question> findRandomQuestions(@Param("limit") int limit);
}
