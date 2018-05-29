import models.stock.Stock;
import models.stock.StockType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StockTest {
    Stock stock;
    Stock stock2;

    @Before
    public void before() {
        stock = new Stock("Mocha", "A Type of coffee", StockType.COFFEE, 4.50, 1, "image");
        stock2 = new Stock("Mocha", "A Type of coffee", StockType.COFFEE, 4.50, 0, "image");
    }

    @Test
    public void stockIsAvailable() {
        stock.checkAvailability();
        assertEquals(true, stock.getAvailability());
    }
    @Test
    public void stockIsNotAvailable(){
        stock2.checkAvailability();
        assertEquals(false, stock2.getAvailability());
    }
}
