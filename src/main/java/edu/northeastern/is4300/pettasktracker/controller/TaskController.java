package edu.northeastern.is4300.pettasktracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.is4300.pettasktracker.exception.ResourceNotFoundException;
import edu.northeastern.is4300.pettasktracker.model.Task;
import edu.northeastern.is4300.pettasktracker.repository.TaskRepository;

@RestController
@RequestMapping("/api")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	// Get all tasks
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
	    return taskRepository.findAll();
	}
	
	// Create a task
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	// Get task by ID
	@GetMapping("/tasks/{id}")
	public Task getTaskById(@PathVariable(value="id") Long taskId) {
		return taskRepository.findById(taskId)
				 .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));
	}
	
	// Update a Task
	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable(value = "id") Long taskId,
	                                        @Valid @RequestBody Task petDetails) {

	    Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	

	    return taskRepository.save(task);
	}
	
	// Delete a Task
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) {
	    Task task = taskRepository.findById(taskId)
	            .orElseThrow(() -> new ResourceNotFoundException("Task", "id", taskId));

	    taskRepository.delete(task);

	    return ResponseEntity.ok().build();
	}
}

