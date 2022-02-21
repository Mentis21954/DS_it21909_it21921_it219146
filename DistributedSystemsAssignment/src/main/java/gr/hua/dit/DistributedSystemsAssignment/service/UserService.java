package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	
	User save(User user);

	List<User> getUsers();
	
	public Optional<User> getUser(int id);
	public void deleteUser(int id);
}
