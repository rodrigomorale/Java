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
 * Class: Employee (abstract)
 * Objective: implement interface Payable
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

abstract class Employee implements Payable{
	
	// Attributes
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param socialSecurityNumber
	 */
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	// Getters / Setters
	
	/**
	 * Method: getFirstName
	 * Objective: return employee first name
	 * @return String: employee first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method: setFirstName
	 * Objective: set employee first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method: getLastName
	 * Objective: return employee last name
	 * @return String: employee last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method: setLastName
	 * Objective: set employee last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method: getSocialSecurityNumber
	 * Objective: return employee SIN
	 * @return String: employee SIN
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * Method: setSocialSecurityNumber
	 * Objective: set employee SIN 
	 * @param socialSecurityNumber
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return "Employee: " + getFirstName() + 
				       " " + getLastName() + 
				       "; SSN: " + getSocialSecurityNumber();
	}
}
