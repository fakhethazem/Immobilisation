package com.tekup.Immobilisation.entities;

import java.time.LocalDate;
import java.util.Date;
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

public class AnnonceDto  {
	
	 private String region ;
	
	 private String nature ;
	
	 private String type ;
	
	
	private String url ;

	 private String prix ;
	 private String modifie ;
	public AnnonceDto(String region, String nature, String type, String url, String prix, String modifie) {
		super();
		this.region = region;
		this.nature = nature;
		this.type = type;
		this.url = url;
		this.prix = prix;
		this.modifie = modifie;
	}
	 
	
	public AnnonceDto() {
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getModifie() {
		return modifie;
	}


	public void setModifie(String modifié) {
		this.modifie = modifie;
	}


	@Override
	public String toString() {
		return "AnnonceDto [region=" + region + ", nature=" + nature + ", type=" + type + ", url=" + url + ", prix="
				+ prix + ", modifié=" + modifie + "]";
	}
	
}

