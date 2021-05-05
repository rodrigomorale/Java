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

package ca.senecacollege.jac444.ws01.craps;

public class Dice {
	
	// attributes of dice
	private int[] faces = new int[6];
	private int rollValue;
	
	// contructor
	public Dice() {
		for(int i = 0; i < this.faces.length; i++) {
			faces[i] = i + 1;
		}
		
		this.rollValue = 0;
	}
	
	// method Roll
	public void Roll() {
		/**
		 * Method Roll:
		 * Parameters: none.
		 * Objective: Roll dices and store at rollValue.
		 * Return values: none.
		 */
		this.rollValue = ((int)(Math.random() * 6));
	}
	
	// get rollvalue
	public int getRollValue() {
		/**
		 * Method getRollValue:
		 * Parameters: none.
		 * Objective: return rollValue.
		 * Return values: rollValue type int.
		 */
		return this.rollValue;
	}

}
