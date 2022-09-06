package com.example.demo.service;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Principal.usersPrincipals;
import com.example.demo.models.Users;
import com.example.demo.repository.userRepo;

@Service
public class MyService implements UserDetailsService {
	
	@Autowired
	private userRepo uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user=uRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User is not found");
		return usersPrincipals.build(user);
		
		
}
}
