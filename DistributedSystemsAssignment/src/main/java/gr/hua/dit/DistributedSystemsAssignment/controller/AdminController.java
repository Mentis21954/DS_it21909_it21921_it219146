package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserCustomDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private RestTemplate restTemplate;

	public AdminController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	Random rand = new Random();
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
    int rand_int = rand.nextInt(1000000);
	
	@ModelAttribute("user")
	public User registrationApp() {
		return new User();
	}
	
	@GetMapping
	public String showForm() {
		return "adminPage";
	} //delete this when you have made the getmapping with the model
	
	/*
	@PostMapping("/saveUser")
	public RedirectView saveApp(@ModelAttribute("usercustom") UserCustomDto userCustomDto) throws IOException {

		String url = "http://localhost:8080/api/users";

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		ArrayList<Authority> auth = new ArrayList<>();
		auth.add(new Authority(userCustomDto.getAuthority()));
		User user = new User(userCustomDto.getUsername(),passwordEncoder.encode(String.valueOf(rand_int)),true,auth);

		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		System.out.println("Inside post, before send");
		restTemplate.postForObject(url, entity, User.class);
		return new RedirectView("/admin", true);

	}
	
	@PutMapping("/saveUser")
	public RedirectView putUser(@ModelAttribute("usercustom") UserCustomDto userCustomDto) throws IOException {

		String url = "http://localhost:8080/api/users";

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ArrayList<Authority> auth = new ArrayList<>();
		auth.add(new Authority(userCustomDto.getAuthority()));
		User user = new User(userCustomDto.getUsername(),passwordEncoder.encode(String.valueOf(rand_int)),true,auth);
		
		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		System.out.println("Inside put, before send");
		restTemplate.put(url, entity, User.class);
		return new RedirectView("/admin", true);
	}*/
	
}
