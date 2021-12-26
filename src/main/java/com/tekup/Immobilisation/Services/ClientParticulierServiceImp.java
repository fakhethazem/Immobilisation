package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.ClientParticulierRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientParticulierServiceImp implements IClientParticulierService  {
   @Autowired
   private ClientParticulierRepo clientParticulierRepo;

@Override
public List<ParticulierClient> getAllPartClient() {
	return clientParticulierRepo.findAll();
}

@Override
public ParticulierClient createPartClient(ParticulierClient client) {
	return clientParticulierRepo.save(client);
}

@Override
public ParticulierClient getPartClientById(int id) {
	Optional<ParticulierClient> opt = clientParticulierRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Client with this id is not found"));
}

@Override
public ParticulierClient updatePartClient(int id, ParticulierClient newClient) {
	ParticulierClient client=getPartClientById(id);
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
	 return clientParticulierRepo.save(client);
}

@Override
public ParticulierClient deletePartClient(int id) {
	ParticulierClient client = getPartClientById(id);
	clientParticulierRepo.deleteById(id);
	return client;
}


   
}
