package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.AnnonceRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnnonceServiceImp implements IAnnonceService  {
   @Autowired
   private AnnonceRepo annonceRepo;

@Override
public List<Annonce> getAllAnnonces() {
	return annonceRepo.findAll();
}

@Override
public Annonce createAnnonce(Annonce annonce) {
	return annonceRepo.save(annonce);
}

@Override
public Annonce getAnnonceById(int id) {
	Optional<Annonce> opt = annonceRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Annonce with this id is not found"));
}

@Override
public Annonce updateAnnonce(int id, Annonce newAnnonce) {
	Annonce annonce=getAnnonceById(id);
	if(newAnnonce.getDescription_an()!=null)
		annonce.setDescription_an(newAnnonce.getDescription_an());
	if(newAnnonce.getDate_an()!=null)
		annonce.setDate_an(newAnnonce.getDate_an());
	if(newAnnonce.getCategorie_an()!=null)
		annonce.setCategorie_an(newAnnonce.getCategorie_an());
	if(newAnnonce.getType_an()!=null)
		annonce.setType_an(newAnnonce.getType_an());
	if(newAnnonce.getPrice()!=0)
		annonce.setPrice(newAnnonce.getPrice());
	if(newAnnonce.getClient_ann()!=null)
		annonce.setClient_ann(newAnnonce.getClient_ann());
	if(newAnnonce.getAdresse()!=null)
		annonce.setAdresse(newAnnonce.getAdresse());
      if(newAnnonce.getVisits()!=null)
    	  annonce.setVisits(newAnnonce.getVisits());
	 return annonceRepo.save(annonce);
}

@Override
public Annonce deleteAnnonce(int id) {
	Annonce annonce = getAnnonceById(id);
	annonceRepo.deleteById(id);
	return annonce;
}





   
}
