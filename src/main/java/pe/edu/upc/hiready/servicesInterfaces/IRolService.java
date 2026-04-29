package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.RolDTO;
import java.util.List;

public interface IRolService {
    RolDTO save(RolDTO dto);
    List<RolDTO> list();
    RolDTO update(Integer id, RolDTO dto);
    void delete(Integer id);
}
