package pe.edu.upc.hiready.dtos.auth;

public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String rol;

    public LoginResponse(String token, Integer userId, String email,
                         String firstName, String lastName, String rol) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rol = rol;
    }

    public String getToken() { return token; }
    public String getType() { return type; }
    public Integer getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRol() { return rol; }
}
