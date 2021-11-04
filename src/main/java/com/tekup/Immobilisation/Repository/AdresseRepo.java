package com.tekup.Immobilisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.Immobilisation.entities.Adresse;
import com.tekup.Immobilisation.entities.ProClient;

@Repository
public interface AdresseRepo  extends JpaRepository<Adresse, Integer>{

}
