package com.tekup.Immobilisation.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="clientTemp")
public   class ClientTemp{
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	      private Integer id_clienttemp;
	 
	 @Column(name="name" , length=55)
	       private String name;
	 
	 @Column(name="lastName" , length=55 )
	       private String lastName;
	 
	 @Column(name="email" , length=55 ) 
	      private String email;
	 
	 @Column(name="password")
	      private String password;
	 
     @Column(name="numberphone")
           private String numberphone;
     
     
     @Column(name="birthdaydate")
            private String birthdaydate;
     
     @Column(name="commission")
	 private float commission;
}

