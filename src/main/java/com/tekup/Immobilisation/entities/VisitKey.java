package com.tekup.Immobilisation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
import lombok.NonNull;


@Data

@Embeddable
public class VisitKey implements Serializable  {
	@Column(name = "id_client",nullable = false)
	@NonNull
     private Integer clientId;

    @Column(name = "id_annonce",nullable = false)
    @NonNull
     private   Integer annonceId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitKey other = (VisitKey) obj;
		return Objects.equals(annonceId, other.annonceId) && Objects.equals(clientId, other.clientId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(annonceId, clientId);
	}

	public VisitKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitKey(@NonNull Integer clientId, @NonNull Integer annonceId) {
		super();
		this.clientId = clientId;
		this.annonceId = annonceId;
	}
}
