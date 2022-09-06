package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Branch;
import com.example.demo.repository.genericRepo;

@RestController
@RequestMapping("/API/branch")
public class branchController extends BaseController<Branch> {

	public branchController(genericRepo<Branch> repos) {
		super(repos);
		
	}

}
