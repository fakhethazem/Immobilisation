package com.tekup.Immobilisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

@Repository
public interface ClientParticulierRepo  extends JpaRepository<ParticulierClient, Integer>{

}
