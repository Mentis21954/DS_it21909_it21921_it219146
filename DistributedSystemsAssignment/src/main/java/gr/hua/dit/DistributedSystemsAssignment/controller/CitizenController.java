package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;

@Controller
@RequestMapping("/citizen")
public class CitizenController {

	private RestTemplate restTemplate;

	public CitizenController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@ModelAttribute("application")
	public Application registrationApp() {
		return new Application();
	}

	@GetMapping
	public String showForm() {
		return "unemployedUser";
	}

	@PostMapping("/save")
	public RedirectView saveApp(@ModelAttribute("application") Application application) throws IOException {

		String url = "http://localhost:8080/api/applications";

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set `accept` header
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<Application> entity = new HttpEntity<>(application, headers);

		System.out.println("Before return");
		System.out.println(application.getName() + " " + application.getEmail());
		restTemplate.postForObject(url, entity, Application.class);
		return new RedirectView("/citizen", true);

		/*
		 * this goes to method attributes @RequestParam("image") MultipartFile
		 * multipartFile String fileName =
		 * StringUtils.cleanPath(multipartFile.getOriginalFilename());
		 * application.setPhoto(fileName);
		 * 
		 * Application savedApp = applicationService.saveApplication(application);
		 * 
		 * String uploadDir = "user-photos/" + savedApp.getId();
		 * 
		 * FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		 * 
		 * 
		 * 
		 * return new RedirectView("/citizen", true);
		 */
	}

}
