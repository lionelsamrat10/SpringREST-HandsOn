package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.CountryService;
import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@Component
@RequestMapping("/countries") //Class level Mapping
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService countryService;
	
	//Returns the details of Country India 
	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country india = (Country) context.getBean("in");
		LOGGER.info("End");
		return india;
	}
	//Return the list of countries
	@GetMapping
	public List<Country> getAllCountries() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return countryService.getAllCountries();
	}

	@GetMapping(value = "{id}")
	public Country getCountryByCode(@PathVariable("id") String id) throws CountryNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		return countryService.findCountryById(id);
	}
//	@PostMapping()
//	public Country addCountry(@RequestBody Country country) {
//		LOGGER.info("inside add country");
//		// Create validator factory
//		return country;
//	}

	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Started the POST request");
		LOGGER.debug("Country details: " + country);
//		// Create validator factory
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		// Validation is done against the annotations defined in country bean
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//		// Accumulate all errors in an ArrayList of type String
//		for (ConstraintViolation<Country> violation : violations) {
//			errors.add(violation.getMessage());
//		}
//		// Throw exception so that the user of this web service receives appropriate
//		// error message
//		if (violations.size() > 0) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//		}
		LOGGER.info("End!!");
		return country;
	}
}
