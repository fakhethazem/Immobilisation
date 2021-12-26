package com.tekup.Immobilisation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekup.Immobilisation.JwtUtil;
import com.tekup.Immobilisation.entities.AuthRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
    private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	 

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	try {authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    } catch (Exception ex) {
    	throw new Exception("invalid user email or password");
    }
    	 return jwtUtil.generateToken(authRequest.getEmail());
		
    }
}
