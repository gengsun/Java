package sun.java.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sun on 11/11/15.
 */
public class HibernateUtil
{
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private HibernateUtil()
    {
        throw new AssertionError("Do not instantiate this utility class.");
    }

    private static SessionFactory buildSessionFactory()
    {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return SESSION_FACTORY;
    }

    public static void shutDown()
    {
        getSessionFactory().close();
    }
}
