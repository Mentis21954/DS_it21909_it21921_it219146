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
		applicationRepository.save(app);
		
	}

	@Override
	public void deleteApplication(int id) {
		applicationRepository.deleteById(id);
		
	}

	@Override
	public void updateApplication(Application app, int id) {
		//
		
		
	}

	@Override
	public List<Application> getNotValidatedApplications() {
		List<Application> application=applicationRepository.findAll();
		List<Application> notValidated = null;
		for(int i=0;i<application.size();i++) {
			if(application.get(i).isValidated()==false) {
				notValidated.add(application.get(i));
			}
		}
		return notValidated;
	}

	@Override
	public List<Application> getNotAuthorizedApplications() {
		List<Application> application=applicationRepository.findAll();
		List<Application> notAuthorized = null;
		for(int i=0;i<application.size();i++) {
			if(application.get(i).isApproved()==false) {
				notAuthorized.add(application.get(i));
			}
		}
		return notAuthorized;
	}

}
