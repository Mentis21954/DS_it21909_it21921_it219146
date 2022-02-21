package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserEditDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;
import gr.hua.dit.DistributedSystemsAssignment.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User userData() {
		return new User();
	}
	
	@ModelAttribute("userEditDto")
	public UserEditDto userEditDto() {
		return new UserEditDto();
	}
	
	@GetMapping
	public String showUsers(Model model) {
		
		List<User>users=userService.getUsers();
		model.addAttribute("users", users);
		
		return "adminPage";
	}
	
	@GetMapping("/oneUser/{id}")
	public ModelAndView oneUser(@PathVariable (name="id") Integer id) {
		ModelAndView validation=new ModelAndView("oneUser");
		Optional<User> user = userService.getUser(id);
		validation.addObject("user",user);
		return validation;
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user,@ModelAttribute("userEditDto") UserEditDto userEditDto) {
		System.out.println("Before userOptional");
		System.out.println("user id is: " + user.getId());
		System.out.println("userEditDto id is: " + userEditDto.getId());
		System.out.println("userEditDto authority is: " + userEditDto.getAuthority());
		Optional<User> userOptional = userService.getUser(user.getId());
		System.out.println("Before if for null");
		if(userOptional != null) {
			User savedUser = userOptional.get();
			System.out.println("Before new list");
			List<Authority> auth = new ArrayList<Authority>();
			System.out.println("Before adding list");
			auth.add(new Authority(userEditDto.getAuthority()));
			savedUser.setAuthorities(auth);
			System.out.println("Before saving user");
			userService.save(savedUser);
		}
		
		return "redirect:/admin";
	}
}
