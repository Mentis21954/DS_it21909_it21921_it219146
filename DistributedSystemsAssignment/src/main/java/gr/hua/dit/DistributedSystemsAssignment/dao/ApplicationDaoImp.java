package gr.hua.dit.DistributedSystemsAssignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

@Repository
public class ApplicationDaoImp implements ApplicationDAO{
	
	   // create session factory
	
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Application.class)
                    .buildSessionFactory();
    
    
    
	@Override
	public List<Application> getApplications() {
		 // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Application> query = currentSession.createQuery("from application", Application.class);

        // execute the query and get the results list
        List<Application> apps = query.getResultList();

        // return the results
        return apps;
	}

	@Override
	public void deleteApplication(int applicantId) {
		// create session
        Session session = sessionFactory.getCurrentSession();

		// start a transaction
        session.beginTransaction();
        try {
		int applicationToDelete=applicantId;
		Application application=session.get(Application.class,applicationToDelete);
		session.delete(application);
		session.getTransaction().commit();
        }finally {
        	sessionFactory.close();
        }
	}

	@Override
	public Application getEditApplication(int applicantId) {
		// create session
        Session session = sessionFactory.getCurrentSession();
        int applicationToEdit=applicantId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToEdit);
		session.getTransaction().commit();
        }finally {
        	sessionFactory.close();
        }
		return getEditApplication(applicationToEdit);
	}

	@Override
	public Application getSubmittedApplication(int validatorId) {
		// create session
        Session session = sessionFactory.getCurrentSession();
        int applicationToSubmit=validatorId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToSubmit);
		session.getTransaction().commit();
        }finally {
        	sessionFactory.close();
        }
		return getSubmittedApplication(applicationToSubmit);
	}

	@Override
	public Application getValidatedApplication(int authorizerId) {
		// create session
        Session session = sessionFactory.getCurrentSession();
        int applicationToValidate=authorizerId;
		// start a transaction
        session.beginTransaction();
        try {
		Application application=session.get(Application.class,applicationToValidate);
		session.getTransaction().commit();
        }finally {
        	sessionFactory.close();
        }
		return getValidatedApplication(applicationToValidate);
	}

	@Override
	public void saveApplication(Application app) {
		// TODO Auto-generated method stub
		// create session
        Session session = sessionFactory.getCurrentSession();

		// start a transaction
        session.beginTransaction();
        try {
		Application application=app;
		session.save(application);
		session.getTransaction().commit();
        }finally {
        	sessionFactory.close();
        }
		
	}
	
	private static void displayApplications(List<Application> applications) {
        // display applications
        for (Application application : applications) {
                System.out.println(application);
        }
}

}
