package com.tekup.Immobilisation.Services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.AnnonceRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.Repository.VisteRepo;
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;
import com.tekup.Immobilisation.entities.Visit;
import com.tekup.Immobilisation.entities.VisitKey;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VisitServiceImp implements IVisitService  {
   @Autowired
   private VisteRepo visiteRepo;

 @Override
public Iterable<Visit> getAllVisits() {
	return visiteRepo.findAll();
}

@Override
public Visit createVisit(Visit visit) {
	return visiteRepo.save(visit);
}

@Override
public Visit getVisitById(VisitKey id) {
	Optional<Visit> opt = visiteRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Visit with this id is not found"));
}

@Override
public Visit updateVisit(VisitKey id, Visit newvisit) {
	Visit visit=getVisitById(id);
	if(newvisit.getDate_visite()!=null)
		visit.setDate_visite(newvisit.getDate_visite());
	
	 return visiteRepo.save(visit);
}

@Override
public List<Visit> getAllVisitsbyemedded(Integer clientid) {
	return visiteRepo.findByVisitKeyClientId(clientid);
}
}
