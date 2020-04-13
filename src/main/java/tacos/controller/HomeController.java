package tacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${spring.message}")
    private String message;

    @GetMapping("/")
    public String homePage()
    {
        return "home";
    }
}
