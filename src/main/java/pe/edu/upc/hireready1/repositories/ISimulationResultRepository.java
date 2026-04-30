package pe.edu.upc.hireready1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hireready1.entities.SimulationResult;

@Repository
public interface ISimulationResultRepository extends JpaRepository<SimulationResult, Long> {

    // US25: Retorna el puntaje promedio global de cada usuario que pertenece a una misma carrera,
    // ordenado de mayor a menor para facilitar la comparación competitiva.
    // Cruza: SimulationResult → Simulation → User + Profile (join ad-hoc por asociación inversa)
    // Columnas del Object[]: [career, firstName, paternalSurname, avgOverallScore]
    @Query("SELECT p.career, u.firstName, u.paternalSurname, AVG(sr.overallScore) " +
            "FROM SimulationResult sr " +
            "JOIN sr.simulation s " +
            "JOIN s.user u " +
            "JOIN Profile p ON p.user = u " +
            "WHERE p.career = :career " +
            "GROUP BY p.career, u.userId, u.firstName, u.paternalSurname " +
            "ORDER BY AVG(sr.overallScore) DESC")
    List<Object[]> findAvgScoresByCareer(@Param("career") String career);

}
