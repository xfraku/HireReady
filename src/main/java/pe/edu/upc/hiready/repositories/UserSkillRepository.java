package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.UserSkill;

import java.util.List;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
    List<UserSkill> findByProfileProfileId(Integer profileId);
    void deleteByProfileProfileId(Integer profileId);
}
