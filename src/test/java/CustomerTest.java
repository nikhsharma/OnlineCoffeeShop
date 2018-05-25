import models.stock.Misc;
import models.users.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    Misc misc;


    @Before
    public void before() throws Exception {
        customer = new Customer("Bob", "808");
        misc = new Misc(10.00, 10);
    }

    @Test
    public void canAddItemToCustomersBasket() {
        customer.addToBasket(misc);
        assertEquals(1, customer.stockInBasketCount());
    }
}
