package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import gr.hua.dit.DistributedSystemsAssignment.dto.UserRegistrationDto;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;
import gr.hua.dit.DistributedSystemsAssignment.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	/*
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	*/
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getUsername(),passwordEncoder().encode(registrationDto.getPassword()),true,Arrays.asList(new Authority("USER")));
		System.out.println("User data: Username: " + user.getUsername() +" " + "Pasword: "+ user.getPassword() + " " + "Enabled: " + user.isEnabled());
		return userRepository.save(user);
	}
	
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
    	return encoder;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getAuthorities()));

	}
	
	//method to map roles to authorities
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authority> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());	
	}
	
	@Override
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
}
