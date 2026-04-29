package pe.edu.upc.hiready.serivesImplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.dtos.RolDTO;
import pe.edu.upc.hiready.entities.Rol;
import pe.edu.upc.hiready.repositories.RolRepository;
import pe.edu.upc.hiready.servicesInterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImplement implements IRolService {
    private final RolRepository rolRepository;

    public RolServiceImplement(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    @Override
    public RolDTO save(RolDTO dto) {
        Rol rol = new Rol();
        rol.setRolType(dto.getRolType());

        Rol saved = rolRepository.save(rol);
        dto.setRolId(saved.getRolId());
        return dto;
    }

    @Override
    public List<RolDTO> list() {
        return rolRepository.findAll().stream().map(rol -> {
            RolDTO dto = new RolDTO();
            dto.setRolId(rol.getRolId());
            dto.setRolType(rol.getRolType());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public RolDTO update(Integer id, RolDTO dto) {
        Rol rol = rolRepository.findById(id).orElseThrow();
        rol.setRolType(dto.getRolType());

        Rol updated = rolRepository.save(rol);

        dto.setRolId(updated.getRolId());
        return dto;
    }

    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }
}
