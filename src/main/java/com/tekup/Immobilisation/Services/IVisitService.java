package com.tekup.Immobilisation.Services;

import java.util.List;

import com.tekup.Immobilisation.entities.Adresse;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.Visit;
import com.tekup.Immobilisation.entities.VisitKey;

public interface IVisitService {
	
public Iterable<Visit> getAllVisits();
public Visit createVisit(Visit visit);
public Visit getVisitById(VisitKey id);
public Visit updateVisit(VisitKey id, Visit visit);
public List<Visit> getAllVisitsbyemedded(Integer clientid);

}
