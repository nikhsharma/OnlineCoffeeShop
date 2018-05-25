import com.sun.tools.hat.internal.util.Misc;
import models.basket.Basket;
import models.stock.Stock;
import models.stock.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasketTest {

    private Basket basket;
    private Stock stock;
    private Stock stock2;

    @Before
    public void before() throws Exception {
        basket = new Basket();
        stock = new Stock("Java beans", StockType.COFFEE, 10.00, 5);
        stock2 = new Stock("Java beanz", StockType.COFFEE, 10.00, 5);
    }

    @Test
    public void canAddToBasket() {
        basket.addStock(stock, 2);
        assertEquals(1, basket.stockCount());
        assertEquals(3, stock.getQuantity());
        assertEquals(2, basket.getStock().get(0).getQuantity());
    }

    @Test
    public void canRemoveItemFromBasket() {
        basket.addStock(stock, 1);
        basket.addStock(stock2, 1);
        basket.removeStock(stock);
        assertEquals(1, basket.stockCount());
        assertEquals(5, stock.getQuantity());
        assertEquals(4, stock2.getQuantity());
    }

    @Test
    public void canSellBasketContents() {
        basket.addStock(stock, 2);
        basket.addStock(stock2, 3);
        assertNotNull(basket.sell());
        assertEquals(0, basket.stockCount());
    }
}
