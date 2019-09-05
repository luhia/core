package fr.formation.inti;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.HibernateUtils;

public class QueryObjectDemo2 {
	 
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
 
        Session session = factory.getCurrentSession();
 
        try {               
            session.getTransaction().begin();														// création d'une requète SQL
                   
            String sql = "Select e from " + Employee.class.getName() + " e "
                    + " where e.department.deptNo=:deptNo ";
  
            
            Query<Employee> query = session.createQuery(sql);
 
            query.setParameter("deptNo", "D10");
 
  
            
            List<Employee> employees = query.getResultList();										//execution de la requête SQL
 
            for (Employee emp : employees) {
                System.out.println("Emp: " + emp.getEmpNo() + " : " + emp.getEmpName());                     
            }
  
            session.getTransaction().commit();														// fermeture 
        } catch (Exception e) {
            e.printStackTrace();
            
            session.getTransaction().rollback();
        }
    }
}
