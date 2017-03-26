package bank;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BankApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class AuthenticatedControlllerIT {

    private final double startingBalance = 10000.00;

    @Test
    public void shouldDisplayBalance() {
        get("/bank").then().assertThat()
                .body(containsString("Your balance is £" + String.format("%.02f", this.startingBalance)));
    }

    @Ignore
    @Test
    public void shouldWithdrawAmount() {
        final int amount = 20;
        post("/withdraw").then().assertThat()
                .body(containsString("Your balance is £" + String.format("%.02f", this.startingBalance - amount)));
    }

}
