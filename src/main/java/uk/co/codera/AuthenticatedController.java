package uk.co.codera;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController {

    @RequestMapping(path = "/deposit", method = RequestMethod.GET)
    public String deposit() {
        return "Greeting from Spring Boot!";
    }
}
