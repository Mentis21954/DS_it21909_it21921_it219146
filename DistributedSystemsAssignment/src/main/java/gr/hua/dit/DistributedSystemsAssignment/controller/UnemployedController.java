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

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.repository.UnemployedRepository;

@RestController
public class UnemployedController {
	@Autowired
	private UnemployedRepository unemployedRepository;
	
	@GetMapping("/unemployed")
	public List<Unemployed> retrieveAllStudents() {
		return unemployedRepository.findAll();
	}
	
	@GetMapping("/unemployed/{id}")
	public Unemployed retrieveStudent(@PathVariable int id) {
		Optional<Unemployed> unemployed = unemployedRepository.findById(id);

		if (!unemployed.isPresent())
			throw new UnemployedNotFoundException("id-" + id);

		return unemployed.get();
	}
	
	@DeleteMapping("/unemployed/{id}")
	public void deleteunemployed(@PathVariable int id) {
		unemployedRepository.deleteById(id);
	}
	
	@PostMapping("/unemployed")
	public ResponseEntity<Object> createUnemployed(@RequestBody Unemployed unemployed) {
		Unemployed unemployedInstance = unemployedRepository.save(unemployed);
		System.out.println("unemployed id " + unemployedInstance.getId());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(unemployedInstance.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/unemployed/{id}")
	public ResponseEntity<Object> updateUnemployed(@RequestBody Unemployed unemployed, @PathVariable int id) {

		Optional<Unemployed> unemployedOptional = unemployedRepository.findById(id);

		if (!unemployedOptional.isPresent())
			return ResponseEntity.notFound().build();

		unemployed.setId(id);
		
		unemployedRepository.save(unemployed);

		return ResponseEntity.noContent().build();
	}
}
