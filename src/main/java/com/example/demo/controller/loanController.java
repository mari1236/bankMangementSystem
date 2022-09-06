package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Loan;
import com.example.demo.repository.genericRepo;

@RestController
@RequestMapping("/API/loan")
public class loanController extends BaseController<Loan> {

	public loanController(genericRepo<Loan> repos) {
		super(repos);
		
	}

}
