import models.basket.Basket;
import models.stock.Misc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
