package com.spring.DAO;

public interface TokenDAO {
	
	public void saveUserEmail(String email , int studentId);  
    
    public boolean updateToken(String email , String authenticationToken , String secretKey);  
      
    public int getTokenDetail(String email );  
  
    public int tokenAuthentication(String token , int emailId);  

}
