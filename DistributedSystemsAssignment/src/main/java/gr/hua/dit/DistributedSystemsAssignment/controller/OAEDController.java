package gr.hua.dit.DistributedSystemsAssignment.controller;
import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;


@Controller
@RequestMapping("/oaedEmployee")
public class OAEDController {
	
	private RestTemplate restTemplate;

	public OAEDController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@ModelAttribute("application")
	public Application registrationApp() {
		return new Application();
	}

	@GetMapping
	public String showForm() {
		return "OAEDPage";
	}
	
	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping("/oaedEmployee")
	public String getApplications(Model model) {
		model.addAttribute("listApplications", applicationService.getApplications());
		return "OAEDPage";
	}
	
	
	

	

}
