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
import com.tekup.Immobilisation.Services.IClientService;
import com.tekup.Immobilisation.entities.Client;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {

@Autowired
private IClientService clientServiceImp;


@GetMapping("/clients")
public List<Client> getAllfromDB(){
	return clientServiceImp.getAllClient();
}


@GetMapping("/clients/{id}")
public Client getOnefromDB(@PathVariable int id){
	return clientServiceImp.getClientById(id);
}



@PostMapping("/clients")
public Client saveToDB(@RequestBody Client client) {
	//call of service
	return clientServiceImp.createClient(client);
}


@PutMapping("/clients/{id}")
public Client updateOnefromDB(@PathVariable int id,@RequestBody Client client){
	return clientServiceImp.updateClient(id, client);
}


@DeleteMapping("/clients/{id}")
public Client deleteOnefromDB(@PathVariable int id){
	return clientServiceImp.deleteClient(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in client : " + e.getMessage());
}

}
