package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.User;

public interface UserRepository extends JpaRepository <User, Integer> {
}
