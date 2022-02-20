package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
