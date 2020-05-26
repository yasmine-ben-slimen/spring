package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Annonce;
import com.spring.entity.Annonceur;
import com.spring.repository.AnnonceRepository;
import com.spring.repository.AnnonceurRepository;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RequestMapping("/api/v1")

@RestController
public class AnnonceController {
	
	
	@Autowired
    private AnnonceRepository annonceRepository;
	@Autowired
	private AnnonceurRepository rep;
    private Annonceur annonceur;
	@PersistenceContext
	EntityManager entityManager;
    @GetMapping("/annonces/{id}")
    public ResponseEntity<Annonce> getStudentById(@PathVariable(value = "id") Integer Id)
        throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(Id)
          .orElseThrow(() -> new ResourceNotFoundException("Add not found for this id :: " + Id));
        return ResponseEntity.ok().body(annonce);
    }
    
    /*@PostMapping("/annonces")
    public Annonce createAnnonce(@Valid @RequestBody Annonce annonce,@Valid @RequestBody String email) {
    	
		// Annonceur owner = rep.findByEmail(email);
    	//Annonceur owner = entityManager.getReference(Annonceur.class, annonceur.getId());
      //Annonceur a=rep.getOne(annonce.getId());
    	//annonce.setAnnonceur(owner);
         return annonceRepository.save(annonce);
    }*/

    @PutMapping("/annonces/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable(value = "id") Integer annonceId,
         @Valid @RequestBody Annonce details) throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(annonceId)
        .orElseThrow(() -> new ResourceNotFoundException("	Add not found for this id :: " + annonceId));

    	annonce.setAvailable(annonce.getAvailable());
    	annonce.setImage_url(annonce.getImage_url());
    	annonce.setPrix(annonce.getPrix());
    	annonce.setType(annonce.getType());
    	annonce.setGenre(annonce.getGenre());
    	annonce.setDate_ajout(annonce.getDate_ajout());
        annonce.setDescription(annonce.getDescription());
    	final Annonce updatedStudent = annonceRepository.save(annonce);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/annonces/{id}")
    public Map<String, Boolean> deleteAnnonce(@PathVariable(value = "id") Integer Id)
         throws ResourceNotFoundException {
    	Annonce annonce = annonceRepository.findById(Id)
       .orElseThrow(() -> new ResourceNotFoundException("Add not found for this id :: " +Id));

        annonceRepository.delete(annonce);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
    
   /* @RequestMapping(value = "/annonces/{prix}" , method = RequestMethod.GET)
    public @ResponseBody List<Annonce> getUser(@RequestParam("nom") String nom) {
        return (List<Annonce>) annonceRepository.Nom_ecole(nom);
    }
*/
}
