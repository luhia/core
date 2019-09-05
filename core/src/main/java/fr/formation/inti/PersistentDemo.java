package fr.formation.inti;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.formation.inti.dao.DataUtils;
import fr.formation.inti.entities.Department;
import fr.formation.inti.entities.HibernateUtils;

public class PersistentDemo {
	 
	   public static void main(String[] args) {
	        
	       SessionFactory factory = HibernateUtils.getSessionFactory();
	 
	       Session session = factory.getCurrentSession();
	       Department department = null;
	 
	       try {
	           session.getTransaction().begin();													//début de la requête
	 
	           System.out.println("- Finding Department deptNo = D10...");    
	           department = DataUtils.findDepartment(session, "D10");								//objet persistent
	 
	           System.out.println("- First change Location");
	      
	            
	           department.setLocation("Chicago " + System.currentTimeMillis());						//changement de l'objet       
	           System.out.println("- Location = " + department.getLocation());
	 
	           System.out.println("- Calling flush...");
	    
	           session.flush();																		//utiliser pour changer dans la base
	           System.out.println("- Flush OK");
	 
	           System.out.println("- Second change Location");
	            
	           department.setLocation("Chicago " + System.currentTimeMillis());
	           System.out.println("- Location = " + department.getLocation());
	 
	           System.out.println("- Calling commit...");
	           
	           session.getTransaction().commit();													//fin de la requête
	 
	           System.out.println("- Commit OK");
	       } catch (Exception e) {
	           e.printStackTrace();
	           session.getTransaction().rollback();
	       }
	  
	       
	       session = factory.getCurrentSession();
	       try {
	           session.getTransaction().begin();													//2ème requête
	 
	           System.out.println("- Finding Department deptNo = D10...");
	            
	            
	           department = DataUtils.findDepartment(session, "D10");
	  
	           System.out.println("- D10 Location = " + department.getLocation());
	 
	           session.getTransaction().commit();													//fin de la requête
	           
	       } catch (Exception e) {
	           e.printStackTrace();
	           session.getTransaction().rollback();
	       }
	   }
	    
	}
