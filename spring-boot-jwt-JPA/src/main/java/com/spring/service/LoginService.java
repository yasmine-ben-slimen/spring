package com.spring.service;

import com.spring.entity.Etudiant;

public interface LoginService {
	
	public int saveStudentDetail(Etudiant etudiant);  
    
    public int studentLogin(String email , String password); 

}
