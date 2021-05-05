/**********************************************
Workshop 7
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 21, 2021
**********************************************/

package ca.senecacollege.JAC444.ws07.task1;

/**
 * Class: Disk
 * Objective: holds information about individual disk
 * @author Rodrigo CAnella Garcia Norale
 *
 */
public class Disk {
	
	// class attribute
	// 0: empty
	// 1: red
	// 2: yellow
	private int color;

	/**
	 * Constructor
	 */
	public Disk() {
		super();
		
		// set color to empty state
		this.color = 0;
	}

	/**
	 * Method: getColor
	 * Objective: return color value
	 * @return int: color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Method: setColor
	 * Objective: set color value
	 * @param color
	 */
	private void setColor(int color) {
		this.color = color;
	}
	
	/**
	 * Method: setToRed
	 * Objective: set color value to red
	 */
	public void setToRed() {
		setColor(1);
	}
	
	/**
	 * Method: setToYellow
	 * Objective: set color value to yellow
	 */
	public void setToYellow() {
		setColor(2);
	}
	
	/**
	 * Method: setToEmpty
	 * Objective: set color value to empty
	 */
	public void setToEmpty() {
		setColor(0);
	}
	
	/**
	 * Method: isRed
	 * Objective: check if the color is red
	 * @return boolean: true / false
	 */
	public boolean isRed() {
		return (getColor() == 1);
	}
	
	/**
	 * Method: isYellow
	 * Objective: check if color is yellow
	 * @return boolean: true / false
	 */
	public boolean isYellow() {
		return (getColor() == 2);
	}
	
	/**
	 * Method: isEmpty
	 * Objective: check if color value is empty
	 * @return boolean: true / false
	 */
	public boolean isEmpty() {
		return (getColor() == 0);
	}

	/**
	 * Method: printDisk
	 * Objective: print disk value
	 * @return String: color with 1 character
	 */
	public String printDisk() {
		String disk;
		
		if (isEmpty()) {
			disk = " ";
		} else {
			if (isRed()) {
				disk = "R";
			} else {
				disk = "Y";
			}
		}
		return disk;
	}
}
