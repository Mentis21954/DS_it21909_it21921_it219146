package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

public interface ApplicationService {
	
	public List<Application> getApplications();
	
	public Application getApplication(int id);
	
	public void saveApplication(Application app);
	
	public void deleteApplication(int id);
	
	public void updateApplication(Application app,int id);
	
	public List<Application> getNotValidatedApplications();
	
	public List<Application> getNotAuthorizedApplications();
	
}
