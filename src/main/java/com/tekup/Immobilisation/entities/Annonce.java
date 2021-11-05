package com.tekup.Immobilisation.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.boot.model.relational.Database;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="Annonce")


public class Annonce  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_annonce")
	 private Integer id_annonce ;
	
	@Column(name="description" , length=55 , nullable=false)
	 private String description_an ;
	
	@Column(name="date_an")
	 private String date_an ;
	
	@Column(name="categorie_an")
	 private String categorie_an ;
	
	@Column(name="type_an")
	 private String type_an ;
	
	@Column(name="price")
	 private float price ;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_client", referencedColumnName = "id_client")
	 @JsonBackReference
	 Client client_ann;
	
	 @OneToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	 private Adresse adresse;
	 
	 @OneToMany(mappedBy = "annonce",cascade = CascadeType.ALL)
	    List<Visit> visits;

	public Integer getId_annonce() {
		return id_annonce;
	}

	public void setId_annonce(Integer id_annonce) {
		this.id_annonce = id_annonce;
	}

	public String getDescription_an() {
		return description_an;
	}

	public void setDescription_an(String description_an) {
		this.description_an = description_an;
	}

	public String getDate_an() {
		return date_an;
	}

	public void setDate_an(String date_an) {
		this.date_an = date_an;
	}

	public String getCategorie_an() {
		return categorie_an;
	}

	public void setCategorie_an(String categorie_an) {
		this.categorie_an = categorie_an;
	}

	public String getType_an() {
		return type_an;
	}

	public void setType_an(String type_an) {
		this.type_an = type_an;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Client getClient_ann() {
		return client_ann;
	}

	public void setClient_ann(Client client_ann) {
		this.client_ann = client_ann;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	 
}

