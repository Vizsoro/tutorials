package com.baeldung.springbootmvc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Todo {
	
	 private String message;
	 private int priority;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	 private LocalDate deadline;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public LocalDate getDeadline() {
		return deadline;
	}
	
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
}
