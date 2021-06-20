package tacos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.UserRepository;
import tacos.entity.User;
import tacos.security.SignUpForm;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String signUpForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUpForm";
    }

    @PostMapping
    public String processSignUp(@Valid SignUpForm signUpForm, Errors errors) {
        if (errors.hasErrors()) {
            return "signUpForm";
        }
        User user = signUpForm.toUser(passwordEncoder);
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "signUpForm";
        };
        userRepository.save(user);
        return "redirect:/login";
    }
}
