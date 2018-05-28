import models.stock.Stock;
import models.stock.StockType;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StockTest {
    Stock stock;

    @Before
    public void before() {
        stock = new Stock("Mocha", "A Type of coffee", StockType.COFFEE, 4.50, 1);
    }

    @Test
    public void stockIsAvailable() {
        stock.checkAvailability();
        assertEquals(true, stock.checkAvailability());
    }
}
