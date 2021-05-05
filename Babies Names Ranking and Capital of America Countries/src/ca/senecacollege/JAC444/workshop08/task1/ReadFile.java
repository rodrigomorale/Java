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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class: ReadFile
 * Objective: handle read file
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class ReadFile {

	// class attributes
	private String fileName;
	private Scanner input;
	
	// regular name lists
	private List<String> boysList = new ArrayList<>();
	private List<String> girlsList = new ArrayList<>();
	
	// sorted name lists
	private Set<String> boysSorted = new TreeSet<>();
	private Set<String> girlsSorted = new TreeSet<>();
	
	// constants
	final private int boy = 1;  // index position for boy
	final private int girl = 3; // index position for girl
	
	/**
	 * Constructor
	 * @param name
	 * @throws FileNotFoundException
	 */
	public ReadFile(String name) throws FileNotFoundException {
		
		// set file name
		this.fileName = name;
		
		// set random file
		this.input = new Scanner(new File(getFileName()));
		
		// set name lists for boys and girls
		setNameLists();
		
		// set sorted lists
		setSortedNameLists();
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
	 * Method: setNameLists
	 * Objective: read information from the file and set
	 *            boys and girls names to the lists
	 */
	private void setNameLists() {
		// set ArrayLists
		String line;
						
		while(input.hasNext()) {
			// set line value
			line = input.nextLine();
				
			// split line values in an array
			String[] lineItems = line.split("\t"); 

			// read boys name
			boysList.add(lineItems[boy]);
			
			// read girls name
			girlsList.add(lineItems[girl]);
		}
	}
	
	/**
	 * Method: setSortedNameLists
	 * Objective: read boys and girls lists and set
	 *            its names to the sorted lists
	 */
	private void setSortedNameLists() {
		// set sorted lists
		boysList.forEach((boy)-> { boysSorted.add(boy);});
		girlsList.forEach((girl)-> { girlsSorted.add(girl);});
	}

	/**
	 * Method: getBoysList
	 * Objective: return a list of boys name
	 * @return List<String>: boysList
	 */
	public List<String> getBoysList() {
		return boysList;
	}

	/**
	 * Method: getGirlsList
	 * Objective: return a list of girls name
	 * @return List<String>: girlsList
	 */
	public List<String> getGirlsList() {
		return girlsList;
	}

	/**
	 * Method: getBoysSorted
	 * Objective: return a sorted list of boys names
	 * @return Set<String>: boysSorted
	 */
	public Set<String> getBoysSorted() {
		return boysSorted;
	}

	/**
	 * Method: getGirlsSorted
	 * Objective: return a sorted list of girls names
	 * @return Set<String>: girlsSorted
	 */
	public Set<String> getGirlsSorted() {
		return girlsSorted;
	}
	
	
}
