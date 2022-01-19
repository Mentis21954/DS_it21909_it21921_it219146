package gr.hua.dit.DistributedSystemsAssignment.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import gr.hua.dit.DistributedSystemsAssignment.service.UnemployedNotFoundException;

@ControllerAdvice
public class UnemployedNotFoundAdvice {

	  @ResponseBody
	  @ExceptionHandler(UnemployedNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String applicationNotFoundHandler(UnemployedNotFoundException ex) {
	    return ex.getMessage();
	  }
}
