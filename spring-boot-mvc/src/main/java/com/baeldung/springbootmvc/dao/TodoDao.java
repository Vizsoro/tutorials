package com.baeldung.springbootmvc.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.baeldung.springbootmvc.model.Todo;

@Component
public class TodoDao implements Dao<Todo> {
	
	private Map<Integer,Todo> todoMap = new HashMap<>();
	
	@Override
	public Optional<Todo> get(int id) {
		return Optional.ofNullable(todoMap.get(id));
	}
	
	@Override
	public Collection<Todo> getAll() {
		return Collections.unmodifiableCollection(todoMap.values());
	}
	
	@Override
	public int save(Todo todo) {
		todoMap.put(todoMap.size(), todo);
		return todoMap.size()-1;
	}
	
	@Override
	public void update(int id, Todo todo) {
		checkId(id);
		todoMap.put(id, todo);
	}
	
	@Override
	public void delete(int id) {
		checkId(id);
		todoMap.remove(id);
	}
	
	private void checkId(int id) {
		Todo previousTodo = todoMap.get(id);
		if(previousTodo == null){
			throw new IllegalArgumentException("There is no todo with such id!");
		}
	}
	
}
