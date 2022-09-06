package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employeess;
import com.example.demo.repository.genericRepo;


@RestController
@RequestMapping("/API/employee")
public class employeeController extends BaseController<Employeess> {

	public employeeController(genericRepo<Employeess> repos) {
		super(repos);
	}

}
