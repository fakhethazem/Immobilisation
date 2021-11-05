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
import com.tekup.Immobilisation.Services.IAdresseService;
import com.tekup.Immobilisation.Services.IAnnonceService;
import com.tekup.Immobilisation.Services.IClientService;
import com.tekup.Immobilisation.entities.Adresse;
import com.tekup.Immobilisation.entities.Annonce;
import com.tekup.Immobilisation.entities.Client;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AdresseController {

@Autowired
private IAdresseService adresseServiceImp;


@GetMapping("/adresses")
public List<Adresse> getAllfromDB(){
	return adresseServiceImp.getAllAdresse();
}


@GetMapping("/adresses/{id}")
public Adresse getOnefromDB(@PathVariable int id){
	return adresseServiceImp.getAdresseById(id);
}



@PostMapping("/adresses")
public Adresse saveToDB(@RequestBody Adresse adresse) {
	return adresseServiceImp.createAdresse(adresse);
}



@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in adresse : " + e.getMessage());
}

}
