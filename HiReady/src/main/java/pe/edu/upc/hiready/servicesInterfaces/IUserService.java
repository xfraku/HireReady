package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.UserDTO;
import java.util.List;

public interface IUserService {
    UserDTO save(UserDTO dto);
    List<UserDTO> list();
    UserDTO findById(Integer id);
    UserDTO update(Integer id, UserDTO dto);
    void delete(Integer id);
}
