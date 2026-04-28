package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.hiready.entities.SimResult;

import java.util.List;

public interface SimResultRepository extends JpaRepository<SimResult, Integer> {

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
}