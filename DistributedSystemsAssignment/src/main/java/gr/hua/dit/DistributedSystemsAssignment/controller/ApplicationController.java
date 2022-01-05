package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.repository.ApplicationRepository;
import gr.hua.dit.DistributedSystemsAssignment.controller.ApplicationNotFoundException;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@GetMapping("/applications")
	public List<Application> retrieveAllStudents() {
		return applicationRepository.findAll();
	}
	
	@GetMapping("/applications/{id}")
	public Application retrieveStudent(@PathVariable int id) {
		Optional<Application> student = applicationRepository.findById(id);

		if (!student.isPresent())
			throw new ApplicationNotFoundException("id-" + id);

		return student.get();
	}
	
	@DeleteMapping("/applications/{id}")
	public void deleteStudent(@PathVariable int id) {
		applicationRepository.deleteById(id);
	}
	
	@PostMapping("/applications")
	public ResponseEntity<Object> createApplication(@RequestBody Application student) {
		Application applicationInstance = applicationRepository.save(student);
		System.out.println("student id " + applicationInstance.getId());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(applicationInstance.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/applications/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Application student, @PathVariable int id) {

		Optional<Application> studentOptional = applicationRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		applicationRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}
