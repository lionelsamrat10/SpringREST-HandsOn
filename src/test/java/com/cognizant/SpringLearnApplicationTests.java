package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.controller.EmployeeController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	@Autowired
	private CountryController countryController;
	@Autowired
	private EmployeeController employeeController;
	@Autowired
	private MockMvc mvc;
	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}
//	@Test
//	public void testGetCountry() throws Exception {
//		ResultActions actions = mvc.perform(get("/countries/1"));
//		actions.andExpect(status().isOk());
//		actions.andExpect(jsonPath("$.code").exists());
//		actions.andExpect(jsonPath("$.code").value("IN"));
//	}
	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/az"));
		actions.andExpect(status().isNotFound());
		//actions.andExpect(status().reason("Country Not Found!!"));
	}
	@Test
	public void testGetEmployeeException() throws Exception{
		ResultActions actions = mvc.perform(get("/employees/in"));
		actions.andExpect(status().isBadRequest());
		ResultActions action = mvc.perform(get("/employees/8"));
		action.andExpect(status().isNotFound());
	}
}
