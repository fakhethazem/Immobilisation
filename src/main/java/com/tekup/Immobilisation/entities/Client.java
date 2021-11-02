package com.tekup.Immobilisation.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="client")
@Data
@Inheritance(strategy= InheritanceType.JOINED)
/*@DiscriminatorColumn(name="client_type", 
  discriminatorType = DiscriminatorType.STRING)*/
public   class Client  extends User{
	 
	 @OneToMany(mappedBy = "client")
	    List<Visit> visits;
	@Column(name="numberphone")
	 private String numberphone;
	@Column(name="birthdaydate")
	 private LocalDate birthdaydate;
     @OneToMany (targetEntity=Annonce.class,mappedBy = "client_ann" ,cascade=CascadeType.ALL)
	 List<Annonce> annonces;
	 
	
}

