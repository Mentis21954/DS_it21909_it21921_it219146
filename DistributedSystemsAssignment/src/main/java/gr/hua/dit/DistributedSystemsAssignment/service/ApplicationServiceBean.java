package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.repository.ApplicationRepository;

@Service 
public class ApplicationServiceBean implements ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> getApplications() {
		List<Application> applications= applicationRepository.findAll();
		return applications;
	}

	@Override
	public void deleteApplication(int applicantId) {
		applicationRepository.deleteById(applicantId);
		
	}

	@Override
	public Application getEditApplication(int applicantId) {
		Application application= applicationRepository.getById(applicantId);
		return application;
	}

	@Override
	public Application getSubmittedApplication(int validatorId) {
		Application application=applicationRepository.getById(validatorId);
		return application;
	}

	@Override
	public Application getValidatedApplication(int authorizerId) {
		Application application=applicationRepository.getById(authorizerId);
		return application;
	}

	@Override
	public void saveApplication(Application app) {
		Application application=applicationRepository.save(app);
		
	}
}
