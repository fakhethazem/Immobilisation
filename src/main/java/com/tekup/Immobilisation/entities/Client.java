package com.tekup.Immobilisation.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="client")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="client_type", 
  discriminatorType = DiscriminatorType.STRING)
public   class Client {
	 
		 @Id
		 @GeneratedValue(strategy=GenerationType.AUTO)
		      private Integer id_client;
		 
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
	   
      @OneToMany (mappedBy = "client_ann")
      @JsonIgnore
	            List<Annonce> annonces;
         
         @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
         @JsonManagedReference(value="visit-client")
                List<Visit> visits;

		public Integer getId_client() {
			return id_client;
		}

		public void setId_client(Integer id_client) {
			this.id_client = id_client;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNumberphone() {
			return numberphone;
		}

		public void setNumberphone(String numberphone) {
			this.numberphone = numberphone;
		}

		public String getBirthdaydate() {
			return birthdaydate;
		}

		public void setBirthdaydate(String birthdaydate) {
			this.birthdaydate = birthdaydate;
		}

		public List<Annonce> getAnnonces() {
			return annonces;
		}

		public void setAnnonces(List<Annonce> annonces) {
			this.annonces = annonces;
		}

		public List<Visit> getVisits() {
			return visits;
		}

		public void setVisits(List<Visit> visits) {
			this.visits = visits;
		}
	 
         
	
}

