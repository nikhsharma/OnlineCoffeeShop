package db;

import models.basket.Basket;
import models.stock.Stock;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBasket {
    private static Session session;
    private static Transaction transaction;


    public static List<Stock> showStock(Basket basket){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> stockInBasket = null;
        try {
            Criteria cr = session.createCriteria(Stock.class);
            cr.add(Restrictions.eq("basket.id", basket.getId()));
            stockInBasket = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return stockInBasket;
    }

    public static Stock findStockToRemove(Stock stock) {
        List<Stock> items = DBHelper.getAll(Stock.class);
//        Stock foundItem = null;
        for (Stock item : items) {
            if ((item.getName().equals(stock.getName())) && (item.getId() != stock.getId())) {
                return item;
            }
        }
        return null;
    }
}
