package gr.hua.dit.DistributedSystemsAssignment.service;

@SuppressWarnings("serial")
public class ApplicationNotFoundException extends RuntimeException{

	public ApplicationNotFoundException(int id) {
	    super("Could not find application " + id);
	}
	
	public ApplicationNotFoundException() {
	    super("Could not find any application");
	}
	
}
