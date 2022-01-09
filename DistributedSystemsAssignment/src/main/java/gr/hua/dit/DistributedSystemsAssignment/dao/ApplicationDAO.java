package gr.hua.dit.DistributedSystemsAssignment.dao;

import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

public interface ApplicationDAO {

	/**
	 * Query to get an unsubmitted application from the DB based on the citizen who made it
	 * @param applicantId the id of the citizen making the application
	 * @return an Application to be edited by a citizen user
	 */
	public Application getEditApplication(int applicantId);

	/**
	 * Query to get an unvalidated application from the DB based on the OAED employee who was assigned to review it
	 * @param validatorId the id of the OAED employee who was assigned this application for validation
	 * @return an submitted application for validation
	 */
	public Application getSubmittedApplication(int validatorId);

	/**
	 * Query to get an unauthorized application from the DB based on the OASA employee who was assigned to review it
	 * @param authorizerId the id of the OASA employee who was assigned this application for authorization
	 * @return a validated application for authorization
	 */
	public Application getValidatedApplication(int authorizerId);
	
}
