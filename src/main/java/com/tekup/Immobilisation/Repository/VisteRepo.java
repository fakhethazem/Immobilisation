package com.tekup.Immobilisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekup.Immobilisation.entities.ProClient;
import com.tekup.Immobilisation.entities.Visit;

@Repository
public interface VisteRepo  extends JpaRepository<Visit, Integer>{

}
