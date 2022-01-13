package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationNotFoundException;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ApplicationModelAssembler assembler;
	
	@GetMapping("/applications")
	public CollectionModel<EntityModel<Application>> getAllApplications() {
		List<EntityModel<Application>> applications = applicationService.getApplications().stream().map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(applications, linkTo(methodOn(ApplicationController.class).getAllApplications()).withSelfRel());
	}
	
	@GetMapping("/applications/{id}")
	public EntityModel<Application> getApplication(@PathVariable int id) {
		Application app = applicationService.getApplication(id); 
		return assembler.toModel(app);
	}
	
	@PostMapping("/applications")
	public void newApplication(@RequestBody Application newApplication) {
		applicationService.saveApplication(newApplication);
	}
	
	@PutMapping("/applications/{id}")
	public void replaceApplication(@RequestBody Application newApplication,@PathVariable int id) {
		applicationService.updateApplication(newApplication,id);
	}
	
	@DeleteMapping("/applications/{id}")
	public ResponseEntity<Object> deleteApplication(@PathVariable int id) {
		applicationService.deleteApplication(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/applications/submitted")
	public CollectionModel<EntityModel<Application>> getAllUnvalidatedApplications() {
		List<EntityModel<Application>> applications = applicationService.getNotValidatedApplications().stream().map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(applications, linkTo(methodOn(ApplicationController.class).getAllUnvalidatedApplications()).withSelfRel());
	}
	
	@GetMapping("/applications/submitted/{id}")
	public EntityModel<Application> getUnvalidatedApplication(@PathVariable int id) {
		Application app;
		try {
		app = applicationService.getNotValidatedApplications().get(--id);
		} catch(Exception e) {
			throw new ApplicationNotFoundException(++id);
		}
		return assembler.toModelSubmitted(app);
	}
	
	@GetMapping("/applications/validated")
	public CollectionModel<EntityModel<Application>> getAllUnauthorizedApplications() {
		List<EntityModel<Application>> applications = applicationService.getNotValidatedApplications().stream().map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(applications, linkTo(methodOn(ApplicationController.class).getAllUnauthorizedApplications()).withSelfRel());
	}
	
	@GetMapping("/applications/validated/{id}")
	public EntityModel<Application> getUnauthorizedApplication(@PathVariable int id) {
		Application app;
		try {
		app = applicationService.getNotAuthorizedApplications().get(--id);
		} catch(Exception e) {
			throw new ApplicationNotFoundException(++id);
		}
		return assembler.toModelValidated(app);
	}
	
}
