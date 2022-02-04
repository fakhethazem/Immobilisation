package com.tekup.Immobilisation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.ClientTempRepo;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ClientTemp;

@Service
public class RegisterService {
	@Autowired
	private ClientTempRepo clientTempRepo;
	

	
	public ClientTemp setDataToRegister(ClientTemp clientt) {
		return  clientTempRepo.save(clientt);
		
	}

	public  List<ClientTemp> getListRegister() {
		return clientTempRepo.findAll();
	}

	

}
