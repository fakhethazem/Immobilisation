package com.tekup.Immobilisation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tekup.Immobilisation.Repository.ClientRepo;
import com.tekup.Immobilisation.entities.Client;
import com.tekup.Immobilisation.entities.CustomUserDetails;
@Service
public class MyclientDetailService implements UserDetailsService {
	 @Autowired
	    private ClientRepo clientRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepo.findByName(username);
        if (client == null) {
            throw new UsernameNotFoundException("client not found");
        }
        return new CustomUserDetails(client);
    }
	}


