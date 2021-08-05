package com.example.restapi;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class employeeEndPointUnitTest {
	private MockMvc mockMvc;
	private String postEndpoint = "/postpayslip";
	private String str = "[{\"firstName\":\"David\",\"lastName\":\"Rudd\",\"annualSalary\":\"60050\",\"paymentMonth\":\"1\",\"superRate\":\"3\"},{\"firstName\":\"Ryan\",\"lastName\":\"Chen\",\"annualSalary\":\"120000\",\"paymentMonth\":\"1\",\"superRate\":\"5\"}]";
	@Test
	public void testResponse() throws Exception {			
		
	   
	    mockMvc.perform(post(postEndpoint).contentType(MediaType.APPLICATION_JSON)
	        .content(str))
	        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
        
	}
	
	
}
