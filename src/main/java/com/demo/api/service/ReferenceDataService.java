package com.demo.api.service;

import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/refdata/v1.0")
@RestController
public class ReferenceDataService {
	
	private static Logger logger = Logger.getLogger(ReferenceDataService.class);
	
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	@RequestMapping(value = "/ping", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Void> pingReferenceDataService() {
		System.out.println(" Demo Ping Service ::: ");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	@RequestMapping("/")
	public String hello() {
		return "Demo Ref Services";
	}
	
	@RequestMapping(value = "medication/drugsearch/{drugName}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<String> drugSearch( @PathVariable("drugName") String drugName,
			@RequestParam("pagesize") Optional<String> pageSize,
			@RequestParam("stype") Optional<String> stype) throws Exception{
		try{
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream(drugName+".json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}catch(Exception ex){
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("drugnoresults.json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "medication/allergysearch/commonallergies", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<String> allergySearch() throws Exception{
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("allergies"+".json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "medication/allergysearch/{allergyname}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<String> allergySearch( @PathVariable("allergyname") String allergyname,
			@RequestParam("pagesize") Optional<String>  pageSize,
			@RequestParam("stype") Optional<String> stype) throws Exception{
		try{
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream(allergyname+".json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}catch(Exception ex){
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("allergies.json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	@RequestMapping(value = "medication/alerts", method = RequestMethod.POST,consumes = {"*/*"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> getAllAlerts(@RequestBody String alerts) throws Exception {
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("alerts.json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "icd/search/{searchterm}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<String> icdSearch( @PathVariable("searchterm") String searchterm,
			@RequestParam("data") Optional<String>  data,
			@RequestParam("maxresult") Optional<String> maxresult) throws Exception{
		try{
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream(searchterm+".json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}catch(Exception ex){
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("heart.json"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "icd/{icdcode}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<String> icd( @PathVariable("icdcode") String icdcode,
			@RequestParam("data") Optional<String>  data) throws Exception{
		try{
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream(icdcode+".xml"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}catch(Exception ex){
			String response = IOUtils.toString(ReferenceDataService.class.getResourceAsStream("icd.xml"));
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
	}

}