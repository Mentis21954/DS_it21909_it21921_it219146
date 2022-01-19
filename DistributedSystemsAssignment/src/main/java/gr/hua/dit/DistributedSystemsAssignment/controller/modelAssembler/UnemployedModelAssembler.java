package gr.hua.dit.DistributedSystemsAssignment.controller.modelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import gr.hua.dit.DistributedSystemsAssignment.controller.UnemployedController;
import gr.hua.dit.DistributedSystemsAssignment.entity.Unemployed;

@Component
public class UnemployedModelAssembler implements RepresentationModelAssembler<Unemployed, EntityModel<Unemployed>> {
	@Override
	public EntityModel<Unemployed> toModel(Unemployed unemployed) {

		return EntityModel.of(unemployed,
				linkTo(methodOn(UnemployedController.class).getUnemployed(unemployed.getId())).withSelfRel(),
				linkTo(methodOn(UnemployedController.class).getAllUnemployeds()).withRel("unemployed"));
	}
}
