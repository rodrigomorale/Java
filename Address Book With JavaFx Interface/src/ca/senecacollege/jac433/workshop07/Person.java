/**********************************************
Workshop 5
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 02, 2021
**********************************************/

package ca.senecacollege.jac433.workshop07;

/**
 * Class: Person
 * Objective: Store and hold information about a person
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Person extends Address {

	// class attributes
	private String fName;
	private String lName;
	
	/**
	 * Constructor
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param fName
	 * @param lName
	 */
	public Person(String city, String province, String postalCode, String fName, String lName) {
		super(city, province, postalCode);
		
		// assign value using setter because validation
		setfName(fName);
		setlName(lName);
	}

	/**
	 * Method: getfName
	 * Objective: return the first name of a person
	 * @return String: fname
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * Method: setfName
	 * Objective: set the name of a person
	 * @param fName
	 */
	public void setfName(String fName) {
		
		// fill string with blanks until 50 characters
		if (fName.length() > 50) {
			this.fName = fName.substring(0, 50);
		} else {
			this.fName = fName;
		
		} while (this.fName.length() != 50) {
				this.fName += " ";
		}
	}

	/**
	 * Method: getlName
	 * Objective: return the person last name
	 * @return String: lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * Method: setlName
	 * Objective: assign a person last name
	 * @param lName
	 */
	public void setlName(String lName) {
		
		// fill string with blanks until 50 characters
		if (lName.length() > 50) {
			this.lName = lName.substring(0, 50);
		} else {
			this.lName = lName;
		
		} while (this.lName.length() != 50) {
				this.lName += " ";
		}
	}
}
