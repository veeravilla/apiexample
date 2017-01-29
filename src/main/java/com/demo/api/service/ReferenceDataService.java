package com.demo.api.service;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/refdata/v1.0")
@RestController
public class ReferenceDataService {
	
	private static Logger logger = Logger.getLogger(ReferenceDataService.class);
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Void> pingReferenceDataService() {
		System.out.println(" Demo Ping Service ::: ");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Ping Services";
	}

}