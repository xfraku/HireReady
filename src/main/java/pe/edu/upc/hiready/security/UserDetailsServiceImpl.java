package pe.edu.upc.hiready.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.repositories.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario dedicado NO encontrado: " + email));

        if (Boolean.TRUE.equals(user.getDeleted())) {
            throw new UsernameNotFoundException("Cuenta eliminada: " + email);
        }

        String roleName = "ROLE_" + (user.getRol() != null ? user.getRol().getRolType().toUpperCase() : "USER");

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                List.of(new SimpleGrantedAuthority(roleName))
        );
    }
}
