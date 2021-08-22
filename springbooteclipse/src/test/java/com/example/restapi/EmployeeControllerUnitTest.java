package com.example.restapi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.DemoApplication;
import com.example.demo.model.Employee;
import com.example.demo.model.Payslip;
import com.example.demo.repository.EmployeeDataAccessServiceRepository;
import com.example.demo.restcontroller.EmployeeController;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeControllerUnitTest {
	private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();;
	private String postEndPoint = "/postpayslip";
	private String str = "{\"firstName\":\"David\",\"lastName\":\"Rudd\",\"annualSalary\":\"60050\",\"paymentMonth\":\"1\",\"superRate\":\"3\"}";
			 //{\"firstName\":\"Ryan\",\"lastName\":\"Chen\",\"annualSalary\":\"120000\",\"paymentMonth\":\"1\",\"superRate\":\"5\"}]";
	ObjectMapper mapper = new ObjectMapper();

	@MockBean
	private Payslip payslip;
	

	@MockBean
	private EmployeeDataAccessServiceRepository empData;
	private Employee employee = new Employee("David","Rudd",BigDecimal.valueOf(60050),1,3,null);
	
	
	
	/*@Test
	 * public void testResponse() throws Exception {		
		List<Employee> empD = new ArrayList<Employee>();
		empD.add(employee);
		
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(empD);
	    mockMvc.perform(post(postEndPoint).contentType(MediaType.APPLICATION_JSON)
		        .content(requestJson))
	        .andExpect(status().isOk())
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        
	}*/
	
	
}