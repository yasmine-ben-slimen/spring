
package com.spring.serviceImplementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DAO.TokenDAO;
import com.spring.service.TokenService;

@Service("tokenService")  
public class TokenServiceImpl implements TokenService {
 	
	@Autowired  
    private TokenDAO tokenDAO;  
      
    @Transactional 
    @Override
    public void saveUserEmail(String email, int Id) {  
        tokenDAO.saveUserEmail(email, Id);  
    }  
  
    @Transactional  
    @Override
    public boolean updateToken(String email, String authenticationToken, String secretKey) {  
        return tokenDAO.updateToken(email, authenticationToken, secretKey);  
    }  
  
    @Transactional 
    @Override
    public int getTokenDetail(String email) {  
        return tokenDAO.getTokenDetail(email);  
    }  
  
    @Transactional
    @Override  
    public int tokenAuthentication(String token, int emailId) {  
        return tokenDAO.tokenAuthentication(token, emailId);  
    }  

}
