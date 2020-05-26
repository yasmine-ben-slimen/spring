package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.repository.EtudiantRepository;

import com.spring.entity.Etudiant;
import com.spring.message.request.LoginForm;
import com.spring.message.response.JwtResponse;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")

@RestController
public class EtudiantController {
	@Autowired
	private AuthenticationManager authenticationManager;


	@Autowired
	private PasswordEncoder encoder;

	  @Autowired
	    private EtudiantRepository etudiantRepository;

	    @GetMapping("/etudiants/{id}")
	    public ResponseEntity<Etudiant> getStudentById(@PathVariable(value = "id") Integer StudentId)
	        throws ResourceNotFoundException {
	    	Etudiant etudiant = etudiantRepository.findById(StudentId)
	          .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));
	        return ResponseEntity.ok().body(etudiant);
	    }
	
	    
		@PostMapping("/etudiants/signin")
		public String authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
			return("bbbbb");

		}
	    

	    @PutMapping("/etudiants/{id}")
	    public ResponseEntity<Etudiant> updateStudent(@PathVariable(value = "id") Integer StudentId,
	         @Valid @RequestBody Etudiant studentDetails) throws ResourceNotFoundException {
	    	Etudiant student = etudiantRepository.findById(StudentId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + StudentId));

	        student.setUsername(studentDetails.getUsername());
	        student.setPassword(studentDetails.getPassword());
	        student.setPhone(studentDetails.getPhone());
	        student.setEmail(studentDetails.getEmail());
	        final Etudiant updatedStudent = etudiantRepository.save(student);
	        return ResponseEntity.ok(updatedStudent);
	    }
	    @PostMapping("/etudiants")
	    public Etudiant createStudent(@Valid @RequestBody Etudiant etudiant) {
	         return etudiantRepository.save(etudiant);
	         //return "Hi " + etudiant.getUsername() + " your Registration process successfully completed";
	    }
	    @DeleteMapping("/etudiants/{id}")
	    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Integer StudentId)
	         throws ResourceNotFoundException {
	        Etudiant etudiant = etudiantRepository.findById(StudentId)
	       .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));

	        etudiantRepository.delete(etudiant);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    

}
