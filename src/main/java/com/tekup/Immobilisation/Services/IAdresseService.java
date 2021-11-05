package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Adresse;
import com.tekup.Immobilisation.entities.Client;

public interface IAdresseService {
	
public List<Adresse> getAllAdresse();
public Adresse createAdresse(Adresse adresse);
public Adresse getAdresseById(int id);
//public Adresse updateAdresse(int id, Adresse adresse);
//public Adresse deleteAdresse(int id);
}
