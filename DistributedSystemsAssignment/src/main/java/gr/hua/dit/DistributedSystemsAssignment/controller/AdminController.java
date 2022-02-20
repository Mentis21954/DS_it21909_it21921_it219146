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
import org.springframework.web.servlet.ModelAndView;

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
	public String saveUser(@ModelAttribute("user") User user) {
		Optional<User> u = userService.getUser(user.getId());
		
		userService.save(u);
		return "redirect:/OAEDPage";
	}
}
