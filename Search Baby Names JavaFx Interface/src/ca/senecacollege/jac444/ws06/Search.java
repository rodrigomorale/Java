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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search extends Child {
	
	// class attributes
	private String fileName;
	private String rank;
	private Scanner input;
	
	/**
	 * Constructor
	 * @param name
	 * @param year
	 * @param gender
	 * @throws FileNotFoundException 
	 */
	public Search(String name, int year, boolean gender) throws FileNotFoundException {
		super(name, year, gender);
		// TODO Auto-generated constructor stub
		
		// set file name
		this.fileName = "babynamesranking" + year + ".txt";
		
		// set random file
		this.input = new Scanner(new File(getFileName()));
		
		// set rank
		setRank();
	}

	/**
	 * Method: getFileName
	 * Objective: return search file name
	 * @return String: fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Method: setFileName
	 * Objective: set file name
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Method: getRank
	 * Objective: return search rank value
	 * @return String: rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Method: setRank
	 * Objective: set rank value
	 */
	public void setRank() {
		// this function search in the file to find rank
		this.rank = "";
		String line;
		
		while(input.hasNext() && (this.rank == "")) {
			// set line value
			line = input.nextLine();
			int index = 1; // index for boy
			
			// split line values in an array
			String[] lineItems = line.split("\t"); 
			
			// check if it is a boy or girl
			if (!isGender()) {
				index = 3; // index for girl
			}
			// check if name match with line boy or girl name
			if (lineItems[index].toUpperCase().contains(getName().toUpperCase())) {
				this.rank = lineItems[0];
			}
		}
		
	}
	
	
	
	

}
