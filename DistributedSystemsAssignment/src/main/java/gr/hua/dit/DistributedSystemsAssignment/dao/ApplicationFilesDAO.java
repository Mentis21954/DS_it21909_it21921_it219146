package gr.hua.dit.DistributedSystemsAssignment.dao;

import java.util.List;

import gr.hua.dit.DistributedSystemsAssignment.entity.ApplicationFiles;

public interface ApplicationFilesDAO {
	
	/**
	 * Returns all the files of an application
	 * @param applicationId the id of the application
	 * @return an List of all application files 
	 */
	public List<ApplicationFiles> getAllFiles(int applicationId);

	/**
	 * Saves a file in the DB
	 * @param files the ApplicationFile to be saved
	 */
	public void saveApplicationFile(ApplicationFiles files);
	
	/**
	 * Get a specific file from the application
	 * @param applicationId the id of the application
	 * @param fileName the name of the application file
	 * @return an Application File
	 */
	public ApplicationFiles getFile(int applicationId,String fileName);
	
	/**
	 * Delete a file from the DB
	 * @param fileName the name of the file to be deleted
	 */
	public void deleteTeacher(String fileName);
	
}
