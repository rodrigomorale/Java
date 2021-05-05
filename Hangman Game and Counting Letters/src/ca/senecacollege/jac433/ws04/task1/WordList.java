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

/**
 * Class: WordList
 * Objective: create a file with word list
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac433.ws04.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordList {

	// class attributes
	private File fileTxt = new File("out.txt");
	private int listSize = 10;
	
	// Constructor
	public WordList() {
		super();
	}

	/**
	 * Method: getFileTxt
	 * Objective: return the fileTxt
	 * @return File: fileTxt
	 */
	public File getFileTxt() {
		return fileTxt;
	}

	/**
	 * Method: getListSize
	 * Objective: return the size of the wordList
	 * @return int: listSize
	 */
	public int getListSize() {
		return listSize;
	}
	
	/**
	 * Method: create
	 * Objective: create a new file with 10 words
	 * @throws FileNotFoundException
	 */
	public void create() throws FileNotFoundException {
		
		// write in the file
		PrintWriter output = new PrintWriter(getFileTxt());		
		output.println("PROGRAMMER");
		output.println("SENECA");
		output.println("CANADA");
		output.println("TORONTO");
		output.println("COMPUTER");
		output.println("CAR");
		output.println("STREET");
		output.println("MAGIC");
		output.println("STREET");
		output.println("HOCKEY");
		output.flush();
		output.close();
	}
	

	/**
	 * Method: read
	 * Objective: read informations of the file and return as a String array
	 * @return String[]: wordList
	 * @throws FileNotFoundException
	 */
	public String[] read() throws FileNotFoundException {
		String[] wordList = new String[getListSize()];
		
		// read from the file
		Scanner input = new Scanner(getFileTxt());
		for (int i = 0; i < getListSize(); i++) {
			wordList[i] = input.nextLine();
		}
		input.close();
		
		return wordList;
	}
	
	
}
