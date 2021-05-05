/**********************************************
Workshop 11
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: April 16, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop11;

/**
 * Class: Student
 * Objective: handles student
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Student implements AGSStudent{
	
	// fields values
	public String username;
	public String password;
	public String fullname;
	public String instructorEmail;
	
	/**
	 * Empty Constructor
	 */
	public Student() {
		super();
		this.username = "";
		this.password = "";
		this.fullname = "";
		this.instructorEmail = "";
	}
	
	/**
	 * Constructor
	 * @param username
	 * @param password
	 * @param fullname
	 * @param instructorEmail
	 */
	public Student(String username, String password, String fullname, String instructorEmail) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.instructorEmail = instructorEmail;
	}

	/**
	 * Method; getUsername
	 * Objective: get username
	 * @return String: username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Method: setUsername
	 * Objective: set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Method: getPassword
	 * Objective: get password
	 * @return String: password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method: setPassword
	 * Objective: set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method: getFullname
	 * Objective: get full name
	 * @return String: fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Method: setFullname
	 * Objective: set full name
	 * @param fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * Method: getInstructorEmail
	 * Objective: get instructor email
	 * @return String: instructorEmail
	 */
	public String getInstructorEmail() {
		return instructorEmail;
	}

	/**
	 * Method: setInstructorEmail
	 * Objective: set instructor email
	 * @param instructorEmail
	 */
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	
	/**
	 * Method: toString
	 * Objective: return a string of the object
	 * @return String: Object
	 */
	@Override
	public String toString() {
		return "Student = [" 
				+ AGSStudent.USERNAME + " = " + getUsername() + ", "
				+ AGSStudent.PASSWORD + " = " + getPassword() + ", "
				+ AGSStudent.FULLNAME + " = " + getFullname() + ", "
				+ AGSStudent.INSTRUCTOREMAIL + " = " + getInstructorEmail() + "]";
	}
}
