
import models.stock.Order;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerTest {

   Customer customer;
   private Stock stock;
   Stock stock2;
   Order order;

    @Before
    public void before() {
        customer = new Customer("Bob", "808");
        stock = new Stock("java","Java beans", StockType.COFFEE, 10.00, 5, "image");
        stock2 = new Stock("java","Java beans", StockType.COFFEE, 10.00, 0, "image");
    }

    @Test
    public void canAddItemToCustomersBasket() {
        customer.addToBasket(stock, 2);
        assertEquals(1, customer.stockInBasketCount());

    } @Test
    public void cannotAddItemToCustomersBasket() {
        customer.addToBasket(stock2, 0);
        assertEquals(0, customer.stockInBasketCount());
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
        customer.addToBasket(stock, 3);
        assertEquals("£30.00", customer.getBasket().calculateTotal());
    }

    @Test
    public void canCalculateTotalOfOrder(){
        customer.addToBasket(stock, 2);
        customer.purchase();
        ArrayList<Order> orderInPurchaseHistory = new ArrayList<>(customer.getPurchaseHistory());
        assertEquals("£20.00", orderInPurchaseHistory.get(0).calculateTotal());
        customer.addToBasket(stock, 1);
        customer.purchase();
        ArrayList<Order> orderInPurchaseHistory2 = new ArrayList<>(customer.getPurchaseHistory());
        assertEquals("£10.00", orderInPurchaseHistory2.get(0).calculateTotal());

    }
}
