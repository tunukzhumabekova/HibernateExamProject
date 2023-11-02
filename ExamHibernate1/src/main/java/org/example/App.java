package org.example;

import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Medicines;
import org.example.entity.Pharmacy;
import org.example.entity.Worker;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static EntityManagerFactory getSession(){
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/database4");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Pharmacy.class);
        configuration.addAnnotatedClass(Medicines.class);
        configuration.addAnnotatedClass(Worker.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
