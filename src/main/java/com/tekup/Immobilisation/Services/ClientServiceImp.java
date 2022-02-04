package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Client;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImp implements IClientService  {
   @Autowired
   private ClientRepo clientRepo;

@Override
public List<Client> getAllClient() {
	return clientRepo.findAll();
}

@Override
public Client createClient(Client client) {
	return (Client) clientRepo.save(client);
}

@Override
public Client getClientById(int id) {
	Optional<Client> opt = clientRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Client with this id is not found"));
}

@Override
public Client updateClient(int id, Client newClient) {
	Client client=getClientById(id);
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
	 return (Client) clientRepo.save(client);
}

@Override
public Client deleteClient(int id) {
	Client client = getClientById(id);
	clientRepo.deleteById(id);
	return client;
}

@Override
public Client findByEmail(String email) {
	Client client = clientRepo.findByEmail(email);
	return client;
}


   
}
