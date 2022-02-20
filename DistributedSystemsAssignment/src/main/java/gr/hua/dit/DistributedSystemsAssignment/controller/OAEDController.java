package gr.hua.dit.DistributedSystemsAssignment.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;


@Controller
@RequestMapping("/OAEDPage")
public class OAEDController {
	
	@Autowired
	private ApplicationService applicationService;

	@ModelAttribute("application")
	public Application registrationApp() {
		return new Application();
	}
	
	@GetMapping
	public String showApplications(Model model) {
		
		List<Application>applications=applicationService.getApplications();
		model.addAttribute("applications", applications);
		return "OAEDPage";
	}
	

}
