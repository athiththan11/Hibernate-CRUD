package com.athiththam.hibernate.util;

import java.util.Properties;

import com.athiththam.hibernate.model.Student;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 * Utility class for hibernate to configure sessions and registry services to
 * connect with our declared database and to provide ORM related functions
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                /**
                 * the hibernate configuration properties to connect with your database can be
                 * declared in two methods
                 * 
                 * Method 01: Declare property variables and values using {@link Properties}
                 * inside the method
                 * 
                 * Method 02: Declare property variables using hibernate.cfg.xml. Go to resource
                 * folder and find the hibernate.cfg.xml file for more details
                 * 
                 * ! replace your credentials and connection properties before running
                 */

                // #region Method 01

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "<DRIVER>"); // if you are using PostgreSQL then it should be =>
                                                                // org.postgresql.Driver
                properties.put(Environment.URL, "<HOST>"); // if PostgreSQL then it follows like =>
                                                           // jdbc:postgresql://host:5432/database
                properties.put(Environment.USER, "<USERNAME>");
                properties.put(Environment.PASS, "<PASSWORD>");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);

                // #endregion

                // Method 02: uncomment the following section and comment the above section to
                // use the hibernate.cfg.xml

                // #region Method 02

                // configuration.configure("hibernate.cfg.xml");

                // #endregion

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception err) {
                err.printStackTrace();
            }
        }

        return sessionFactory;
    }
}