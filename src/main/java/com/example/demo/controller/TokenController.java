package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jWUtils.TokenUtils;
import com.example.demo.models.Response;
import com.example.demo.models.Users;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.userRepo;
import com.example.demo.service.MyService;
@RestController
public class TokenController {

	@Autowired
	private MyService service;
	
	@Autowired
	private TokenUtils token;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private userRepo uRepo;
	
	@Autowired
	private RoleRepo rRepo;
	

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody Users user) throws UsernameNotFoundException
	{
	     try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found");
		}
	     
	     UserDetails userDetails=this.service.loadUserByUsername(user.getUsername());
	     String token=this.token.generateToken(userDetails);
	     System.out.println("JWT: " +token);
		return ResponseEntity.ok(new Response(token));
	}
}
