package gr.hua.dit.DistributedSystemsAssignment.service;

import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;

public interface UnemployedService {
	
	public List<Unemployed> getUnemployeds();
	
	public Unemployed getUnemployed(int id);
	
	public void saveUnemployed(Unemployed app);
	
	public void deleteUnemployed(int id);
	
	public void updateUnemployed(Unemployed app,int id);
	
}
