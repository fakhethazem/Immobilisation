package com.tekup.Immobilisation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.Immobilisation.Services.IClientService;
import com.tekup.Immobilisation.Services.RegisterService;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ClientTemp;
import com.tekup.Immobilisation.entities.ProClient;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {
	

@Autowired
private RegisterService registerService;

@GetMapping("/clients/temp")
public List<ClientTemp> getOnefromDB( ){
	return registerService.getListRegister();
}



@PostMapping("/clients/temp")
public ClientTemp saveToDB(@RequestBody ClientTemp clientTemp) {
	//call of service
	return registerService.setDataToRegister(clientTemp);
}


}
