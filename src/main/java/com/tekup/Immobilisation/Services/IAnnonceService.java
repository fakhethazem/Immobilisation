package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

public interface IAnnonceService {
	
public List<Annonce> getAllAnnonces();
public Annonce createAnnonce(Annonce annonce);
public Annonce getAnnonceById(int id);
//public Annonce updateAnnonce(int id, Annonce newClient);
public Annonce deleteAnnonce(int id);
}
