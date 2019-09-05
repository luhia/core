package fr.formation.inti.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.entities.Department;
import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.HibernateUtils;

public class PersistDemo {
	 
	   public static void main(String[] args) {
	        
	       SessionFactory factory = HibernateUtils.getSessionFactory();
	 
	       Session session = factory.getCurrentSession();
	       Department department = null;
	       Employee emp = null;
	       try {
	           session.getTransaction().begin();												//début de la requête
	 
	           Long maxEmpId = DataUtils.getMaxEmpId(session);
	           Long empId = maxEmpId + 1;
	            
	           department = DataUtils.findDepartment(session, "D10");
	                       
	           emp = new Employee();															// Création d'un objet transient (temporaire)
	           emp.setEmpId(empId);
	           emp.setEmpNo("E" + empId);
	           emp.setEmpName("Name " + empId);
	           emp.setJob("Coder");
	           emp.setSalary(1000f);
	           emp.setManager(null);
	           emp.setHideDate(new Date());
	           emp.setDepartment(department);
	            
	           session.persist(emp);														//rend emp persistant et géré par hibernate
	 
	           session.getTransaction().commit();											//fin de la requête
	       } catch (Exception e) {
	           e.printStackTrace();
	           session.getTransaction().rollback();
	       }
	       
	       System.out.println("Emp No: " + emp.getEmpNo());									//après commit, roolback ou close, emp et dept deviennent "détaché"
	        
	   }
	    
	}