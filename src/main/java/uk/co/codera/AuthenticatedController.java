package uk.co.codera;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController {

    private double balance = 10000.0;

    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public String balance() {
        return "Your balance is £" + String.format("%.02f", this.balance);
    }

    @RequestMapping(path = "/withdraw/{amount}", method = RequestMethod.GET)
    public String withdraw(@PathVariable("amount") double amount) {
        this.balance -= amount;
        return balance();
    }
}
