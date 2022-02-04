package com.tekup.Immobilisation.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="Adresse")
@Data

public class Adresse  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_adresse")
	 private Integer id_adresse ;
	
	@Column(name="gouvernorat" , length=55 )
	 private String gouvernorat ;
	
	@Column(name="ville")
	 private String ville ;
	
	@Column(name="adresse_det")
	 private String adresse_det ;
	
	/* @OneToOne(mappedBy = "adresse")
	 @JsonIgnore
      private Annonce annonce;*/
	

}

