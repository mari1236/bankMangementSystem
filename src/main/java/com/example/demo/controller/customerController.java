package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customers;
import com.example.demo.repository.genericRepo;

@RestController
@RequestMapping("/API/customers")

public class customerController extends BaseController<Customers> {

	public customerController(genericRepo<Customers> repos) {
		super(repos);
		
	}

}
