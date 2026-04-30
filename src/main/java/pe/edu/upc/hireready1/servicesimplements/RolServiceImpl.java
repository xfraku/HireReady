package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.Rol;
import pe.edu.upc.hireready1.repositories.IRolRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> list() {
        return rolRepository.findAll();
    }

    @Override
    public Rol insert(Rol r) {
        return rolRepository.save(r);
    }

    @Override
    public Optional<Rol> listId(int id) {
        return rolRepository.findById((long) id);
    }

    @Override
    public void update(Rol r) {
        rolRepository.save(r);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById((long) id);
    }
}
