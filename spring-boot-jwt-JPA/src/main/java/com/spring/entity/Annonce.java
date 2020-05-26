package com.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="annonce")
public class Annonce {
	
	
	

	public Annonce(String nom_ecole, float prix, String description, int nb_place, String type, String image_url,
			Boolean available, String genre, Annonceur annonceur) {
		super();
		this.nom_ecole = nom_ecole;
		this.prix = prix;
		this.description = description;
		this.nb_place = nb_place;
		this.type = type;
		this.image_url = image_url;
		this.available = available;
		this.genre = genre;
		this.annonceur = annonceur;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_annonce")
	private Integer Id ;
	
	@Column(name="nom_ecole")
	private String nom_ecole ;
	
	@Column(name="prix")
	private float prix; 
	
	@Column(name="description")
	private String description ;
	
	@Column(name="nb_place")
	private int nb_place;
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="date_ajout")
	private Date date_ajout= new Date();
	
	@Column(name="available")
	private Boolean available =true;
	
	@Column(name="genre")
	private String genre;
	
	 @ManyToOne
	 @JoinColumn(name = "id_annonceur",insertable =true)
	private Annonceur annonceur;

	@Override
	public String toString() {
		return "Annonce [Id=" + Id + ", nom_ecole=" + nom_ecole + ", prix=" + prix + ", description=" + description
				+ ", nb_place=" + nb_place + ", type=" + type + ", image_url=" + image_url + ", date_ajout="
				+ date_ajout + ", available=" + available + ", genre=" + genre + ", annonceur=" + annonceur + "]";
	}
	
	
 
	
}
