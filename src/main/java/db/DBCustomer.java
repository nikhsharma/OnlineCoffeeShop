package db;

import javafx.scene.control.CustomMenuItem;
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

    public static List<Stock> showPurchaseHistory(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Stock> purchaseHistory = null;
        try {
            Criteria cr = session.createCriteria(Stock.class);
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
