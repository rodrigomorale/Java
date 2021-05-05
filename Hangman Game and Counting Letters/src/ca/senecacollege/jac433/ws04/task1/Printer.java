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

/**
 * Class: Printer
 * Objective: print informations in the screen
 * @author Rodrigo Canella GArcia Morale
 *
 */
public class Printer {

	/**
	 * Constructor
	 */
	public Printer() {};
	
	/**
	 * Method: header
	 * Objective: print program header at screen
	 */
	public void header() {
		System.out.println("/**********************************************");
		System.out.println("Workshop 4");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: February, 21 2021");
		System.out.println("**********************************************/");
		System.out.println("|**********************************************|");
		System.out.println("|=========| Hangman Game |=====================|");
		System.out.println("|----------------------------------------------|");
	}
	
	/**
	 * Method: greetings
	 * Objective: print program end at screen
	 */
	public void greetings() {
		System.out.println("|----------------------------------------------|");
		System.out.println("|=========| Thanks for play with us! |=========|");
		System.out.println("|----------------------------------------------|");
		System.out.println("|**********************************************|");
	}
	
	/**
	 * Method: continueToPlay
	 * Objective: check if the user want to start a new game
	 * @param reader
	 * @return boolean: true / false
	 */
	public boolean continueToPlay(Reader reader) {
		boolean cont = false;
		
		System.out.println("|----------------------------------------------|");
		cont = reader.readYesNo("| Nice Game! Do you would like to continue? (Y / N): ");
		
		System.out.println("|----------------------------------------------|");
		return cont;
	}
}
