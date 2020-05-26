package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Annonceur;
import com.spring.repository.AnnonceRepository;
import com.spring.repository.AnnonceurRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RequestMapping("/api/v1")

@RestController
public class AnnonceurController  {
	
	@Autowired
	private AnnonceurRepository rep;
	@Autowired
    private AnnonceRepository annonceRepository;
	
	@GetMapping("/annonceurs/{id}/annonce")
	List<Annonceur> findAll(){
		return rep.findAll();
		
	}

}
