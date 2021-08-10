package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Payslip;

public class PayslipServiceUnit {
	
	@InjectMocks
	private PayslipService payslipService;
	
	@BeforeEach
	public void init() {
		payslipService = new PayslipServiceImpl();
	}
	
	@Test
    public void testCalculateIncomeTax1() {
		int calc = payslipService.calculateIncomeTax(0);
        assertEquals(calc,0);
    }
	
	@Test
    public void testCalculateIncomeTax2() {
		int calc = payslipService.calculateIncomeTax(20000);
        assertEquals(calc,342);
    }
	
	@Test
    public void testCalculateIncomeTax3() {
		int calc = payslipService.calculateIncomeTax(40000);
        assertEquals(calc,4547);
    }
	
	@Test
    public void testCalculateIncomeTax4() {
		int calc = payslipService.calculateIncomeTax(90000);
        assertEquals(calc,20932);
    }
	
	@Test
    public void testCalculateIncomeTax5() {
		int calc = payslipService.calculateIncomeTax(200000);
        assertEquals(calc,63232);
    }

}
