package com.spring.serviceImplementation;

import com.spring.service.LoginService;

import javax.transaction.Transactional;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.spring.DAO.EtudiantDAO;
import com.spring.entity.Etudiant;  

@Service("etudiantService")  

public class EtudiantServiceImpl implements LoginService {
	
	@Autowired  
    private EtudiantDAO etudiantDAO;  
  
	@Transactional  
	@Override
	public int saveStudentDetail(Etudiant etudiant) {
		return etudiantDAO.saveStudentDetail(etudiant);
	}

	@Transactional  
	@Override
	public int studentLogin(String email, String password) {
		 return etudiantDAO.studentLogin(email, password);
	}  

}
