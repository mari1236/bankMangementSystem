package com.example.demo.service;

import java.util.List;
import java.util.Optional;

public interface Repositorys<T> {
	
	T insert(T t);
	
	T update(T t);
	
	void delete(int id);
	
	List<T> getAll();
	
	Optional<T> getById(int id);

}
