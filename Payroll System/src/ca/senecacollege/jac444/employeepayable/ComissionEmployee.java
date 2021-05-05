/**********************************************
Workshop 3
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February, 14 2021
**********************************************/

/**
 * Class: ComissionEmployee
 * Objective: Employee subclass
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class ComissionEmployee extends Employee{
	
	// Attributes
	private double grossSales;
	private double comissionRate;
	
	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param comissionRate
	 * @throws Exception
	 */
	public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double comissionRate) throws Exception {
		super(firstName, lastName, socialSecurityNumber);
		
		// Set attributes
		setGrossSales(grossSales);
		setComissionRate(comissionRate);		
	}

	
	// Getters / Setters
	
	/**
	 * Method: getGrossSales
	 * Objective: get gross sales value
	 * @return double: gross sales values
	 */
	public double getGrossSales() {
		return grossSales;
	}


	/**
	 * Method: setGrossSales
	 * Objective: set gross sales value
	 * @param grossSales
	 * @throws Exception
	 */
	public void setGrossSales(double grossSales) throws Exception {
		/*
		 * grossSales – gross sales of employee (should satisfy the condition <= 0.0, use exceptional handling)
		 */
		if (grossSales <= 0.0) {
			throw new Exception("Gross sales sould not be <= 0.0.");
		} else {
			this.grossSales = grossSales;			
		}
	}


	/**
	 * Method: getComissionRate
	 * Objective: return comission rate value
	 * @return double: comission rate value
	 */
	public double getComissionRate() {
		return comissionRate;
	}


	/**
	 * Method: setComissionRate
	 * Objective: set comission rate
	 * @param comissionRate
	 * @throws Exception
	 */
	public void setComissionRate(double comissionRate) throws Exception {
		/*
		 * commissionRate – commission rate of employee (rate should be between 0.0 to 1.0, use exceptional handling)
		 */
		if((comissionRate >= 0.0) && (comissionRate <= 1.0)) {			
			this.comissionRate = comissionRate;
		} else {
			throw new Exception("Comission Rate sould be between 0.0 to 1.0.");
		}
	}


	/**
	 * Method: getPaymentAmount
	 * Objective: return the amount the amount of payment of this kind of employee
	 * Parameters: none
	 * @return double: employee salary
	 */
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getGrossSales() * getComissionRate();
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return super.toString() + "; Comission {Gross Sales: $" + String.format("%.2f", getGrossSales()) + 
				                ", Comission Rate: " + getComissionRate() + "}";
	}
	
}
