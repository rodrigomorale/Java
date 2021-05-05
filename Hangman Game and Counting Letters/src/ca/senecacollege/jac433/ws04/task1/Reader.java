/**********************************************
Workshop 4
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February 21, 2021
**********************************************/

package ca.senecacollege.jac433.ws04.task1;

import java.util.Scanner;

/**
 * Class: Reader
 * Objective: read information from the user
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Reader {

	// class attributes
	private Scanner read = new Scanner(System.in);

	// Constructor
	public Reader() {
		super();
	}

	/**
	 * Method: getRead
	 * Objective: get read
	 * @return Scanner: read
	 */
	public Scanner getRead() {
		return read;
	}
	
	/**
	 * Method: setRead
	 * Objective: set read value
	 * @param read
	 */
	public void setRead(Scanner read) {
		this.read = read;
	}
	
	/**
	 * Method: readChar
	 * Objective: read char information from the user
	 * @param message
	 * @return String: input
	 */
	public String readChar(String message) {
		
		// declare variables
		boolean validInput = false;
		String input = "";
		
		// loop until a valid input from the user
		do {
			System.out.print(message);
			input = read.nextLine();
			input = input.toUpperCase();
			
			// check if the user just entry one character
			if (input.length() > 1) {
				System.out.println("| Invalid entry! Please, entry just one letter.");				
				validInput = false;
			}
			else {
				validInput = true;
			}
			
		} while(!validInput);
		
		return input;
	}
	
	/**
	 * Method: redYesNo
	 * Objective: read Y or N values from the user
	 * @param message
	 * @return boolean: true / false
	 */
	public boolean readYesNo(String message) {
		
		// declare variables
		boolean yesNo = false;
		boolean validInput = false;
		String input = "";
		
		// loop until a valid input from the user
		do {
			System.out.print(message);
			input = read.nextLine();
			
			switch (input) {
			case "Y": 
			case "y":
				yesNo = true;
				validInput = true;
				break;
			case "N":
			case "n":
				yesNo = false;
				validInput = true;
				break;
			default:
				System.out.println("| Invalid entry! Please, try again.");
				validInput = false;
			}
			
		} while(!validInput);
				
		return yesNo;
	}
	
	/**
	 * Method: close
	 * Objective: close Scanner class
	 */
	public void close() {
		this.read.close();		
		
	}
}
