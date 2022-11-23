package com.diallo.rest.webservices.restfullservices.Taches.Controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diallo.rest.webservices.restfullservices.Taches.Model.Todo;
import com.diallo.rest.webservices.restfullservices.Taches.services.TodoService;






@RequestMapping
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@GetMapping(path = "/basicauth/{username}")
	public Map<String, String>  SayHello(@PathVariable String username) {
	    HashMap<String, String> map = new HashMap<>();
	    map.put("message", "welcome : your are authenticated");
	    return map;
	   // throw new RuntimeException("Some Errors Happened! Please contact the support*************");
	
	}
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return service.findAll();
		
	}
	
	
	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return service.findById(id);
		
	} 
	@DeleteMapping("/users/{username}/todos/{id}")
	public void delete(@PathVariable String username, @PathVariable long id){
		
		
				service.deleteById(id);
		
	}
	/*public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = service.deleteById(id);
		if(todo!=null) {
			
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}*/
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updatetodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
		 Todo savetodo = service.save(todo);
		 //return ResponseEntity.ok(savetodo);
		 return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	@RequestMapping(value = "/users/{username}/todos", method=RequestMethod.POST)
	public ResponseEntity<Void> saveTodo(@PathVariable String username,@RequestBody Todo todo) {
        Todo createTodo = service.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
	

}