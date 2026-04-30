package pe.edu.upc.hireready1.servicesinterfaces;

import pe.edu.upc.hireready1.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public User insert(User u);
    public List<User> list();
    public void update(User u);
    public void delete(Long id);
    public Optional<User> listById(Long id);
}
