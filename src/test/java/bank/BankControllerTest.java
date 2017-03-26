package bank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class BankControllerTest {

    private BankController bankController;

    private final double STARTING_BALANCE = 10000.0;

    @Before
    public void setup() {
        this.bankController = new BankController();
    }

    @Test
    public void shouldReturnBankPageOnGet() {
        assertThat(this.bankController.get(new ExtendedModelMap()), is(ResourcePath.BALANCE_PAGE));
    }

    @Test
    public void shouldAddBalanceAttributeToModelOnGet() {
        ExtendedModelMap model = new ExtendedModelMap();
        this.bankController.get(model);

        assertThat(model.containsAttribute("balance"), is(true));
    }

    @Test
    public void shouldSetBalanceToStartingBalanceOnGet() {
        ExtendedModelMap model = new ExtendedModelMap();
        this.bankController.get(model);

        assertThat((double) (model.get("balance")), is(this.STARTING_BALANCE));
    }

    @Test
    public void shouldDecrementBalanceOnPost() {
        double withdrawAmount = 1234.56;
        assertThat(this.bankController.post(withdrawAmount), is(this.STARTING_BALANCE - withdrawAmount));
    }
}
