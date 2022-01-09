package gr.hua.dit.DistributedSystemsAssignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import gr.hua.dit.DistributedSystemsAssignment.service.ApplicationNotFoundException;

@ControllerAdvice
public class ApplicationNotFoundAdvice {

	  @ResponseBody
	  @ExceptionHandler(ApplicationNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String applicationNotFoundHandler(ApplicationNotFoundException ex) {
	    return ex.getMessage();
	  }
}