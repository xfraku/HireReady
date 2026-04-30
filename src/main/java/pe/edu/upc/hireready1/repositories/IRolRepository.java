package pe.edu.upc.hireready1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.hireready1.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
    public List<Rol> findByTypeRol(String rolType);
    
}
