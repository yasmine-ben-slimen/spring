package com.javainuse.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.AdminDAO;
import com.javainuse.model.DAOUser;

public interface AdminDao  extends CrudRepository<AdminDAO, Integer>{
	AdminDAO findByUsername(String username);
}
