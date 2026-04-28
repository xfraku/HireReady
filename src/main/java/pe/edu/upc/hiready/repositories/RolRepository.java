package pe.edu.upc.hiready.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.hiready.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
