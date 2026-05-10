package pe.edu.upc.hireready1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.hireready1.entities.User;
import pe.edu.upc.hireready1.repositories.IUserRepository;
import pe.edu.upc.hireready1.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User u) {
        return userRepository.save(u);
    }

    @Override
    public Optional<User> listId(int id) {
        return userRepository.findById((long) id);
    }

    @Override
    public void update(User u) {
        userRepository.save(u);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById((long) id);
    }
}
