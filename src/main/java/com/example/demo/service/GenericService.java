package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.genericRepo;

public abstract class GenericService<T> implements Repositorys<T> {
   
	   
   
	private final genericRepo<T> repos;
	
	public GenericService(genericRepo<T> repos)
	{
		this.repos=repos;
	}
	
	public T insert(T t)
	{
		return repos.save(t);
	}
	
	public List<T> getAll()
	{
		return repos.findAll();
	}
	public void delete(int id)
	{
		repos.deleteById(id);
	
	}
	
	public Optional<T> getById(int id)
	{
		return repos.findById(id);
	}
	
	public T update(T t)
	{
		return repos.save(t);
	}
   }
  
	

