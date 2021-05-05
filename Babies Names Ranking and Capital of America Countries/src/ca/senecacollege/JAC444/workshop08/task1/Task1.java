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

package ca.senecacollege.JAC444.workshop08.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class: Task1
 * Objective: execute the main class of task1 program
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Task1 {
	
	// class attributes
	 
	// attributes to read user input
	public static String input;
	private static Scanner read = new Scanner(System.in);

	// attributes to handle file
	public static List<String> validFileNameList = new ArrayList<>();
	public static ReadFile fileInput;
	
	// other attributes
	public static String fileName = null;
	private static int option = 0;

	/**
	 * Method: main
	 * Objective: execute Task1 program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// fill list of valid file names
		validFileNameList.add("babynamesranking2009.txt");
		validFileNameList.add("babynamesranking2010.txt");
		validFileNameList.add("babynamesranking2011.txt");
		validFileNameList.add("babynamesranking2012.txt");
		validFileNameList.add("babynamesranking2013.txt");
		validFileNameList.add("babynamesranking2014.txt");
		validFileNameList.add("babynamesranking2015.txt");
		validFileNameList.add("babynamesranking2016.txt");
		validFileNameList.add("babynamesranking2017.txt");
		validFileNameList.add("babynamesranking2018.txt");

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
		System.out.println("|         Task 1 - Babies Names               |");
		System.out.println("|=============================================|");
		
		// Execute loop while program do not end
				do {
					// set the file name to work
					option = menu();
					
					// List all countries
					if (option == 1) { setFileName(); }
					
					// List babies names
					if (option == 2) { listBabiesNames(); }
					
					// sort babies names
					if (option == 3) { sortBabiesNames(); }
					
				} while (option != 4);
				
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
		boolean validOption = false;
		
		do {
		System.out.println("|                                             |");
		System.out.println("|---------------------------------------------|");
		System.out.println("| Select option:                              |");
		System.out.println("|    1: Set babies names file name            |");
		
		// it is required to have the file name before select options 2 and 3
		if (fileName != null) {
			System.out.println("|    2: List babies names of the raking year  |");
			System.out.println("|    3: Sort babies names of the raking year  |");
			System.out.println("|         by gender                           |");
		}
		
		System.out.println("|    4: Exit Program                          |");
		System.out.println("|---------------------------------------------|");
		System.out.print  ("| Enter a option: ");
		                  
		
		input = read.nextLine();
		
		if (fileName != null) { validOption = Pattern.matches("^[1-4]{1}$", input); }
		else { validOption = Pattern.matches("^[1,4]{1}$", input); }
		
		if (validOption) {
			option = Integer.parseInt(input);
		} 
		else { 
			option = 0; 
			System.out.println("|");
			System.out.println("| Please, enter a valid option...             |");
		}
		
		} while (option == 0);
		
		return option;
	}
	
	/**
	 * Method: setFileName
	 * Objective: this method set the a valid file name and retrieve informations to the list
	 */
	public static void setFileName() {
		String name = null;
		
		do {
			System.out.println("|");
			System.out.print("| Please, enter a valid file name: ");
				
			input = read.nextLine();
			
			if (validFileNameList.contains(input)) {
				name = input;
			}
			
			if (name != null) {
				System.out.println("| File name " + name + " setted with success!");
				fileName = name;
				
				// read file and create lists
				try {
					fileInput = new ReadFile(fileName);
				} catch (Exception e) {
					name = null;
				}
				
			} 
			
			if (name == null) {
				System.out.println("| Please, entry a valid filename. See a list of valid file names below:");
				System.out.println("|");
				
				validFileNameList.forEach((f)->{
					System.out.println("| " + f);					
				});
			}
		} while (name == null);
	}
	
	/**
	 * Method: listBabiesNames
	 * Objective: this method prints informations about the list of babies names from the filename
	 */
	public static void listBabiesNames() {
		
		System.out.println("|                                             |");
		System.out.println("|---------------------------------------------|");
		System.out.println("| The total of names for boys is " + fileInput.getBoysList().size());
		System.out.println("| The total of names for girls is " + fileInput.getGirlsList().size());
		System.out.println("| Boys names: " + fileInput.getBoysList());
		System.out.println("| Girls names: " + fileInput.getGirlsList());
		
	}
	
	/**
	 * Method: sortBabiesNames
	 * Objective: this method prints a sorted list of babies names from the filename
	 */
	public static void sortBabiesNames() {
		
		System.out.println("|                                             |");
		System.out.println("|---------------------------------------------|");
		System.out.println("|         ##### SORTED NAMES ####             |");
		System.out.println("|---------------------------------------------|");
		System.out.println("| Boys names: " + fileInput.getBoysSorted());
		System.out.println("| Girls names: " + fileInput.getGirlsSorted());
	}

}
