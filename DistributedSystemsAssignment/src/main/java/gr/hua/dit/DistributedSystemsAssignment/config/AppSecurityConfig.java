package gr.hua.dit.DistributedSystemsAssignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import gr.hua.dit.DistributedSystemsAssignment.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	/*
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            
            auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
               .usersByUsernameQuery("select username,password, enabled from user where username=?")
               .authoritiesByUsernameQuery("select username, authority from authorities where username=?");

    }*/
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth= new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/signin**","/","/home/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.permitAll()
			.defaultSuccessUrl("/hello")//all the users can access the login page
			.and()
		.logout().invalidateHttpSession(true).clearAuthentication(true)
		.permitAll(); //after the user log out, he will get back to the login page 
	}
	
	@Override
	   public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/signup");
	   }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}