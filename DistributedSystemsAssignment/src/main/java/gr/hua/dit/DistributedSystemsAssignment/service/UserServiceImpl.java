package gr.hua.dit.DistributedSystemsAssignment.service;

import org.springframework.stereotype.Service;

import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;
import gr.hua.dit.DistributedSystemsAssignment.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getFname(),registrationDto.getLname(),registrationDto.getEmail(),registrationDto.getPassword());
		return userRepository.save(user);
	}

}
