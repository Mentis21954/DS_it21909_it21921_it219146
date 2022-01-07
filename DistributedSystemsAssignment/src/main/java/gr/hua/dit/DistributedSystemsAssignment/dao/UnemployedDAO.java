package gr.hua.dit.DistributedSystemsAssignment.dao;

import java.sql.Date;
import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;

public interface UnemployedDAO {

	/**
	 * Get all unemployed from the DB
	 * @return a list of all unemployed
	 */
	public List<Unemployed> getUnemployedAll();
	
	/**
	 * Checks if a citizen's data exists and matches an unemployed in the DB
	 * @param firstName the first name of the citizen
	 * @param lastName the last name of the citizen
	 * @param email the email of the citizen
	 * @param city the city of residence of the citizen
	 * @param AFM the AFM of the citizen
	 * @param AMKA the AMKA of the citizen
	 * @param daysOfUnemployment the days that the citizen has been unemployed
	 * @param birthday date of birth of the citizen
	 * @param idNumber the Id number of the citizen
	 * @return a boolean that indicates a match or not
	 */
	public boolean matchUnemployed(String firstName,String lastName,String email,String city,String AFM,String AMKA,int daysOfUnemployment,Date birthday,String idNumber);
}
