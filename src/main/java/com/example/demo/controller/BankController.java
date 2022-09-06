package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Bank;
import com.example.demo.repository.genericRepo;

@RestController
@RequestMapping("/API/bank")


public class BankController extends BaseController<Bank> {

	public BankController(genericRepo<Bank> repos) {
		super(repos);
		
	}

}
