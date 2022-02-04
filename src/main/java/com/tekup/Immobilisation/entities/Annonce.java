package com.tekup.Immobilisation.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;



@Entity
@Table(name="Annonce")

@Data
public class Annonce  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_annonce")
	 private Integer id_annonce ;
	
	@Column(name="description" , length=55 , nullable=false)
	 private String description ;
	
	@Column(name="sellrent")
	 private String sellrent ;
	
	@Column(name="name")
	 private String name ;
	
	@Column(name="type")
	 private String type ;
	
	@Column(name="roomsnumb")
	 private String roomsnumb ;
	
	@Column(name="price")
	 private float price ;
	
	@Column(name="town")
	 private String town ;
	
	@Column(name="city")
	 private String city ;
	
	@Column(name="addresse")
	 private String addresse ;
	
	@Column(name="image")
	private String image;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_client", referencedColumnName = "id_client")
	 Client client_ann;
	
	/* @OneToOne(cascade = CascadeType.REMOVE)
	 @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	 private Adresse adresse;*/
	 
	 @OneToMany(mappedBy = "annonce",cascade = CascadeType.REMOVE)
	 @JsonManagedReference(value="visit-annonce")
	    List<Visit> visits;

}

