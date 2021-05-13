package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.dao.EmployeeDao;

@SpringBootApplication
public class SpringLearnApplication {
	//Include LOGGER
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		// Create the Application Context for the date-format.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		// Get the dateFormat using getBean() method
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		LOGGER.info("START");
		Date date =  format.parse("10/05/2021");
		//System.out.println(date);
		LOGGER.debug("Formatted Date: " +  date);
		LOGGER.info("END");
		//Invoke displayCountry
		displayCountry();
		//Run the app on server
		SpringApplication.run(SpringLearnApplication.class, args);
	}
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		 Object countryList = context.getBean("countryList");
		 //Object countryList2 = context.getBean("countryList");
		 LOGGER.debug("Countries: " +  countryList);
		 //LOGGER.debug("Countries: " +  countryList2);
	}
}
