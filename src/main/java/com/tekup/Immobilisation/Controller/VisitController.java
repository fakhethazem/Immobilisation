package com.tekup.Immobilisation.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.Immobilisation.Services.ClientServiceImp;
import com.tekup.Immobilisation.Services.IAnnonceService;
import com.tekup.Immobilisation.Services.IClientService;
import com.tekup.Immobilisation.Services.IVisitService;
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.Visit;
import com.tekup.Immobilisation.entities.VisitKey;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VisitController {

@Autowired
private IVisitService visitServiceImp;


@GetMapping("/Visits/test/{id}")
public List<Visit> getAll(@PathVariable Integer id){
	return visitServiceImp.getAllVisitsbyemedded(id);
}

@GetMapping("/Visits")
public Iterable<Visit> getAllfromDB(){
	return visitServiceImp.getAllVisits();
}

@GetMapping("/Visits/{id}")
public Visit getOnefromDB(@PathVariable VisitKey id){
	return visitServiceImp.getVisitById(id);
}


@PostMapping("/Visits")
public Visit saveToDB(@RequestBody Visit visit) {
	return visitServiceImp.createVisit(visit);
}


@PutMapping("/Visits/{id}")
public Visit updateOnefromDB(@PathVariable VisitKey id,@RequestBody Visit visit){
	return visitServiceImp.updateVisit(id, visit);
}




@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in visit : " + e.getMessage());
}

}
