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
 * Class: HangmanGame
 * Objective: Execute the main method
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac433.ws04.task1;

import java.io.FileNotFoundException;

public class HangmanGame {
	
	/**
	 * Method: Main
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String [] args) throws FileNotFoundException {
		
		// variable declaration
		boolean endGame = false;
		
		// create word list file
		WordList wl = new WordList();
		wl.create();
		
		// copy informations from the file to list
		String[] list = wl.read();
		
		// create printer and print header
		Printer printer = new Printer();
		printer.header();
		
		// create reader to read user information
		Reader reader = new Reader();
		
		// execute loop until user finish game
		do {
			// create word and game classes
			// chose random word from the list
			Word word = new Word(list[(int)(Math.random() * 10)]);
			Game game = new Game(word);
			
			// execute until endgame 
			do {
				// while the game not end, execute new rounds
				game.newRound(reader);
			} while (!game.isEndGame());
			
			// print misses information
			System.out.println("| You missed " + game.getNoMisses() + " letters.");
			
			// check if the user want to play another game
			endGame = !printer.continueToPlay(reader);
			
		} while (!endGame);
		
		// print program greeting and close Scanner
		printer.greetings();
		reader.close();
	}

}
