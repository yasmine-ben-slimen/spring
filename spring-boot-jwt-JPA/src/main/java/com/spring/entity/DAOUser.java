package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	
	@Column
	@JsonIgnore
	private String password;
	
	@Column(name="email")
	private String email ;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Annonce> getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Set<Annonce> annonce) {
		this.annonce = annonce;
	}

	@Column(name="phone")
	private String phone;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="annonceur")
    private Set<Annonce> annonce;
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	

}