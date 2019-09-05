package fr.formation.inti.entities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()								// Créé le ServiceRegistry pour hibernate.cfg.xml
                    .configure("hibernate.cfg.xml").build();
 
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();				//création de la metadata
 
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
         
            System.err.println("Initial SessionFactory creation failed." + ex);
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
