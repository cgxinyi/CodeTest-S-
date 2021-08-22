package com.example.demo.restcontroller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class APIcontroller {
	
	private Object data;
	@JsonIgnore
	private Errors errors;	
	
	
	public APIcontroller(Object data, Errors errors) {
		this.data = data;
		this.errors = errors;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public List<String> getMessage() {
		if (this.errors != null) {
			List<String> allErrors = new ArrayList<>();
			this.errors.getAllErrors().forEach(e -> {
				allErrors.add(e.getDefaultMessage());
			});
			return allErrors;
		}
		return null;
	}
	
}