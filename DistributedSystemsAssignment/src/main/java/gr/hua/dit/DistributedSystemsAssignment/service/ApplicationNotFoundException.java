package gr.hua.dit.DistributedSystemsAssignment.service;

@SuppressWarnings("serial")
public class ApplicationNotFoundException extends RuntimeException{

	ApplicationNotFoundException(int id) {
	    super("Could not find application " + id);
	  }
	
}
