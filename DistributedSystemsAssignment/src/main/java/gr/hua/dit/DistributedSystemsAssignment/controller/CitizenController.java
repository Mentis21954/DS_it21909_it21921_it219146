package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

import gr.hua.dit.DistributedSystemsAssignment.FileUploadUtil;
import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;

@Controller
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private ApplicationService applicationService;
	
	@ModelAttribute("application")
	public Application registrationApp() {
		return new Application();
	}

	@GetMapping
	public String showForm() {
		return "unemployedUser";
	}

	@PostMapping("/save")
	public RedirectView saveApp(@ModelAttribute("application") Application application, @RequestParam("image") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        application.setPhoto(fileName);
        application.setSubmitted(true);
		
        Application savedApp = applicationService.saveApplication(application);
        
		String uploadDir = "user-photos/" + savedApp.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        
		return new RedirectView("/citizen", true);

	}

}
