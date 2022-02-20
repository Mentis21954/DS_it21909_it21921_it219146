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

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.service.UnemployedsService;


@Controller
@RequestMapping("/UnemployedData")
public class UnemployedDataController {
	
	@Autowired
	private UnemployedsService unemployedsService;

	@ModelAttribute("unemployed")
	public Unemployed unemp() {
		return new Unemployed();
	}
	
	@GetMapping
	public String showApplications(Model model) {
		
		List<Unemployed>unemployeds=unemployedsService.getUnemployeds();
		model.addAttribute("unemployeds", unemployeds);
		
		return "UnemployedData";
	}
	

}
