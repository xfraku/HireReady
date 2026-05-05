package pe.edu.upc.hiready.servicesInterfaces;

import pe.edu.upc.hiready.dtos.auth.*;

public interface IAuthService {
    LoginResponse login(LoginRequest request);
    LoginResponse register(RegisterRequest request);
    void forgotPassword(ForgotPasswordRequest request);
    void resetPassword(ResetPasswordRequest request);
    void deleteAccount(Integer userId);
}
