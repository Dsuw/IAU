
package com.mycompany.bakerysystem;

import java.util.ArrayList;

public class Accounting {

	private double commissionRate=0.02;

	// Getter method for comissionRate 
	public double getCR(){ return commissionRate; }
	
	public double Bill(ArrayList<Product> basket, ArrayList<Double> prices){
    double bill = 0.0;
	
    for (int i = 0; i < prices.size(); i++) 
        bill = bill + (basket.get(i).priceAfterTax(prices.get(i)));
    
    return bill; 
    }
} // End super class Accounting

// Start of Sub class Salary
class Salary extends Accounting { 
	
	public double calculateSalary(){
	double baseSalary=2000;
	double housingAllowance=1000;
	return baseSalary+housingAllowance;
    } // End of method with no arg for comission 

    public double calculateSalary(int commission){
	double baseSalary=2000;
	double housingAllowance=1000;
	return (baseSalary+(commission*baseSalary* super.getCR())+housingAllowance);
    } //End of method with comission
} // End of class Salary