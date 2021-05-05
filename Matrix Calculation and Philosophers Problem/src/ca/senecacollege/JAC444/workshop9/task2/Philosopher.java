/**********************************************
Workshop 9
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: April 02, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop9.task2;

public class Philosopher {
	
	// class attributes
	private String name;
	private int noChopstickAte;
	private boolean finished;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Philosopher(String name) {
		super();
		this.name = name;
		this.noChopstickAte = 0;
		this.finished = false;
	}

	/**
	 * Method:getName
	 * Objective: get philosopher name
	 * @return String: name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method: setName
	 * Objective: set philosopher name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method: getNoChopstickAte
	 * Objective: get number of chopstick ate 
	 * @return int: noChopstickAte
	 */
	public int getNoChopstickAte() {
		return noChopstickAte;
	}

	/**
	 * Method: setNoChopstickAte
	 * Objective: set number of chopstick ate
	 * @param noChopstickAte
	 */
	public void setNoChopstickAte(int noChopstickAte) {
		if (noChopstickAte == 2) { 
			setFinished(true);
			this.noChopstickAte = noChopstickAte;
		}
		else {if (this.noChopstickAte < 2) {this.noChopstickAte = noChopstickAte; }}
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	

}
