package com.tekup.Immobilisation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.Immobilisation.JwtUtil;
import com.tekup.Immobilisation.entities.AuthRequest;
import com.tekup.Immobilisation.entities.CustomUserDetails;
import com.tekup.Immobilisation.entities.JwtResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
    private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	 

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	try {
    		 Authentication authentication=authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    		 SecurityContextHolder.getContext().setAuthentication(authentication);
    		  CustomUserDetails customer = (CustomUserDetails) authentication.getPrincipal();
    		  String token =jwtUtil.generateToken(authRequest.getEmail());
    			return ResponseEntity.ok(new JwtResponse(token,customer.getUser()));
    } catch (Exception ex) {
    	throw new Exception("invalid user email or password");
    }
    	
    	
    	  
   	      
    
    	//return jwtUtil.generateToken(authRequest.getEmail());
		
    }
}
