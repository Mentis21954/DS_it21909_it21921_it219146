package gr.hua.dit.DistributedSystemsAssignment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserCustomDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;
import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationService;
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
