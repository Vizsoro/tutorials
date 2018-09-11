package com.baeldung.springbootmvc.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baeldung.springbootmvc.dao.Dao;
import com.baeldung.springbootmvc.model.Todo;

@Service
public class TodoService {
	
	@Autowired
	private Dao<Todo> todoDao;
	
	public int save(Todo todo){
		validate(todo);
		return todoDao.save(todo);
	}
	
	public Collection<Todo> loadAll(){
		return todoDao.getAll();
	}
	
	public Collection<Todo> loadByPriority(int priority){
		return todoDao
				.getAll()
				.stream()
				.filter(todo -> todo.getPriority() == priority)
				.collect(Collectors.toList());
	}
	
	public Optional<Todo> getMostUrgent(){
		return todoDao
				.getAll()
				.stream()
				.sorted(Comparator.comparing(Todo::getDeadline))
				.findFirst();
	}
	private void validate(Todo todo) {
		if(todo.getDeadline().isBefore(LocalDate.now())){
			throw new IllegalArgumentException("Deadline must be in the future!");
		}
	}
	
}
