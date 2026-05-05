package pe.edu.upc.hireready1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hireready1.entities.ProfileSkills;

@Repository
public interface IProfileSkillsRepository extends JpaRepository<ProfileSkills, Long> {

}
