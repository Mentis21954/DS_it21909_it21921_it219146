package gr.hua.dit.DistributedSystemsAssignment.controller.repositoryImp;

public class UnemployedNotFoundException extends RuntimeException{
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4814914115365691127L;

	public UnemployedNotFoundException(String exception) {
		super(exception);
	}
}
