package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.hiready.entities.SimResult;

import java.util.List;
import java.util.Optional;

public interface SimResultRepository extends JpaRepository<SimResult, Integer> {
    Optional<SimResult> findBySimulationSimulationId(Integer simulationId);
    List<SimResult> findBySimulationUserUserIdOrderByResultDateDesc(Integer userId);
// Query personalizada para obtener el ranking de candidatos con mejor desempeño (Score >= 80)
    @Query("""
        SELECT u.userId, u.firstName, u.lastName, sr.overallScore
        FROM User u
        JOIN Simulation s ON u.userId = s.user.userId
        JOIN SimResult sr ON s.simulationId = sr.simulation.simulationId
        WHERE sr.overallScore >= 80
        ORDER BY sr.overallScore DESC
    """)
    List<Object[]> getTopCandidates();

    @Query("""
    SELECT u.userId, u.firstName, u.lastName, sr.technicalScore
    FROM SimResult sr
    JOIN sr.simulation s
    JOIN s.user u
    WHERE sr.technicalScore < 60
    ORDER BY sr.technicalScore ASC
""")
    List<Object[]> getLowTechnicalUsers();

    @Query(value = "SELECT TO_CHAR(s.simulation_date, 'YYYY-MM') as mes, AVG(sr.overall_score) as promedio " +
               "FROM simulation s JOIN sim_result sr ON s.simulation_id = sr.simulation_id " +
               "WHERE s.user_id = :userId " +
               "GROUP BY TO_CHAR(s.simulation_date, 'YYYY-MM') ORDER BY mes ASC", nativeQuery = true)
List<Object[]> avgScoreByMonth(@Param("userId") int userId);

@Query(value = "SELECT s.simulation_id, f.frequent_errors, f.recommendation " +
               "FROM simulation s " +
               "JOIN sim_result sr ON s.simulation_id = sr.simulation_id " +
               "JOIN feedback f ON sr.result_id = f.result_id " +
               "WHERE s.user_id = :userId", nativeQuery = true)
List<Object[]> findFeedbackByUser(@Param("userId") int userId);
    
}
