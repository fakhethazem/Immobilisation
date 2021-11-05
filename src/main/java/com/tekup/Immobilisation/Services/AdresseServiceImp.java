package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.AdresseRepo;
import com.tekup.Immobilisation.Repository.AnnonceRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Adresse;
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdresseServiceImp implements IAdresseService  {
   @Autowired
   private AdresseRepo adresseRepo;

@Override
public List<Adresse> getAllAdresse() {
	return adresseRepo.findAll();
}

@Override
public Adresse createAdresse(Adresse adresse) {
	return adresseRepo.save(adresse);
}

@Override
public Adresse getAdresseById(int id) {
	Optional<Adresse> opt = adresseRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Adresse with this id is not found"));
}


}
