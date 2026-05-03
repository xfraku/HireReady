package pe.edu.upc.hiready.servicesImplements;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pe.edu.upc.hiready.servicesInterfaces.IEmailService;

@Service
public class EmailServiceImplement implements IEmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImplement(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendPasswordResetEmail(String to, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("HireReady - Recuperación de contraseña");
        message.setText("Haz clic en el siguiente enlace para restablecer tu contraseña:\n\n" + resetLink
                + "\n\nEste enlace expira en 1 hora.\n\nSi no solicitaste esto, ignora este correo.");
        mailSender.send(message);
    }

    @Override
    public void sendWelcomeEmail(String to, String firstName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("¡Bienvenido a HireReady, " + firstName + "!");
        message.setText("Hola " + firstName + ",\n\nTu cuenta ha sido creada exitosamente en HireReady.\n"
                + "Comienza practicando tus entrevistas con IA y mejora tus habilidades profesionales.\n\n"
                + "¡Mucho éxito!\n\nEl equipo de HireReady");
        mailSender.send(message);
    }
}
