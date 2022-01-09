package gr.hua.dit.DistributedSystemsAssignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.service.UserService;

@Controller
@RequestMapping("/signin")
public class UserRegistrationController {
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public String showSigninForm() {   //this is for the frontend
		return "signinPage";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
		userService.save(registrationDto);
		return "redirect:/signin?success";
	}
}
