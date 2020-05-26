package com.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="annonceur")
public class Annonceur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonceur")
	private Integer Id ;
	@NotEmpty( message="Please enter the username")
	@Column(name="username")
	private String username ;
	@NotNull( message="Please enter the password")
	@Column(name="password")
	private String password; 	
	@NotEmpty( message="Please enter your email")
	
	@Column(name="email")
	private String email ;
	@NotNull( message="Please enter the phone number")
	@Column(name="phone")
	private String phone;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="annonceur")
    private Set<Annonce> annonce;

	@Override
	public String toString() {
		return "Annonceur [Id=" + Id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", annonce=" + annonce + "]";
	}
	 
	
	
	 /*public String toString(){
		 String info = "";
	        JSONObject jsonInfo = new JSONObject();
	        if(this.annonce != null){
	            this.annonce.forEach(annonce->{
	                JSONObject subJson = new JSONObject();
	                subJson.put("image", annonce.getImage_url());
	                jsonInfo.put("descripion",annonce.getDescription());
	    	        jsonInfo.put("price",annonce.getPrix());
	    	        


	            });
	        }
	        
	       
	        info = jsonInfo.toString();
	        return info;
	    }*/
	    }


