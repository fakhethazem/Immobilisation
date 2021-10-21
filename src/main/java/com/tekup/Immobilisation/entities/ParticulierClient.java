package com.tekup.Immobilisation.entities;



import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="particulierclient")
@Data
@DiscriminatorValue("particulier")
public class ParticulierClient  extends Client{
	
	
}

