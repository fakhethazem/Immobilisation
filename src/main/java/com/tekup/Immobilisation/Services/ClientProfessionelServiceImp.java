package com.tekup.Immobilisation.Services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tekup.Immobilisation.Repository.ClientParticulierRepo;
import com.tekup.Immobilisation.Repository.ClientProfessionelRepo;
import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.Repository.ClientTempRepo;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.ClientTemp;
import com.tekup.Immobilisation.entities.ParticulierClient;
import com.tekup.Immobilisation.entities.ProClient;



@Service
public class ClientProfessionelServiceImp implements IClientProfessionelService  {
	
	@Autowired
	    private JavaMailSender javaMailSender;
    @Autowired
   private ClientProfessionelRepo clientProfessionelRepo;
   @Autowired
   private ClientTempRepo clientTempRepo;
   

@Override
public List<ProClient> getAllPartClient() {
	return clientProfessionelRepo.findAll();
}



@Override
public ProClient getPartClientById(int id) {
	Optional<ProClient> opt = clientProfessionelRepo.findById(id);
	return opt.orElseThrow(()->new NoSuchElementException("Client pro with this id is not found"));
}

@Override
public ProClient updatePartClient(int id, ProClient newClient) {
	ProClient client=getPartClientById(id);
	if(newClient.getName()!=null)
		client.setName(newClient.getName());
	if(newClient.getLastName()!=null)
		client.setLastName(newClient.getLastName());
	if(newClient.getEmail()!=null)
		client.setEmail(newClient.getEmail());
	if(newClient.getPassword()!=null)
		client.setPassword(newClient.getPassword());
	if(newClient.getNumberphone()!=null)
		client.setNumberphone(newClient.getNumberphone());
	if(newClient.getBirthdaydate()!=null)
		client.setBirthdaydate(newClient.getBirthdaydate());
	if(newClient.getAnnonces()!=null)
		client.setAnnonces(newClient.getAnnonces());
      if(newClient.getVisits()!=null)
		client.setVisits(newClient.getVisits());
      if(newClient.getCommission()!= 0)
  		client.setCommission(newClient.getCommission());
	 return clientProfessionelRepo.save(client);
}

@Override
public ProClient deletePartClient(int id) {
	ProClient client = getPartClientById(id);
	clientProfessionelRepo.deleteById(id);
	return client;
}

@Override
public ProClient createProClient(int id) {
	ClientTemp clienttemp=clientTempRepo.getById(id);
	ProClient proClient = new ProClient();
	proClient.setId_client(clienttemp.getId_clienttemp());
	proClient.setName(clienttemp.getName());
	proClient.setLastName(clienttemp.getLastName());
	proClient.setEmail(clienttemp.getEmail());
	proClient.setPassword(clienttemp.getPassword());
	proClient.setBirthdaydate(clienttemp.getBirthdaydate());
	proClient.setNumberphone(clienttemp.getNumberphone());
	sendEmail(proClient);
	clientTempRepo.deleteById(id);
	return clientProfessionelRepo.save(proClient);
	
	
}

public void sendEmail(ProClient pro)
{
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setFrom("imobilisationservice@gmail.com");
	mail.setTo(pro.getEmail());
	mail.setSubject("your account has been created");
	mail.setText("Hello....your account has been created as profesionel client");

	javaMailSender.send(mail);
}
/*
@Override
public List<ProClient> addproClient(String name) {
	 List<ProClient> listo =new ArrayList <>();
	ClientDto  cdo = null;
	ProClient pro =null;
	String clienturl="http://127.0.0.1:8080/register";
	ModelMapper mapper = new ModelMapper();
	ResponseEntity<List<ClientDto>> responseEntity = 
			  restTemplate.exchange(
			    clienturl,
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<ClientDto>>() {}
			  );
			List<ClientDto> clients = responseEntity.getBody();
	 for (ClientDto cd : clients) {
		 if(cd.getName()==name) {
			 cdo=cd;
		 }
	 }
	 pro = mapper.map(cdo, ProClient.class);
	 listo.add(pro);
	return  listo;

}
*/


}
