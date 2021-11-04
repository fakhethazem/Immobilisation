package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

public interface IClientParticulierService {
	
public List<ParticulierClient> getAllPartClient();
public ParticulierClient createPartClient(ParticulierClient client);
public ParticulierClient getPartClientById(int id);
public ParticulierClient updatePartClient(int id, ParticulierClient newClient);
public ParticulierClient deletePartClient(int id);
}
