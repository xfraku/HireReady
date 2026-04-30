package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    public Rol insert(Rol r);
    public List<Rol> list();
    public void update(Rol r);
    public void delete(Long id);
    public List<Rol> listByRolType(String rolType);
}
