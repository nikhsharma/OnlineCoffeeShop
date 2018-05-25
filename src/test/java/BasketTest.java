import models.basket.Basket;
import models.stock.Misc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasketTest {

    private Basket basket;
    private Misc misc;

    @Before
    public void before() throws Exception {
        basket = new Basket();
        misc = new Misc(10.00, 5);
    }

    @Test
    public void canAddToBasket() {
        basket.addStock(misc);
        assertEquals(1, basket.stockCount());
    }

    @Test
    public void canRemoveItemFromBasket() {
        basket.addStock(misc);
        basket.removeStock(misc);
        assertEquals(0, basket.stockCount());
    }

    @Test
    public void canSellBasketContents() {
        basket.addStock(misc);
        basket.addStock(misc);
        assertNotNull(basket.sell());
        assertEquals(0, basket.stockCount());
    }
}
