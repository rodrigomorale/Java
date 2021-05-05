/**********************************************
Workshop 1
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: January, 31st 2021
**********************************************/

/**
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.ws01.pivot;

import java.util.Scanner;

public class Printer {
	
	public static void printProgramHeader() {
		/**
		 * Method printProgramHeader:
		 * Parameters: none;
		 * Objective: print the header of the program.
		 * Return values: none.
		 */
		
		// print program header
		System.out.println("*************************************************************");
		System.out.println("*** Pivot Program                                           *");
		System.out.println("*-----------------------------------------------------------*");
		System.out.println("*Pivot List - instructions:                                 *");
		System.out.println("* First Element: List size;                                 *");
		System.out.println("* Second Element: Pivot;                                    *");
		System.out.println("* Other Elements: List;                                     *");
		System.out.println("*** The progrma only accept integer values for each element *");
		System.out.println("*-----------------------------------------------------------*");
	}
	
	public static int[] getEntryList() {
		/**
		 * Method getEntryList:
		 * Parameters: none;
		 * Objective: get entry list from user
		 * Return values: entryList type int[].
		 */
		
		// read from standard input (STream)
		Scanner input = new Scanner(System.in);
		boolean validInput = false;
		int[] entryList = null;
		
		do {
			System.out.print("* Enter list: ");
			String entryListTxt = input.nextLine();
			String[] entryListSplited = entryListTxt.split(" ");
			entryList = new int[entryListSplited.length];
		
			try {
				for (int i = 0; i < entryListSplited.length; i++) {
					entryList[i] = Integer.parseInt(entryListSplited[i]);
				}
				validInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Sorry, you have an invalid input.");
				System.out.println("Please, include an input with just integer values.");
				validInput = false;
			}
		} while (!validInput);
		
		input.reset();
		input.close();
		return entryList;
	}
	
	public static void printResult(int[] newPivotList) {
		/**
		 * Method printResult:
		 * Parameters: newPivotList type int[].
		 * Objective: print rearranged pivot list
		 * Return values: none.
		 */
		
		System.out.print("* After the partition, the list is: ");
		for (int item: newPivotList) {
			System.out.print(item + " ");
		}
	}

}
