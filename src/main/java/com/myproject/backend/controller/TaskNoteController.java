package com.myproject.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.backend.exception.ResourceNotFoundException;
import com.myproject.backend.model.TaskNote;
import com.myproject.backend.repository.TaskNoteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TaskNoteController {

	@Autowired
	private TaskNoteRepository taskNoteRepository;

	//	get all task notes
	@GetMapping("/tasknotes")
	public List<TaskNote> getAllTaskNotes(){
		return taskNoteRepository.findAll();
	}
	
	//  create task note
	@PostMapping("/tasknotes")
	public TaskNote createTaskNote(@RequestBody TaskNote tasknote) {
		return taskNoteRepository.save(tasknote);
	}
	
	//	get task note by id
	@GetMapping("/tasknotes/{id}")
	public ResponseEntity<TaskNote> getTaskNoteById(@PathVariable Long id) {
		TaskNote tasknote = taskNoteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task does not exist with seq number : "+id));
		return ResponseEntity.ok(tasknote);
	}
	
	//  update task note
	@PutMapping("/tasknotes/{id}")
	public ResponseEntity<TaskNote> updateTaskNote(@PathVariable Long id, @RequestBody TaskNote tasknoteDetails){
		TaskNote tasknote = taskNoteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task does not exist with seq number : "+id));
		tasknote.setTitle(tasknoteDetails.getTitle());
		tasknote.setDescription(tasknoteDetails.getDescription());
		TaskNote updatedTaskNote = taskNoteRepository.save(tasknote);
		return ResponseEntity.ok(updatedTaskNote);
	}
	
	//	delete task note
	@DeleteMapping("/tasknotes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTaskNote(@PathVariable Long id){
		TaskNote tasknote = taskNoteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task does not exist with seq number : "+id));
		taskNoteRepository.delete(tasknote);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
