package org.example.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConnection {
    public static SessionFactory creatSessionFactory(){
        Properties properties=new Properties();
        properties.setProperty(Environment.DRIVER,"org.postgresql.Driver");
        properties.setProperty(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER,"postgres");
        properties.setProperty(Environment.PASS,"postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO,"update");//validate//update//
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL,"true");

        Configuration configuration=new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Book.class);

        return configuration.buildSessionFactory();
    }
    public  static EntityManagerFactory creatEntityManagerFactory(){
      return creatSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
