package db;

import models.users.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBUser {

    private static Session session;

    public static User findByUsername(String username) {
        session = HibernateUtil.getSessionFactory().openSession();
        User foundUser = null;
        try {
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("username", username));
            foundUser = (User)cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return foundUser;
    }
}
