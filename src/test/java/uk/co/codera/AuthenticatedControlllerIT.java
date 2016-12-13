package uk.co.codera;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

public class AuthenticatedControlllerIT {

    @Test
    public void test() {
        get("/deposit").then().assertThat().body(containsString("Greeting from Spring Boot!"));
    }

}
