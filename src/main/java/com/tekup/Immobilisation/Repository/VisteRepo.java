package com.tekup.Immobilisation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tekup.Immobilisation.entities.ProClient;
import com.tekup.Immobilisation.entities.Visit;
import com.tekup.Immobilisation.entities.VisitKey;

@Repository
public interface VisteRepo  extends CrudRepository<Visit, VisitKey>{
	 public List<Visit>  findByVisitKeyClientId(Integer clientid);
	
}
