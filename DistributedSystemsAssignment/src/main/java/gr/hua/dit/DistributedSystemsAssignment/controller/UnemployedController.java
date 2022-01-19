package gr.hua.dit.DistributedSystemsAssignment.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

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

import gr.hua.dit.DistributedSystemsAssignment.controller.modelAssembler.UnemployedModelAssembler;
import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.service.UnemployedService;

@RestController
@RequestMapping("/api")
public class UnemployedController {

	@Autowired
	private UnemployedService unemployedService;
	
	@Autowired
	private UnemployedModelAssembler assembler;
	
	@GetMapping("/unemployed")
	public CollectionModel<EntityModel<Unemployed>> getAllUnemployeds() {
		List<EntityModel<Unemployed>> unemployed = unemployedService.getUnemployeds().stream().map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(unemployed, linkTo(methodOn(UnemployedController.class).getAllUnemployeds()).withSelfRel());
	}
	
	@GetMapping("/unemployed/{id}")
	public EntityModel<Unemployed> getUnemployed(@PathVariable int id) {
		Unemployed unemployed = unemployedService.getUnemployed(id); 
		return assembler.toModel(unemployed);
	}
	
	@PostMapping("/unemployed")
	public void newUnemployed(@RequestBody Unemployed newUnemployed) {
		unemployedService.saveUnemployed(newUnemployed);
	}
	
	@PutMapping("/unemployed/{id}")
	public void replaceUnemployed(@RequestBody Unemployed newUnemployed,@PathVariable int id) {
		unemployedService.updateUnemployed(newUnemployed,id);
	}
	
	@DeleteMapping("/unemployed/{id}")
	public ResponseEntity<Object> deleteUnemployed(@PathVariable int id) {
		unemployedService.deleteUnemployed(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
