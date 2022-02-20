package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;
import gr.hua.dit.DistributedSystemsAssignment.repository.UnemployedRepository;

@Service
public class UnemployedsServiceImpl implements UnemployedsService {
	@Autowired
	private UnemployedRepository unemployedsRepository;

	@Override
	public List<Unemployed> getUnemployeds() {
		return unemployedsRepository.findAll();
	}

}
