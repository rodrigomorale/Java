/**********************************************
Workshop 4
Course: JAC 433 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February 21, 2021
**********************************************/

/**
 * Class: CountLetters
 * Objective: execute main method for task 2
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac433.ws04.task2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CountLetters {

	// class attribute
	private static File fileTxt = new File("Coronavirus file.txt");
	
	/**
	 * Method: main
	 * Objective: execute task 2
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// create lists 
		List<Character> letters = new ArrayList<Character>();
		List<Integer> noLetters = new ArrayList<Integer>();
		
		// print header
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
		System.out.println("|=========| Task 2 - Count Letter |============|");
		System.out.println("|----------------------------------------------|");
			
		// try to open file	
		try(BufferedInputStream bfin = new BufferedInputStream(new FileInputStream(fileTxt));) {
			int eof;
			
			// read buffer
			while((eof = bfin.read()) != -1) {
				
				// get char
				char[] letter = Character.toChars(eof);
				
				// for each char
				for(int a = 0; a < letter.length; a++) {
					
					// check if the char is a letter
					boolean isLetter = Pattern.matches("^[a-zA-Z]", Character.toString(letter[a]));
					if (isLetter) {
						
						// if letters list is empty create first item
						if (letters.isEmpty()) {
							letters.add(letter[a]);
							noLetters.add(1);
						} else {
							// if letters list exist check if find in list
							int i = letters.indexOf(letter[a]);
							
							// if find letter in the list
							if (i != -1) {
								int cont = noLetters.get(i);
								cont++;
								noLetters.remove(i);
								noLetters.add(i, cont);
							} else {
							// if do not find in letter in the list
								letters.add(letter[a]);
								noLetters.add(1);
							}
						}
					}
				
				}
			}
		}
		
		// print list
		for (int i = 0; i < letters.size(); i++) {
			System.out.println("| Number of '" + letters.get(i) + "'s: " + noLetters.get(i));
		}
		
	}

}
