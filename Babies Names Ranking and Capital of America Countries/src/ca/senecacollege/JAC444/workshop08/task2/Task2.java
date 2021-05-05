/**********************************************
Workshop 8
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 27, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop08.task2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class: Task2
 * Objective: Execute the main function of task2 program
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Task2 {
	
	public static WorldMap americasCountries = new WorldMap();
	 
	// other global attributes
	public static String input;
	private static Scanner read = new Scanner(System.in);
	private static int option = 0;

	/**
	 * Method: main
	 * Objective: execute Task2 program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 8");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: March 218, 2021");
		System.out.println("**********************************************/");
		System.out.println("|=============================================|");
		System.out.println("|         Task 2 - Countries Capital          |");
		System.out.println("| #### Capitals of countries of Americas #### |");
		System.out.println("|=============================================|");
		
		// Execute loop while program do not end
		do {
			// print menu options
			option = menu();
			
			// List all countries
			if (option == 1) { printCountriesList(); }
			
			// shows country's capital
			if (option ==2) { getCountryCapital(); }
			
		} while (option != 3);
		
		// print final message
		System.out.println("|=============================================|");
		System.out.println("|         Program - Finished                  |");
		System.out.println("|=============================================|");
	}
	
	/**
	 * Method: menu
	 * Objective: handles with menu options
	 * @return int: option
	 */
	public static int menu() {
		int option = 0;
		
		do {
		System.out.println("|                                             |");
		System.out.println("|---------------------------------------------|");
		System.out.println("| Select option:                              |");
		System.out.println("|    1: List all countries of americas        |"); 
		System.out.println("|    2: Get country's capital name            |");
		System.out.println("|    3: Exit Program                          |");
		System.out.println("|---------------------------------------------|");
		System.out.print  ("| Enter a option: ");
		                  
		
		input = read.nextLine();
		if (Pattern.matches("^[1-3]{1}$", input)) {
			option = Integer.parseInt(input);
		} 
		else { 
			option = 0; 
			System.out.println("|");
			System.out.println("| Please, enter a valid option... (1 , 2, 3)  |");;
		}
		
		} while (option == 0);
		
		return option;
	}
	
	/**
	 * Method: printCountriesList
	 * Objective: print a list with America countries
	 */
	public static void printCountriesList() {
		// Print list of all countries
		System.out.println("|");
		System.out.println("| List of americas contries names:            ");
		System.out.println("");
		System.out.print(" ");
		americasCountries.listOfCountries().forEach((country)->{
			System.out.print(country + " * ");
			int index = americasCountries.countryListIndex(country);
			if (((index + 1) % 5 == 0) && (index > 0)) {
					System.out.print(" \n ");
			}
		});
		
		System.out.println("");
	}
	
	/**
	 * Method: getCountryCapital
	 * Objective: retrieve the name of the country and return its capital
	 */
	public static void getCountryCapital () {
		// Print capital of the country
		String capital = null;
		
		do {
			System.out.println("|");
			System.out.print("| Enter a valid country name: ");
				
			input = read.nextLine();
			
			capital = americasCountries.getCountryCapital(input);
				
			if (capital != null) {
				System.out.println("| The capital of " + input.toUpperCase() + " is " + capital);
			} else {
				System.out.println("| Country " + input + " is not a country from americas!");
				System.out.println("| Please enter a country from americas...");
			}
		} while (capital == null);
	}

}
