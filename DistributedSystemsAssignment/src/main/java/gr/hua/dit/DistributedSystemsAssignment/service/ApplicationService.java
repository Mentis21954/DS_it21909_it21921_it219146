package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

public interface ApplicationService {
	public List<Application> getApplications();
	
	public void deleteApplication(int applicantId);
	
	public Application getEditApplication(int applicantId);
	
	public Application getSubmittedApplication(int validatorId);

	public Application getValidatedApplication(int authorizerId);
	
	public void saveApplication(Application app);
	
}
