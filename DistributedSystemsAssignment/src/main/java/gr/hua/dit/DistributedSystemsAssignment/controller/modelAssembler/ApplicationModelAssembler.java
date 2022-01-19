package gr.hua.dit.DistributedSystemsAssignment.controller.modelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import gr.hua.dit.DistributedSystemsAssignment.controller.ApplicationController;
import gr.hua.dit.DistributedSystemsAssignment.entity.Application;

@Component
public class ApplicationModelAssembler implements RepresentationModelAssembler<Application,EntityModel<Application>>{
	  @Override
	  public EntityModel<Application> toModel(Application application) {

	    return EntityModel.of(application,linkTo(methodOn(ApplicationController.class).getApplication(application.getId())).withSelfRel(),
	    		linkTo(methodOn(ApplicationController.class).getAllApplications()).withRel("applications"));
	  }
	  
	  public EntityModel<Application> toModelSubmitted(Application application) {

		    return EntityModel.of(application,linkTo(methodOn(ApplicationController.class).getApplication(application.getId())).withSelfRel(),
		    		linkTo(methodOn(ApplicationController.class).getAllUnvalidatedApplications()).withRel("submitted_applications"));
	  }
	  
	  public EntityModel<Application> toModelValidated(Application application) {

		    return EntityModel.of(application,linkTo(methodOn(ApplicationController.class).getApplication(application.getId())).withSelfRel(),
		    		linkTo(methodOn(ApplicationController.class).getAllUnauthorizedApplications()).withRel("validated_applications"));
	  }
}


