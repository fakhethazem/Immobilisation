package com.tekup.Immobilisation.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="credit")
@Data

public class Credit  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_credit")
	 private int id_credit ;
	@Column(name="description" , length=55 , nullable=false)
	 private String description ;
	@Column(name="proprietaire")
	 private String proprietaire ;
	@Column(name="taux_interet")
	 private float taux_interet ;
	@Column(name="nom_banque")
	 private String nom_banque ;
}

