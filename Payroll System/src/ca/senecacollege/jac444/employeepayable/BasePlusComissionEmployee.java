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
 * Class: BasePlusComissionEmployee
 * Objective: ComissionEmployee subclass for Employee
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class BasePlusComissionEmployee extends ComissionEmployee {

	// Attribute
	private double baseSalary;

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param grossSales
	 * @param comissionRate
	 * @param baseSalary
	 * @throws Exception
	 */
	public BasePlusComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double comissionRate, double baseSalary) throws Exception {
		super(firstName, lastName, socialSecurityNumber, grossSales, comissionRate);
		
		// Set attribute
		setBaseSalary(baseSalary);
	}

	// Getter / Setter
	
	/**
	 * Method: getBaseSalary
	 * Objective: return base salary value
	 * @return double: base salary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * Method: SetBaseSalary
	 * Objective: set base salary value
	 * @param baseSalary
	 * @throws Exception
	 */
	public void setBaseSalary(double baseSalary) throws Exception {
		/*
		 * baseSalary – base salary of employee (should satisfy the condition <= 0.0, use exceptional handling)
		 */
		if (baseSalary <= 0.0) {
			throw new Exception("Base salary sould not be <= 0.0.");
		} else {
			this.baseSalary = baseSalary;			
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
		return super.getPaymentAmount() * 1.1;
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return super.toString() + "; Base Plus Comission {Base Salary: $" + String.format("%.2f", getBaseSalary()) + "}";
	}
}
