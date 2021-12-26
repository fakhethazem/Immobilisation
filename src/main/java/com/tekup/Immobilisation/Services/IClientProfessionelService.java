package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;
import com.tekup.Immobilisation.entities.ProClient;

public interface IClientProfessionelService {
	
public List<ProClient> getAllPartClient();
public ProClient createProClient(int id);
public ProClient getPartClientById(int id);
public ProClient updatePartClient(int id, ProClient client);
public ProClient deletePartClient(int id);
}
