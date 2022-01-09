package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;
import gr.hua.dit.DistributedSystemsAssignment.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public List<Application> getApplications() {
		return applicationRepository.findAll();
	}

	@Override
	public Application getApplication(int id) {
		return applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
	}

	@Override
	public void saveApplication(Application app) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteApplication(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateApplication(Application app, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Application> getNotValidatedApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getNotAuthorizedApplications() {
		// TODO Auto-generated method stub
		return null;
	}

}
