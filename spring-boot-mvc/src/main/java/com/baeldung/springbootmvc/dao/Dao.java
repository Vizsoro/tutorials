package com.baeldung.springbootmvc.dao;

import java.util.Collection;
import java.util.Optional;

import com.baeldung.springbootmvc.model.Todo;

public interface Dao<T> {
	
	Optional<T> get(int id);
	
	Collection<Todo> getAll();
	
	int save(T t);
	
	void update(int id, T t);
	
	void delete(int id);
}
