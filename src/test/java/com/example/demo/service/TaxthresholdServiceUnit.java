package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) 
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TaxthresholdServiceUnit {
	
	private EmployeeService taxthresholdService;
	
	@BeforeEach
	public void init() {
		taxthresholdService = new EmployeeServiceImpl();
	}
	
	@Test
    public void testCalculateIncomeTax1() {
		BigDecimal calc = taxthresholdService.calculateIncomeTax(new BigDecimal(0));
        assertEquals(calc,BigDecimal.valueOf(0));
    }
	
	@Test
    public void testCalculateIncomeTax2() {
		BigDecimal calc = taxthresholdService.calculateIncomeTax(new BigDecimal(20000));
		BigDecimal test = new BigDecimal(342);
		assertTrue(calc.compareTo(test) == 0); 
    }
	
	@Test
    public void testCalculateIncomeTax3() {
		BigDecimal calc = taxthresholdService.calculateIncomeTax(new BigDecimal(40000));
		BigDecimal test = new BigDecimal(4547);
		assertTrue(calc.compareTo(test) == 0); 
    }
	
	@Test
    public void testCalculateIncomeTax4() {
		BigDecimal calc = taxthresholdService.calculateIncomeTax(new BigDecimal(90000));
		BigDecimal test = new BigDecimal(20932);
		assertTrue(calc.compareTo(test) == 0); 
    }
	
	@Test
    public void testCalculateIncomeTax5() {
		BigDecimal calc = taxthresholdService.calculateIncomeTax(new BigDecimal(200000));
		BigDecimal test = new BigDecimal(63232);
		assertTrue(calc.compareTo(test) == 0); 
    }

}
