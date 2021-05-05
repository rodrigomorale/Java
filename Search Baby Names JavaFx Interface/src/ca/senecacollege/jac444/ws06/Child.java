/**********************************************
Workshop 6
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 15, 2021
**********************************************/

package ca.senecacollege.jac444.ws06;

public class Child {
	
	// class attributes
	private String name;
	private int year;
	private boolean gender; // true for male and false for female
	
	/**
	 * Constructor
	 * @param name
	 * @param year
	 * @param gender
	 */
	public Child(String name, int year, boolean gender) {
		super();
		this.name = name;
		this.year = year;
		this.gender = gender;
	}

	/**
	 * Method: getName
	 * Objective: return child name
	 * @return String: name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method: setName
	 * Objective: set child name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method: getYear
	 * Objective: return search year for child
	 * @return int: year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method: setYear
	 * Objective: set child year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Method: isGender
	 * Objective: return true if gender is boy and false if gender is girl
	 * @return boolean: true / false
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * Method: setGender
	 * Objective: set gender value. True for boy and false for girl
	 * @param gender
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}
