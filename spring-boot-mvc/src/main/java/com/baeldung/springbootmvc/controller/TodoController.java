package com.baeldung.springbootmvc.controller;

import java.time.LocalDateTime;

import groovy.util.logging.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baeldung.springbootmvc.model.Todo;
import com.baeldung.springbootmvc.service.TodoService;

@Controller
@Log
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@GetMapping(value= "/todo")
	public String home(Model model) {
		logger.info("todo endpoint triggered.");
		model.addAttribute("message", "Welcome to the TO-DO application!");
		model.addAttribute("systemTime", LocalDateTime.now());
		model.addAttribute("todoList", service.loadAll());
		return "todo";
	}
	
	@PostMapping(value= "/todo")
	public String save(@ModelAttribute("todo") Todo todo, BindingResult bindingResult,  ModelMap model){
		if(bindingResult.hasErrors()){
			model.addAttribute("message", "Invalid data!");
		}
		try{
			int id = service.save(todo);
			model.addAttribute("message", "New TO-DO saved with id:" + id);
		} catch (Exception e){
			logger.warn("Error during save!", e);
			model.addAttribute("message", e.getMessage());
		}
		model.addAttribute("todoList", service.loadAll());
		return "todo";
	}
}
