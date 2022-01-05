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
		Optional<Application> app = applicationRepository.findById(id);

		if (!app.isPresent())
			throw new ApplicationNotFoundException("id-" + id);

		return app.get();
	}
	
	@DeleteMapping("/applications/{id}")
	public void deleteApp(@PathVariable int id) {
		applicationRepository.deleteById(id);
	}
	
	@PostMapping("/applications")
	public ResponseEntity<Object> createApplication(@RequestBody Application app) {
		Application applicationInstance = applicationRepository.save(app);
		System.out.println("app id " + applicationInstance.getId());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(applicationInstance.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/applications/{id}")
	public ResponseEntity<Object> updateApp(@RequestBody Application app, @PathVariable int id) {

		Optional<Application> appOptional = applicationRepository.findById(id);

		if (!appOptional.isPresent())
			return ResponseEntity.notFound().build();

		app.setId(id);
		
		applicationRepository.save(app);

		return ResponseEntity.noContent().build();
	}
}
