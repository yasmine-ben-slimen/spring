package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.spring.entity.Annonce;

@Repository
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface AnnonceRepository extends JpaRepository<Annonce,Integer> {
	List<Annonce>findAllByAnnonceur(Integer id);
	List<Annonce>findByPrixAndType(float prix,String type);
	Annonce findByPrix(float prix);


}
