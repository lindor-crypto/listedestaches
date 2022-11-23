package com.diallo.rest.webservices.restfullservices.Taches.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


import org.springframework.stereotype.Service;

import com.diallo.rest.webservices.restfullservices.Taches.Model.Todo;



@Service
public class TodoService {
	
	
	private static long idCounter = 0;
	//private TodoRepository repository;
	
	
	
	public TodoService () {
		
	}
	
	

	private static List<Todo> todos = new ArrayList<>();
	
	static  {
			todos.add( new Todo (++idCounter, "Learn Jav", new Date(), false));
			todos.add( new Todo (++idCounter,  "Learn Angula", new Date(), false));
			todos.add( new Todo (++idCounter,  "Learn Java Scrip", new Date(), false));
			todos.add( new Todo (++idCounter, "Learn Hopex", new Date(), false));
	}
	
		public List<Todo> findAll(){
			return todos;
		}
		
		public Todo deleteById(Long id) {
		
			if(findById(id)==null) return null;
			if(	todos.remove(findById(id)))return findById(id);
			return null;
		}


		public Todo findById(Long id) {
			// TODO Auto-generated method stub
			
			for (Todo todo : todos) {
				if(todo.getId() == id) {
					return todo;
				}
			}
			return null;
		}
		
		
		public Todo save(Todo todo) {
			
			//Todo savetodo = repository.save(todo);
			if(todo.getId() ==-1 || todo.getId() ==0) {
				todo.setId(++idCounter);
				todos.add(todo);
			}else {
				deleteById(todo.getId());
				todos.add(todo);
			}
			//return savetodo;
			return todo;
		}
		
		
}