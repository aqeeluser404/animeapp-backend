package za.org.animeapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping({"/", "/home"})
    String index() {
        return "Welcome Weeb!";
    }
}
