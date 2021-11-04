package com.tekup.Immobilisation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.boot.model.relational.Database;

import lombok.Data;

@Entity
@Table(name="Visit")
@Data

public class Visit   {
	
	   @EmbeddedId
	      private VisitKey visitKey;
 
	    @ManyToOne
	    @MapsId("clientId")
	    @JoinColumn(name = "id_client" , insertable = false , updatable = false)
	    Client client;
	      
        @ManyToOne
	    @MapsId("annonceId")
	    @JoinColumn(name = "id_annonce", insertable = false , updatable = false)
	      Annonce annonce;
	    
	    @Column(name="date_visite")
	    private LocalDate date_visite;
	    
	    @Column(name="frais")
	    private float frais;
	    
}

