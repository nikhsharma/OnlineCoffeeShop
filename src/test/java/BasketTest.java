import com.sun.tools.hat.internal.util.Misc;
import models.basket.Basket;
import models.stock.Stock;
import models.stock.StockType;
import models.users.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasketTest {

    private Basket basket;
    private Stock stock;
    private Stock stock2;
    private Customer customer;

    @Before
    public void before() throws Exception {
        basket = new Basket();
        stock = new Stock("Java beans", StockType.COFFEE, 10.00, 5);
        stock2 = new Stock("Java beanz", StockType.COFFEE, 10.00, 5);
        customer = new Customer("bob", "808");
    }

    @Test
    public void canAddToBasket() {
        basket.addStock(stock);
        ArrayList<Stock> basketstock = new ArrayList<>(basket.getStock());
        assertEquals(1, basket.stockCount());
        assertEquals(5, basketstock.get(0).getQuantity());
    }

    @Test
    public void canRemoveItemFromBasket() {
        basket.addStock(stock);
        basket.addStock(stock2);
        basket.removeStock(stock);
        assertEquals(1, basket.stockCount());
    }

    @Test
    public void canSellBasketContents() {
        basket.addStock(stock);
        basket.addStock(stock2);
        basket.sell(customer);
        assertEquals(0, basket.stockCount());
        assertEquals(1, customer.getPurchaseHistory().size());
    }

    @Test
    public void canGetTotalCostOfBasket(){
        basket.addStock(stock);
        basket.addStock(stock2);
        assertEquals(20.00, basket.calculateTotal(), 0.1);
    }
    @Test
    public void canGetTotalCostOfBasketWhenAnItemIsRemoved(){
        basket.addStock(stock);
        basket.addStock(stock2);
        basket.removeStock(stock2);
        assertEquals(10.00, basket.calculateTotal(), 0.1);
    }
}