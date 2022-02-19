package gr.hua.dit.DistributedSystemsAssignment.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.controller.modelAssembler.ApplicationModelAssembler;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.repository.ApplicationRepository;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;


@Controller
@RequestMapping("/OAEDPage")
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
	
	@Autowired
	private ApplicationModelAssembler assembler;
	@GetMapping("/OAEDPage")
	public String getAllApplications(Model model) {
		List<EntityModel<Application>> applications = applicationService.getApplications().stream().map(assembler::toModel).collect(Collectors.toList());
		model.addAttribute("applications",applications);
		return "applications";
	}
	
	/*
	@GetMapping("/OAEDPage")
	public String showApplications(Model model) {
		List<Application>applications=applicationService.getApplications();
		model.addAttribute("applications", applications);
		return "OAEDPage";
	}
	*/
	/*
	private ApplicationRepository appR;
	@GetMapping("/OAEDPage")
	public ModelAndView getAllApplications() {
		ModelAndView mav = new ModelAndView("OAEDPage");
		mav.addObject("listApplications", appR.findAll());
		return mav;
	}
	*/

}
