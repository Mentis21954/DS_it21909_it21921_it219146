package gr.hua.dit.DistributedSystemsAssignment.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;
import gr.hua.dit.DistributedSystemsAssignment.service.UnemployedsService;


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
	
	@GetMapping("/validationForm/{id}")
	public ModelAndView validationForm(@PathVariable (name="id") Integer id) {
		ModelAndView validation=new ModelAndView("validationForm");
		Application application = applicationService.getApplication(id);
		validation.addObject("application",application);
		return validation;
	}
	
	@PostMapping("/saveAuthorization")
	public String saveValidation(@ModelAttribute("application") Application application) {
		Application app = applicationService.getApplication(application.getId());
		app.setValidated(true);
		applicationService.saveApplication(app);
		return "redirect:/OAEDPage";
	}
	

}
