package tacos.security;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import tacos.entity.User;

@Data
public class SignUpForm {
    @NotBlank(message = "Name is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName, street, city, state, zip, phoneNumber);
    }
}
