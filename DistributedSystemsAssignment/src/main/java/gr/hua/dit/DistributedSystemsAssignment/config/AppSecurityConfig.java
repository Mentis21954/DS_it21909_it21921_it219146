package gr.hua.dit.DistributedSystemsAssignment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            
            auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
               .usersByUsernameQuery("select username,password, enabled from user where username=?")
               .authoritiesByUsernameQuery("select username, authority from authorities where username=?");

    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 http
	 .authorizeRequests() // authorize
	 	.antMatchers("/", "/home").permitAll() // allow "/" to be seen without authentication
	 	.anyRequest().authenticated() // all requests are authenticated
	 	.and()
	 .formLogin()
	 	.loginPage("/login")
	 	.permitAll() //allow "/login"
	 	.defaultSuccessUrl("/home", true) // set default page for success login
	 	.and()
	 .logout()
	 	.permitAll(); // allow "logout"
	}
	
	@Override
	   public void configure(WebSecurity web) throws Exception {
	           //web.ignoring().antMatchers("/resources/**");
	           

	   }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
    	return encoder;
    }
}