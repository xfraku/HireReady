package pe.edu.upc.hiready.serivesImplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.entities.Rol;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.repositories.RolRepository;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.dtos.UserDTO;
import pe.edu.upc.hiready.servicesInterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements IUserService {
    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    public UserServiceImplement(UserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }
    @Override
    public UserDTO save(UserDTO dto) {
        Rol rol = rolRepository.findById(dto.getRolId()).orElseThrow();

        User user = new User();
        user.setRol(rol);
        user.setEmail(dto.getEmail());

        User saved = userRepository.save(user);

        dto.setUserId(saved.getUserId());
        return dto;
    }

    @Override
    public List<UserDTO> list() {
        return userRepository.findAll().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setRolId(user.getRol().getRolId());
            dto.setEmail(user.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();

        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setRolId(user.getRol().getRolId());
        dto.setEmail(user.getEmail());
        return dto;
    }

    @Override
    public UserDTO update(Integer id, UserDTO dto) {
        User user = userRepository.findById(id).orElseThrow();
        Rol rol = rolRepository.findById(dto.getRolId()).orElseThrow();

        user.setRol(rol);
        user.setEmail(dto.getEmail());

        User updated = userRepository.save(user);

        dto.setUserId(updated.getUserId());
        return dto;
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
