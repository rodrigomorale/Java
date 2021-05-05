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
 * Class: HourlyEmployee
 * Objective: Employee subclass
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class HourlyEmployee extends Employee {

	// Attributes
	private double wage;
	private double hours;
	
	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 * @param wage
	 * @param hours
	 * @throws Exception
	 */
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) throws Exception {
		super(firstName, lastName, socialSecurityNumber);
		
		// Set attributes
		setWage(wage);
		setHours(hours);
	}

	// Getters / Setters
	
	/**
	 * Method: getWage
	 * Objective: return wage value
	 * @return double: wage value
	 */
	public double getWage() {
		return wage;
	}

	/**
	 * Method: setWage
	 * Objective: set wage value
	 * @param wage
	 * @throws Exception
	 */
	public void setWage(double wage) throws Exception {
		/*
		 * wage – hourly wage of employee (should satisfy the condition <= 0.0, use exceptional handling)
		 */
		if (wage <= 0.0) {
			throw new Exception("Wage sould not be <= 0.0.");
		} else {
			this.wage = wage;			
		}
	}

	/**
	 * Method: getHours
	 * Objective: return hours value
	 * @return double: hours value
	 */
	public double getHours() {
		return hours;
	}

	/**
	 * Method: setHours
	 * Objective: set hours value
	 * @param hours
	 * @throws Exception
	 */
	public void setHours(double hours) throws Exception {
		/*
		 * hours – number of hours worked by employee (hours should be between 0.0 to 168.0, use exceptional handling)
		 */
		if((hours >= 0.0) && (hours <= 168.0)) {			
			this.hours = hours;
		} else {
			throw new Exception("Number of hours sould be between 0.0 to 168.0.");
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
		/*
		 * Hourly employees are paid by the hour and receive overtime pay (i.e., 1.5 times their hourly salary rate) for 
		 * all hours worked in excess of 40 hours.
		 */
		double amount = 0.0;
		amount = ((getHours() - 40) * (getWage() * 1.5)) + (40 * getWage());		
		return amount;
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return super.toString() + "; Hourly {Wage: $" + String.format("%.2f", getWage()) + 
				            ", Hours: " + getHours() + "}"; 
	}
}
