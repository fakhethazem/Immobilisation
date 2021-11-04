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
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AnnonceController {

@Autowired
private IAnnonceService annonceServiceImp;


@GetMapping("/annonces")
public List<Annonce> getAllfromDB(){
	return annonceServiceImp.getAllAnnonces();
}


@GetMapping("/annonces/{id}")
public Annonce getOnefromDB(@PathVariable int id){
	return annonceServiceImp.getAnnonceById(id);
}



@PostMapping("/annonces")
public Annonce saveToDB(@RequestBody Annonce annonce) {
	return annonceServiceImp.createAnnonce(annonce);
}


@PutMapping("/annonces/{id}")
public Annonce updateOnefromDB(@PathVariable int id,@RequestBody Annonce annonce){
	return annonceServiceImp.updateAnnonce(id, annonce);
}


@DeleteMapping("/annonces/{id}")
public Annonce deleteOnefromDB(@PathVariable int id){
	return annonceServiceImp.deleteAnnonce(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in client : " + e.getMessage());
}

}
