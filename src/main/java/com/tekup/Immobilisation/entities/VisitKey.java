package com.tekup.Immobilisation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.boot.model.relational.Database;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@Embeddable
public class VisitKey implements Serializable  {
	@Column(name = "id_user")
     private Integer userId;

    @Column(name = "id_annonce")
     private   Integer annonceId;
}
