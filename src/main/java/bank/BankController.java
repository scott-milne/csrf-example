package bank;

import static bank.ResourcePath.BALANCE_PAGE;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankController {

    private Double balance = 10000.0;

    @GetMapping("/bank")
    public String get(Model model) {
        model.addAttribute("balance", this.balance);
        return BALANCE_PAGE;
    }

    @ResponseBody
    @PostMapping("/bank")
    public Double post(@RequestParam("withdraw") double withdrawl) {
        this.balance -= withdrawl;
        return this.balance;
    }
}
