package fr.formation.inti;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.HibernateUtils;
import fr.formation.inti.entities.ShortEmpInfo_PetitEmployee;

public class ShortEmpInfoQueryDemo_PetitEmployee {
	 
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
 
        Session session = factory.getCurrentSession();
 
        try {
            session.getTransaction().begin();
  
            String sql = "Select new " + ShortEmpInfo_PetitEmployee.class.getName()
                    + "(e.empId, e.empNo, e.empName)" + " from "
                    + Employee.class.getName() + " e ";
 
            Query<ShortEmpInfo_PetitEmployee> query = session.createQuery(sql);
  
             
            List<ShortEmpInfo_PetitEmployee> employees = query.getResultList();
 
            for (ShortEmpInfo_PetitEmployee emp : employees) {
                System.out.println("Emp: " + emp.getEmpNo() + " : "
                        + emp.getEmpName());
            }
  
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
     
}
