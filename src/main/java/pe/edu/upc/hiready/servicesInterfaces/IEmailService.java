package pe.edu.upc.hiready.servicesInterfaces;

public interface IEmailService {
    void sendPasswordResetEmail(String to, String resetLink);
    void sendWelcomeEmail(String to, String firstName);
}
