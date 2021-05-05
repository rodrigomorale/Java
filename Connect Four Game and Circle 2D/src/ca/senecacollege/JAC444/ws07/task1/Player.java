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
 * Class: Player
 * Objective: holds informations about the player
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Player {
	
	// class attributes
	String name;
	Disk color = new Disk();
	
	/**
	 * Constructor
	 * @param name
	 * @param color
	 * @throws Exception 
	 */
	public Player(String name, int color) {
		super();
		this.name = name;
		
		this.setColor(color);
	}

	/**
	 * Method: getName
	 * Objective: return player name
	 * @return String: name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method: setName
	 * Objective: set player name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method: getColor
	 * Objective: return player color object
	 * @return Disk: color
	 */
	public Disk getColor() {
		return color;
	}

	/**
	 * Method: setColor
	 * Objective: set object color to a player
	 * @param color
	 */
	public void setColor(int color) {
		// decide disk color based on color value
		if ((color != 1) && (color != 2)) {
			this.color.setToEmpty();
		} else {
			if (color == 1) {
				this.color.setToRed();
			}
			
			if (color == 2) {
				this.color.setToYellow();
				
			}			
		}
	}
}
