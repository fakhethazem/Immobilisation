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
import com.tekup.Immobilisation.Services.IClientParticulierService;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientParticulierController {

@Autowired
private IClientParticulierService clientPartServiceImp;


@GetMapping("/clients/Particulier")
public List<ParticulierClient> getAllfromDB(){
	return clientPartServiceImp.getAllPartClient();
}


@GetMapping("/clients/Particulier/{id}")
public ParticulierClient getOnefromDB(@PathVariable int id){
	return clientPartServiceImp.getPartClientById(id);
}



@PostMapping("/clients/Particulier")
public ParticulierClient saveToDB(@RequestBody ParticulierClient client) {
	//call of service
	return clientPartServiceImp.createPartClient(client);
}


@PutMapping("/clients/Particulier/{id}")
public ParticulierClient updateOnefromDB(@PathVariable int id,@RequestBody ParticulierClient client){
	return clientPartServiceImp.updatePartClient(id, client);
}


@DeleteMapping("/clients/Particulier/{id}")
public ParticulierClient deleteOnefromDB(@PathVariable int id){
	return clientPartServiceImp.deletePartClient(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in client : " + e.getMessage());
}

}
