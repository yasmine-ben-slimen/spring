package com.spring.DAOImplementation;

import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.DAO.EtudiantDAO;
import com.spring.entity.Etudiant;  

@Repository("EtudiantDAO") 
 public class EtudiantDAOImpl implements EtudiantDAO {
	
	@Autowired  
    private SessionFactory sessionFactory;  
          
    /* 
     * Register Admin Details.  
    */  
    public int saveStudentDetail(Etudiant etudiant) {  
          
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            int id = (Integer) session.save(etudiant);  
            return id;  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving student Details : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
    }  
  
    public int studentLogin(String email, String password) {  
          
        Session session = null;  
        try  
        {  
            session = sessionFactory.getCurrentSession();  
              
            Query query = session.createQuery("from Etudiant where email=:email and password=:password");  
            query.setParameter("email", email);  
            query.setParameter("password", password);  
            List<Etudiant> list = query.list();  
              
            int size = list.size();  
            if(size == 1)  
            {  
                return list.get(0).getId();  
            }  
            else  
            {  
                return -1;  
            }  
        }  
        catch(Exception exception)  
        {  
            System.out.println("Excecption while saving Student  : " + exception.getMessage());  
            return 0;  
        }  
        finally  
        {  
            session.flush();  
        }  
          
    }  
  

}
