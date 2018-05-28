package db;

import models.stock.Order;
import models.stock.Stock;
import models.users.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOrder {

    private static Session session;

    public static List<Stock> showItemsInOrder(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> itemsInOrder = null;
        try {
            Criteria cr = session.createCriteria(Stock.class);
            cr.add(Restrictions.eq("order.id", order.getId()));
            itemsInOrder = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return itemsInOrder;
    }
}
