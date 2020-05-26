package com.spring.DAO;


import com.spring.entity.Etudiant;

public interface EtudiantDAO {
	public int saveStudentDetail(Etudiant etudiant);  
    
    public int studentLogin(String email , String password);  
      
}
