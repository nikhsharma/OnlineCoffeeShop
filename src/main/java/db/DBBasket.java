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


    public List<Stock> showStock(Basket basket){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> stockInBasket = null;
        try {
            Criteria cr = session.createCriteria(Stock.class);
            cr.add(Restrictions.eq("basket", basket));
            stockInBasket = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        } return stockInBasket;
    }
}
