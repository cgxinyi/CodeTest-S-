package com.example.demo.model;

import java.math.BigDecimal;

public class Taxthreshold {
	private BigDecimal taxMinOfEachStages;
	private BigDecimal taxCentForOverDollar;
	private BigDecimal taxLumpBeforeCurrentStage;
	
	
	public Taxthreshold(BigDecimal taxMin , BigDecimal taxCent, BigDecimal taxLump) 
	{
		taxMinOfEachStages = taxMin;
		taxCentForOverDollar = taxCent;
		taxLumpBeforeCurrentStage = taxLump;
	}
	
	public void setTaxMin(BigDecimal taxMin)
	{
		this.taxMinOfEachStages=taxMin;
	}
	
	
	public void setTaxCent(BigDecimal taxCent)
	{
		this.taxCentForOverDollar = taxCent;
	}
	
	public void setTaxLump(BigDecimal taxLump)
	{
		this.taxLumpBeforeCurrentStage = taxLump;
	}
	
	public BigDecimal getTaxMin()
	{
		return taxMinOfEachStages;
	}
	
	
	public BigDecimal getTaxCent()
	{
		return taxCentForOverDollar;
	}
	
	public BigDecimal getTaxLump()
	{
		return taxLumpBeforeCurrentStage;
	}
	

}
