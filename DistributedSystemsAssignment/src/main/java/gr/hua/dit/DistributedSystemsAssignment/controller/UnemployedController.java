package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.service.UnemployedService;

@RestController
@RequestMapping("/api")
public class UnemployedController {

	@Autowired
	private UnemployedService unemployedService;
	
	@GetMapping("/unemployed")
	public List<Unemployed> getAllUnemployeds() {
		return unemployedService.getUnemployeds();
	}
	
	@GetMapping("/unemployed/{id}")
	public Unemployed getUnemployed(@PathVariable int id) {
		return unemployedService.getUnemployed(id);
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
