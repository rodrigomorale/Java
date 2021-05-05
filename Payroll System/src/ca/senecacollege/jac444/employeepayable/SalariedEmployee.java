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
 * Class: SalariedEmployee
 * Objective: Employee subclass
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class SalariedEmployee extends Employee {

	// Attribute
	private double weeklySalary;

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param weeklySalary
	 * @throws Exception
	 */
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) throws Exception {
		super(firstName, lastName, socialSecurityNumber);
		
		// Set attribute
		setWeeklySalary(weeklySalary);
	}

	// Getter / Setter
	
	/**
	 * Method: getWeeklySalary
	 * Objective: return weekly salary value
	 * @return double: weekly salary value
	 */
	public double getWeeklySalary() {
		return weeklySalary;
	}

	/**
	 * Method: setWeeklySalary
	 * Objective: set weekly salary value
	 * @param weeklySalary
	 * @throws Exception
	 */
	public void setWeeklySalary(double weeklySalary) throws Exception {
		/*
		 * weeklysalary – hourly wage of employee (should satisfy the condition <= 0.0, use exceptional handling)
		 */
		if (weeklySalary <= 0.0) {
			throw new Exception("Weekly salary sould not be <= 0.0.");
		} else {
			this.weeklySalary = weeklySalary;			
		}
	}

	/**
	 * Method: getPaymentAmount
	 * Objective: return the amount the amount of payment of this kind of employee
	 * Parameters: none
	 * Return: double: employee salary
	 */
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getWeeklySalary();
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return super.toString() + "; Salaried {Weekly Salary: $" + String.format("%.2f", getWeeklySalary()) + "}"; 
	}
}
