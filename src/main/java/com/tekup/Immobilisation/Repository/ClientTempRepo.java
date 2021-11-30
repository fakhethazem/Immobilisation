package com.tekup.Immobilisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ClientTemp;
import com.tekup.Immobilisation.entities.ParticulierClient;
import com.tekup.Immobilisation.entities.ProClient;

@Repository
public interface ClientTempRepo  extends JpaRepository<ClientTemp, Integer>{

}
