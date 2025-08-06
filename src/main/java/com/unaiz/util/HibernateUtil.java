package com.unaiz.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.unaiz.entity.Student;
import com.unaiz.entity.Address;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");

            // Add annotated classes
            config.addAnnotatedClass(Student.class);
            config.addAnnotatedClass(Address.class);

            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
