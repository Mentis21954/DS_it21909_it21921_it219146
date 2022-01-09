package gr.hua.dit.DistributedSystemsAssignment.service;

@SuppressWarnings("serial")
public class UnemployedNotFoundException extends RuntimeException{
	
	UnemployedNotFoundException(int id) {
	    super("Could not find unemployed " + id);
	}
	
}
