package example.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String hello() {
        return "SELECT * FROM BUS";
    }

    @RequestMapping("/homepage")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

}
