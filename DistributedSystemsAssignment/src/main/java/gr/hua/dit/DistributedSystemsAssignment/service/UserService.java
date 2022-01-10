package gr.hua.dit.DistributedSystemsAssignment.service;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
	
}
