package com.tekup.Immobilisation.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="users")
@Data
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
	 
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id_user;
	 
	 @Column(name="name" , length=55 , nullable=false)
	 private String name;
	 
	 @Column(name="lastName" , length=55 , nullable=false)
	 private String lastName;
	 
	 @Column(name="email" , length=55 , nullable=false) 
	 private String email;
	 
	 @Column(name="password")
	 private String password;
	
	 
}

