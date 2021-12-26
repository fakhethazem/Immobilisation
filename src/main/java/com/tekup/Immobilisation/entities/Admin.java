package com.tekup.Immobilisation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="admin")
@Data

public class Admin{
	 
		 @Id
		 @GeneratedValue(strategy=GenerationType.AUTO)
		  private Integer id_admin;
		 
		 @Column(name="name" , length=55 , nullable=false)
		 private String name;
		 
		 @Column(name="lastName" , length=55 , nullable=false)
		 private String lastName;
		 
		 @Column(name="email" , length=55 , nullable=false) 
		 private String email;
		 
		 @Column(name="password")
		 private String password;
		
	     @Column(name="right")
	      private String right;	
	
}

