package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);

	List<User> getUsers();
}
