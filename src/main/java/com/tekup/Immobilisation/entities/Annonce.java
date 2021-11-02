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

import lombok.Data;

@Entity
@Table(name="Annonce")
@Data

public class Annonce  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_annonce")
	 private int id_annonce ;
	@Column(name="description" , length=55 , nullable=false)
	 private String description_an ;
	@Column(name="date_an")
	 private LocalDate date_an ;
	@Column(name="categorie_an")
	 private String categorie_an ;
	@Column(name="type_an")
	 private String type_an ;
	@Column(name="price")
	 private float price ;
	 @OneToMany(mappedBy = "annonce")
	    List<Visit> visits;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false , updatable = false)
	 Client client_ann;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	 private Adresse adresse;
}

