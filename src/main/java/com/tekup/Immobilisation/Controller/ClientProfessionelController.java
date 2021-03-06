package com.tekup.Immobilisation.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tekup.Immobilisation.Services.IClientParticulierService;
import com.tekup.Immobilisation.Services.IClientProfessionelService;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ParticulierClient;
import com.tekup.Immobilisation.entities.ProClient;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientProfessionelController {
	
	
@Autowired
private IClientProfessionelService clientproServiceImp;


/*
@GetMapping("/clients/test")
public List<ProClient> getAll(){
	return clientproServiceImp.addproClient();
}
 */
@GetMapping("/clients/professionel")
public List<ProClient> getAllfromDB(){
	return clientproServiceImp.getAllPartClient();
}


@GetMapping("/clients/professionel/{id}")
public ProClient getOnefromDB(@PathVariable int id){
	return clientproServiceImp.getPartClientById(id);
}



@PostMapping("/clients/professionel/{id}")
public ProClient saveToDB(@PathVariable Integer id) {
	//call of service
	return clientproServiceImp.createProClient(id);
}


@PutMapping("/clients/professionel/{id}")
public ProClient updateOnefromDB(@PathVariable int id,@RequestBody ProClient client){
	return clientproServiceImp.updatePartClient(id, client);
}


@DeleteMapping("/clients/professionel/{id}")
public ProClient deleteOnefromDB(@PathVariable int id){
	return clientproServiceImp.deletePartClient(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
	//return new ResponseEntity<String>("Error in Employee : " + e.getMessage()
	//										, HttpStatus.BAD_REQUEST);
	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body("Error in client : " + e.getMessage());
}

}
