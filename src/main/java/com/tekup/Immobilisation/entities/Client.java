package com.tekup.Immobilisation.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="client_type", 
  discriminatorType = DiscriminatorType.STRING)
public class Client  extends User{
	@Column(name="numberphone")
	 private String numberphone;
	@Column(name="birthdaydate")
	 private LocalDate birthdaydate;
	
}

