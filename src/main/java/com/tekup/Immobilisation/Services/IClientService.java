package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Client;

public interface IClientService {
	
public List<Client> getAllClient();
public Client createClient(Client client);
public Client getClientById(int id);
public Client updateClient(int id, Client newClient);
public Client deleteClient(int id);
}
