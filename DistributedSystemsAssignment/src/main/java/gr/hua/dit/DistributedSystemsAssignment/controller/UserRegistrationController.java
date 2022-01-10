package gr.hua.dit.DistributedSystemsAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authorities;
import gr.hua.dit.DistributedSystemsAssignment.repository.AuthoritiesRepository;
import gr.hua.dit.DistributedSystemsAssignment.service.UserService;

@Controller
@RequestMapping("/signup")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showSignupForm() {   
		return "signup";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
		System.out.println("Controller here! username is " + registrationDto.getUsername() + " " + "password is " + registrationDto.getPassword());
		userService.save(registrationDto);
		Authorities authority = new Authorities(registrationDto.getUsername(),"ROLE_USER");
		authoritiesRepository.save(authority);
		return "redirect:/signup?success";
	}
}
