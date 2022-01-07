package gr.hua.dit.DistributedSystemsAssignment.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

public class ApplicationDaoImp implements ApplicationDAO{
	
	   // create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
                    .buildSessionFactory();
    
    

	@Override
	public List<Application> getApplications() {
		// create session
        Session session = factory.getCurrentSession();

        try {
                // start a transaction
                //session.beginTransaction();
                // query applications
                List<Application> applications = session.createQuery("from application").getResultList();
                System.out.println("all applications");
                displayApplications(applications);
        } finally {
            factory.close();
        }
        return getApplications();
	}

	@Override
	public void deleteApplication(int applicantId) {
		// create session
        Session session = factory.getCurrentSession();

		// start a transaction
        session.beginTransaction();
        try {
		int applicationToDelete=applicantId;
		Application application=session.get(Application.class,applicationToDelete);
		session.delete(application);
		session.getTransaction().commit();
        }finally {
        	factory.close();
        }
	}

	@Override
	public Application getEditApplication(int applicantId) {
		// create session
        Session session = factory.getCurrentSession();
        int applicationToEdit=applicantId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToEdit);
		session.getTransaction().commit();
        }finally {
        	factory.close();
        }
		return getEditApplication(applicationToEdit);
	}

	@Override
	public Application getSubmittedApplication(int validatorId) {
		// create session
        Session session = factory.getCurrentSession();
        int applicationToSubmit=validatorId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToSubmit);
		session.getTransaction().commit();
        }finally {
        	factory.close();
        }
		return getSubmittedApplication(applicationToSubmit);
	}

	@Override
	public Application getValidatedApplication(int authorizerId) {
		// create session
        Session session = factory.getCurrentSession();
        int applicationToValidate=authorizerId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToValidate);
		session.getTransaction().commit();
        }finally {
        	factory.close();
        }
		return getValidatedApplication(applicationToValidate);
	}

	@Override
	public void saveApplication(Application app) {
		// TODO Auto-generated method stub
		// create session
        Session session = factory.getCurrentSession();

		// start a transaction
        session.beginTransaction();
        try {
		Application application=app;
		session.save(application);
		session.getTransaction().commit();
        }finally {
        	factory.close();
        }
		
	}
	
	private static void displayApplications(List<Application> applications) {
        // display applications
        for (Application application : applications) {
                System.out.println(application);
        }
}

}
