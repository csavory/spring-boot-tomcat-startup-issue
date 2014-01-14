/**
 * 
 */
package com.csavory.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author csavory
 *
 */
@Controller
@RequestMapping("/strings")
public class StringController {


	
    @RequestMapping(method = RequestMethod.GET)
    HttpEntity<List<String>> showMatches() {
    	
    	List strings = new ArrayList<String>();
    	
		return new ResponseEntity<List<String>>(strings, HttpStatus.OK);
    }
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	HttpEntity<Resource<String>> showString(@PathVariable Long id) {

		Resource<String> resource = new Resource<String>("Hello");
		resource.add(linkTo(methodOn(StringController.class).showString(id)).withSelfRel());

		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
 
	
}
