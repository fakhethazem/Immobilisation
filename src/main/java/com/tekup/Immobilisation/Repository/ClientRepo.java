package com.tekup.Immobilisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

@Repository
public interface ClientRepo  extends JpaRepository<Client, Integer>{
	
	 Client findByName(String name);
	 Client findByEmail(String email);
	 

}


