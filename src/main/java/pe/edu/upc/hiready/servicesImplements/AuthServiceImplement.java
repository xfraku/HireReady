package pe.edu.upc.hiready.servicesImplements;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.hiready.dtos.auth.*;
import pe.edu.upc.hiready.entities.PasswordResetToken;
import pe.edu.upc.hiready.entities.Rol;
import pe.edu.upc.hiready.entities.User;
import pe.edu.upc.hiready.exceptions.ResourceNotFoundException;
import pe.edu.upc.hiready.repositories.PasswordResetTokenRepository;
import pe.edu.upc.hiready.repositories.RolRepository;
import pe.edu.upc.hiready.repositories.UserRepository;
import pe.edu.upc.hiready.security.JwtTokenProvider;
import pe.edu.upc.hiready.servicesInterfaces.IAuthService;
import pe.edu.upc.hiready.servicesInterfaces.IEmailService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthServiceImplement implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final IEmailService emailService;

    @Value("${app.base-url}")
    private String baseUrl;

    public AuthServiceImplement(AuthenticationManager authenticationManager,
                                UserRepository userRepository,
                                RolRepository rolRepository,
                                PasswordResetTokenRepository tokenRepository,
                                PasswordEncoder passwordEncoder,
                                JwtTokenProvider jwtTokenProvider,
                                IEmailService emailService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.emailService = emailService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtTokenProvider.generateToken(auth);

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        return new LoginResponse(token, user.getUserId(), user.getEmail(),
                user.getFirstName(), user.getLastName(),
                user.getRol() != null ? user.getRol().getRolType() : null);
    }

    @Override
    @Transactional
    public LoginResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Rol rol = null;
        if (request.getRolId() != null) {
            rol = rolRepository.findById(request.getRolId())
                    .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        } else { 
            // Lógica de asignación de rol: por defecto se asigna el rol de 'Estudiante' (ID: 1)
            rol = rolRepository.findById(1).orElse(null);
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRol(rol);
        user.setLanguagePref(request.getLanguagePref());
        user.setVerified(false);
        user.setDeleted(false);
        user.setOnboardingDone(false);

        User saved = userRepository.save(user);

        try {
            emailService.sendWelcomeEmail(saved.getEmail(), saved.getFirstName());
        } catch (Exception ignored) {}

        String token = jwtTokenProvider.generateTokenFromEmail(saved.getEmail());

        return new LoginResponse(token, saved.getUserId(), saved.getEmail(),
                saved.getFirstName(), saved.getLastName(),
                rol != null ? rol.getRolType() : null);
    }

    @Override
    @Transactional
    public void forgotPassword(ForgotPasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email no encontrado"));

        tokenRepository.deleteByUserUserId(user.getUserId());

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUser(user);
        resetToken.setExpiryDate(LocalDateTime.now().plusHours(1));
        resetToken.setUsed(false);
        tokenRepository.save(resetToken);

        String resetLink = baseUrl + "/auth/reset-password?token=" + token;
        emailService.sendPasswordResetEmail(user.getEmail(), resetLink);
    }

    @Override
    @Transactional
    public void resetPassword(ResetPasswordRequest request) {
        PasswordResetToken resetToken = tokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new IllegalArgumentException("Token inválido o expirado"));

        if (resetToken.getUsed() || resetToken.isExpired()) {
            throw new IllegalArgumentException("Token inválido o expirado");
        }

        User user = resetToken.getUser();
        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        resetToken.setUsed(true);
        tokenRepository.save(resetToken);
    }

    @Override
    @Transactional
    public void deleteAccount(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        user.setDeleted(true);
        userRepository.save(user);
    }
}
