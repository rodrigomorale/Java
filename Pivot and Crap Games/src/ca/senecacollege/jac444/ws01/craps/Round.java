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

public class Round {

	// class attributes
	private int sum;
	private int point;
	private int noDices;
	private int[] dices;
	
	// class constructor
	public Round(int dices) {
		this.sum = 0;
		this.point = 0;
		this.noDices = dices;
		this.dices = new int[dices];
	}
	
	// method to set sum
	public void setSum() {
		/**
		 * Method setSum:
		 * Parameters: none.
		 * Objective: Calculate sum of all rollValues from the dices and stored at sum.
		 * Return values: none.
		 */
		this.sum = 0;
		for (int dice: this.dices) {
			this.sum += dice;
		}
	}
	
	// method to set point
	public void setPoint() {
		/**
		 * Method setPoint:
		 * Parameters: none.
		 * Objective: set the value of sum to point.
		 * Return values: none.
		 */
		this.point = this.sum;
	}
	
	// setDices
	public void setDices(Dice[] dices) {
		/**
		 * Method setDices:
		 * Parameters: dices type Dice[].
		 * Objective: Set rollValue from dices to a list of values of the round.
		 *            Calculate the sum of all rollValues
		 * Return values: none.
		 */
		for(int i = 0; i < this.noDices; i++) {
			if (i < dices.length) {
				this.dices[i] = dices[i].getRollValue();
			} else {
				this.dices[0] = 0;
			}
		}
		
		setSum();
	}
	
	// method initialize class attributes
	public void initialize() {
		/**
		 * Method initialize:
		 * Parameters: none.
		 * Objective: initialize sum and point values.
		 * Return values: none.
		 */
		this.sum = 0;
		this.point = 0;
	}
	
	// method to get sum
	public int getSum() {
		/**
		 * Method getSum:
		 * Parameters: none.
		 * Objective: get sum value.
		 * Return values: sum type int.
		 */
		return this.sum;
	}
	
	// method to get point
	public int getPoint() {
		/**
		 * Method getPoint:
		 * Parameters: none.
		 * Objective: get point value.
		 * Return values: point type int.
		 */
		return this.point;
	}
	
	// print round
	public void printRound() {
		/**
		 * Method printRound:
		 * Parameters: none.
		 * Objective: print the text of the round.
		 * Return values: none.
		 */
		System.out.print("You rolled");
		for(int i = 0; i < this.noDices; i++) {
			if (i == 0) {
				System.out.print(" " + this.dices[i]);
			} else {				
				System.out.print(" + " + this.dices[i]);
			}
		}
		System.out.println(" = " + this.sum);
	}
	
	// check sum == point
	public boolean win() {
		/**
		 * Method win:
		 * Parameters: none.
		 * Objective: check if sum == point.
		 * Return values: result type as boolean.
		 */
		return this.sum == this.point;
	}
}
