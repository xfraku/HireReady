package pe.edu.upc.hireready1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hireready1.entities.Applicant;

@Repository
public interface IApplicantRepository extends JpaRepository<Applicant, Long> {

}
