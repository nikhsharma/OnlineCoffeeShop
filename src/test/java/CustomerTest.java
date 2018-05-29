
import models.stock.Order;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {

   Customer customer;
   private Stock stock;
   Order order;

    @Before
    public void before() {
        customer = new Customer("Bob", "808");
        stock = new Stock("Java beans", StockType.COFFEE, 10.00, 5);
    }



    @Test
    public void canAddItemToCustomersBasket() {
        customer.addToBasket(stock, 2);
        assertEquals(1, customer.stockInBasketCount());
    }

    @Test
    public void canRemoveItemFromCustomersBasket() {
        customer.addToBasket(stock, 2);
        customer.removeFromBasket(stock);
        assertEquals(0, customer.stockInBasketCount());
    }

    @Test
    public void canBuyBasketContents() {
        customer.addToBasket(stock, 2);
        customer.addToBasket(stock, 2);
        customer.purchase();
        assertEquals(1, customer.getPurchaseHistory().size());
        assertEquals(1, customer.getPurchaseHistory().size());
        assertEquals(0, customer.stockInBasketCount());
    }

    @Test
    public void canCalculateTotal(){
        customer.addToBasket(stock, 2);
        assertEquals(20.00, customer.getBasket().calculateTotal(), 0.1);
    }
}
