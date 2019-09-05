package fr.formation.inti;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.HibernateUtils;

public class QuerySomeColumnDemo {
	 
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
 
        Session session = factory.getCurrentSession();
 
        try {
            session.getTransaction().begin();															// création d'une requête SQL
  
            String sql = "Select e.empId, e.empNo, e.empName from "
                    + Employee.class.getName() + " e ";
 
            Query<Object[]> query = session.createQuery(sql);
  
          
            List<Object[]> datas = query.getResultList();
 
            for (Object[] emp : datas) {
                System.out.println("Emp Id: " + emp[0]);
                System.out.println(" Emp No: " + emp[1]);
                System.out.println(" Emp Name: " + emp[2]);
            }
  
          
            session.getTransaction().commit();															// fermeture de la requête
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
  
    }
}