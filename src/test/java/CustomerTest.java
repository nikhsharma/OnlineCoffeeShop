import models.stock.Misc;
import models.users.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void canRemoveItemFromCustomersBasket() {
        customer.addToBasket(misc);
        customer.removeFromBasket(misc);
        assertEquals(0, customer.stockInBasketCount());
    }

    @Test
    public void canBuyBasketContents() {
        customer.addToBasket(misc);
        customer.addToBasket(misc);
        customer.purchase();
        assertEquals(1, customer.getPurchaseHistory().size());
        assertEquals(2, customer.getPurchaseHistory().get(0).size());
        assertEquals(0, customer.stockInBasketCount());
    }
}
