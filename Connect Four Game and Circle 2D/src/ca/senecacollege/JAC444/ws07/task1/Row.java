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

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Row
 * Objective: holds informations about row
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Row {

	// class attribute
	private List<Disk> row = new ArrayList<Disk>();

	/**
	 * Constructor
	 */
	public Row() {
		super();
		
		// add new Disk object for every new row column
		for (int i = 0; i < 7; i++) {
			row.add(new Disk());
		}
	}

	/**
	 * Method: getRow
	 * Objective: get row list
	 * @return List<Disk>: row
	 */
	public List<Disk> getRow() {
		return row;
	}

	/**
	 * Method: setRow
	 * Objective: set a value to row list
	 * @param row
	 */
	public void setRow(List<Disk> row) {
		this.row = row;
	}
}
