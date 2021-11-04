package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.ClientParticulierRepo;
import com.tekup.Immobilisation.Repository.ClientProfessionelRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ProClient;

import lombok.AllArgsConstructor;

@Service
public class ClientProfessionelServiceImp implements IClientProfessionelService  {
   @Autowired
   private ClientProfessionelRepo clientProfessionelRepo;

@Override
public List<ProClient> getAllPartClient() {
	return clientProfessionelRepo.findAll();
}



@Override
public ProClient getPartClientById(int id) {
	Optional<ProClient> opt = clientProfessionelRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Client pro with this id is not found"));
}

@Override
public ProClient updatePartClient(int id, ProClient newClient) {
	ProClient client=getPartClientById(id);
	if(newClient.getName()!=null)
		client.setName(newClient.getName());
	if(newClient.getLastName()!=null)
		client.setLastName(newClient.getLastName());
	if(newClient.getEmail()!=null)
		client.setEmail(newClient.getEmail());
	if(newClient.getPassword()!=null)
		client.setPassword(newClient.getPassword());
	if(newClient.getNumberphone()!=null)
		client.setNumberphone(newClient.getNumberphone());
	if(newClient.getBirthdaydate()!=null)
		client.setBirthdaydate(newClient.getBirthdaydate());
	if(newClient.getAnnonces()!=null)
		client.setAnnonces(newClient.getAnnonces());
      if(newClient.getVisits()!=null)
		client.setVisits(newClient.getVisits());
      if(newClient.getCommission()!= 0)
  		client.setCommission(newClient.getCommission());
	 return clientProfessionelRepo.save(client);
}

@Override
public ProClient deletePartClient(int id) {
	ProClient client = getPartClientById(id);
	clientProfessionelRepo.deleteById(id);
	return client;
}

@Override
public ProClient createPartClient(ProClient client) {
	return clientProfessionelRepo.save(client);
}



}
