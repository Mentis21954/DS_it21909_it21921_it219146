package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.repository.UnemployedRepository;

@Service
public class UnemployedServiceImpl implements UnemployedService{
	
	@Autowired
	private UnemployedRepository unemployedRepository;
	
	@Override
	public List<Unemployed> getUnemployeds() {
		return unemployedRepository.findAll();
	}

	@Override
	public Unemployed getUnemployed(int id) {
		return unemployedRepository.findById(id).orElseThrow(() -> new UnemployedNotFoundException(id));
	}

	@Override
	public void saveUnemployed(Unemployed app) {
		unemployedRepository.save(app);
		
	}

	@Override
	public void deleteUnemployed(int id) {
		unemployedRepository.deleteById(id);
		
	}

	@Override
	public void updateUnemployed(Unemployed app, int id) {
		/*
		List<Unemployed> unemployed=unemployedRepository.findAll();
		for(int i=0;i<unemployed.size();i++) {
			Unemployed tempUn=unemployed.get(i);
			if(unemployed.get(i).getId()==unemployedRepository.findById(id)) {
				
			}
		}
		*/
	}

}
