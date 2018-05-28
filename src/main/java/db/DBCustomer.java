package db;

import javafx.scene.control.CustomMenuItem;
import models.stock.Order;
import models.stock.Stock;
import models.users.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static List<Order> showPurchaseHistory(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> purchaseHistory = null;
        try {
            Criteria cr = session.createCriteria(Order.class);
            cr.add(Restrictions.eq("customer", customer));
            purchaseHistory = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return purchaseHistory;
    }

}
