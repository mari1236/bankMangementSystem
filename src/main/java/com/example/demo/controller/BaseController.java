package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.genericRepo;
import com.example.demo.service.GenericService;

public abstract class BaseController<T> {

	
	private final GenericService<T> service;
	
	public BaseController(genericRepo<T> repos) {
		this.service=new GenericService<T>(repos){}; 

		}
	
	
	@PostMapping("/ReadRecord")
	@PreAuthorize("hasRole('ADMIN')")
	public T insertion(@Valid @RequestBody T t)
	{
		
		return service.insert(t);
	}
	
	@GetMapping("/fetchRecord")
	@PreAuthorize("hasRole('USER')")
	public List<T> getAllRecord()
	{
		return service.getAll();
	}
	
	@DeleteMapping("/record/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void DeleteRecord(@PathVariable("id") int id)
	{
		service.delete(id);
	}
	
	@PutMapping("/updateRecord")
	//@PreAuthorize("hasRole('USER')")
	public T updateRecord(@RequestBody T t)
	{
		return service.update(t);
	}
	@GetMapping("/record/{id}")
	@PreAuthorize("hasRole('USER')")
	public Optional<T> getThrougID(@PathVariable("id") int id)
	{
		return service.getById(id);
	}
	
}
