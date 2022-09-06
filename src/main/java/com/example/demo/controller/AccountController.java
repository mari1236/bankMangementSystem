package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.repository.genericRepo;

@RestController
@RequestMapping("/API/account")
public class AccountController extends BaseController<Account> {

	public AccountController(genericRepo<Account> repos) {
		super(repos);
		
	}

}
