package com.example.demo;

import java.util.ArrayList;

public class ListOfTaxthreshold {
	private ArrayList<taxthreshold> taxthresholds;
	
	public ListOfTaxthreshold()
	{
		taxthresholds=new ArrayList<taxthreshold>();
	}
	
	public ListOfTaxthreshold(ArrayList<taxthreshold> newTaxthreshold) 
	{
		taxthresholds=newTaxthreshold;
	}
	
	public void setTaxthreshold(ArrayList<taxthreshold> newTaxthreshold)
	{
		taxthresholds = newTaxthreshold;
	}
	
	public ArrayList<taxthreshold> getListOfTaxthreshold()
	{
		return taxthresholds;
	}
	
	public void addTaxthreshold(int taxMax , double taxCent, int taxLump)
	{
		taxthreshold newTaxthreshold = new taxthreshold(taxMax, taxCent, taxLump);
		taxthresholds.add(newTaxthreshold);
	}
	
	public int getNumberOfTaxthreshold()
	{
		return taxthresholds.size();
	}
	
	public taxthreshold getTaxthreshold(int index)
    {
        return taxthresholds.get(index);
    }
}
