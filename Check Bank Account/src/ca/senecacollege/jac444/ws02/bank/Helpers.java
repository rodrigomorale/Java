/**********************************************
Workshop 2
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February, 7th 2021
**********************************************/

/**
 * Class: Helpers
 * Objective: This class has an objective to have general functions to help main classes. 
 * @author Rodrigo Canella Garcia Morale
 * This class contain some helpers functions
 */

package ca.senecacollege.jac444.ws02.bank;

import java.util.Scanner;

public class Helpers {
	
	static Scanner read = new Scanner(System.in);

	/**
	 * Method: redYesNo
	 * Objective: read Y or N values from the user
	 * @param message
	 * @return true / false
	 */
	public static boolean readYesNo(String message) {
		boolean yesNo = false;
		boolean validInput = false;
		String input = "";
		
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
	 * Method: readString
	 * Objective: This method read a string form the user and check if the user
	 *            did type a valid input.
	 * @param message
	 * @param validEntries: String[]
	 * @return String
	 */
	public static String readString(String message, String[] validEntries) {
		boolean validInput = false;
		String returnedText = "";
		String input = "";

		do {
			System.out.print(message);
			input = read.nextLine();
			returnedText = "";
			
			if (validEntries.length > 1 ) {
				String[] inputSplited = input.split(" ");
				for(int i = 0; i < validEntries.length; i++) {
					if (validEntries[i].contentEquals(inputSplited[0])) {
						returnedText = inputSplited[0];
						validInput = true;
					}
				}
				
			} else {
				returnedText = input;
				validInput = true;
			}
			
			if (returnedText == "") {
				System.out.println("| Invalid entry! Please, try again.");
				validInput = false;				
			}
			
		} while(!validInput);
		
		return returnedText;
	}
	
	/**
	 * Method: readValue
	 * Objective: This method read a double value from the user.
	 * @param message
	 * @param value
	 * @return
	 */
	public static double readValue(String message, double value) {
		double returnedValue = 0.0;
		boolean validInput = false;
		String input = "";
		
		do {
			System.out.print(message);
			input = read.nextLine();
		
			try {
				returnedValue = Double.parseDouble(input);
				validInput = true;
			} catch (Exception e) {
				System.out.println("| Invalid entry! Please, try again.");
				validInput = false;
			}
		} while (!validInput);
		
		return returnedValue;
	}
	
	/**
	 * Method: closeRead
	 * Objective: This method just close Scanner object
	 */
	public static void closeRead() {
		read.close();
	}
	
}
