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

public class Admin  extends User{
	@Column(name="right")
	 private String right;	
	
}

