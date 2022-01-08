package gr.hua.dit.DistributedSystemsAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationProgram {
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProgram.class, args);
		
		//app users that have logged in
		Unemployed unemployed=new Unemployed();
		EmployeeOAED oaedemp=new EmployeeOAED();
		EmployeeOASA oasaemp=new EmployeeOASA();
		Administrator admin=new Administrator();
		
		//we check what user logged in
		String tempUsername=null;  //change null with the one we take from user
		String tempPassword=null;  //change null with the one we take from user
		if(tempUsername.equals(unemployed.getEmail()) && tempPassword.equals(unemployed.getId())) { // getUsername and getPassword
			//gets the main page for the unemployed
			//make application
			//edit application
			//save application
			//submit application
			//upload files
			//logout
		}else if(tempUsername.equals(oaedemp.getEmail()) && tempPassword.equals(oaedemp.getId())) {
			//gets the main page for the oaed employee
			//get an application
			//check an application
			//approve it
			//logout
		}else if(tempUsername.equals(oasaemp.getEmail()) && tempPassword.equals(oasaemp.getId())) {
			//gets the main page for oasa employee
			//get an application
			//check the income and approve it
			//logout
		}else if(tempUsername.equals(admin.getEmail()) && tempPassword.equals(admin.getId())) {
			//gets the main page for admin
			//interact with employees and unemployeds
			//logout
		}
	
	}
}
