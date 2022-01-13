package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.ArrayList;
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
		applicationRepository.save(app);
	}

	@Override
	public void deleteApplication(int id) {
		applicationRepository.deleteById(id);
	}

	@Override
	public void updateApplication(Application app, int id) {
	}

	@Override
	public ArrayList<Application> getNotValidatedApplications() {
		List<Application> application=applicationRepository.findAll();
		ArrayList<Application> notValidated = new ArrayList<Application>();
		for(int i=0;i<application.size();i++) {
			if(application.get(i).isValidated()==false && application.get(i).isSubmitted()) {
				notValidated.add(application.get(i));
			}
		}
		if((notValidated).isEmpty()){
			throw new ApplicationNotFoundException();
		}
		return notValidated;
	}

	@Override
	public ArrayList<Application> getNotAuthorizedApplications() {
		List<Application> application=applicationRepository.findAll();
		ArrayList<Application> notAuthorized = new ArrayList<Application>();
		for(int i=0;i<application.size();i++) {
			if(application.get(i).isApproved()==false && application.get(i).isValidated()) {
				notAuthorized.add(application.get(i));
			}
		}
		if((notAuthorized).isEmpty()){
			throw new ApplicationNotFoundException();
		}
		return notAuthorized;
	}

}
