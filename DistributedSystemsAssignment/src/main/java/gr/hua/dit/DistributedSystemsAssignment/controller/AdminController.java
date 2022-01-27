package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;
import java.util.Collections;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private RestTemplate restTemplate;

	public AdminController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@ModelAttribute("user")
	public User registrationApp() {
		return new User();
	}
	
	@GetMapping
	public String showForm() {
		return "adminPage";
	}
	
	@PostMapping("/saveUser")
	public RedirectView saveApp(@ModelAttribute("user") User user) throws IOException {

		String url = "http://localhost:8080/api/users";

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		restTemplate.postForObject(url, entity, User.class);
		return new RedirectView("/admin", true);

	}
	
	@PutMapping("/saveUser")
	public RedirectView putUser(@ModelAttribute("user") User user) throws IOException {

		String url = "http://localhost:8080/api/users";

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<User> entity = new HttpEntity<>(user, headers);

		restTemplate.put(url, entity, User.class);
		return new RedirectView("/admin", true);
	}
	
}
