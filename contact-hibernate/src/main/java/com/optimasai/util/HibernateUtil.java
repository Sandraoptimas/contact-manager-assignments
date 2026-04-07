package com.optimasai.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.optimasai.model.Contact;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Contact.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}