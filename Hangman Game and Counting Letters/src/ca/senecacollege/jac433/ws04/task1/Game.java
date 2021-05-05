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

package ca.senecacollege.jac433.ws04.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Game
 * Objective: This class control game
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Game {

	// class attributes
	private int noMisses;
	private boolean endGame;
	private List<String> missesLetters = new ArrayList<String>();
	private List<String> targetLetters = new ArrayList<String>();
	private Word word;
	
	/**
	 * Constructor
	 * @param word
	 */
	public Game(Word word) {
		super();
		this.setWord(word);
		this.noMisses = 0;
		this.endGame = false;
	}

	/**
	 * Method: getNoMisses
	 * Objective: get number of misses
	 * @return int: noMisses
	 */
	public int getNoMisses() {
		return noMisses;
	}

	/**
	 * Method: setNoMisses
	 * Objective: assign number of misses
	 * @param noMisses
	 */
	public void setNoMisses(int noMisses) {
		this.noMisses = noMisses;
	}

	/**
	 * Method: isEndGame
	 * Objective: check if game ended
	 * @return boolean : true / false
	 */
	public boolean isEndGame() {
		return endGame;
	}

	/**
	 * Method: setEndGame
	 * Objective: assign value to end game
	 * @param endGame
	 */
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}

	/**
	 * Method: getMissesLetters
	 * Objective: get list of misses letters
	 * @return List<String> missesLetters
	 */
	public List<String> getMissesLetters() {
		return missesLetters;
	}

	/**
	 * Method: setMissesLetters
	 * Objective: assign value to missesLetters
	 * @param missesLetters
	 */
	public void setMissesLetters(List<String> missesLetters) {
		this.missesLetters = missesLetters;
	}
	
	/**
	 * Method: getWord
	 * Objective: get word value
	 * @return Word: word
	 */
	public Word getWord() {
		return word;
	}

	/**
	 * Method: setWord
	 * Objective: assign value to word of game
	 * @param word
	 */
	public void setWord(Word word) {
		this.word = word;
	}
	
	/**
	 * Method: getTargetLetters
	 * Objective: get list of target letters
	 * @return List<String>: targetLetters
	 */
	public List<String> getTargetLetters() {
		return targetLetters;
	}
	
	/**
	 * Method: setTargetLetters
	 * Objective: assign value to list of target letters
	 * @param targetLetters
	 */
	public void setTargetLetters(List<String> targetLetters) {
		this.targetLetters = targetLetters;
	}	

	/**
	 * Method: newRound
	 * Objective: execute a new round
	 * @param reader
	 */
	public void newRound (Reader reader) {
		// declare variable
		boolean find = false;
		
		// execute until user find a letter of the word
		do {
			// get new letter
			String targetLetterStr = reader.readChar("| (Guess) Enter a letter in word " + this.word.getShowWord() + " : ");
			boolean missedLetter = false;
			boolean targetLetter = false;
			
			// check if the new letter is already missed
			if (!this.missesLetters.isEmpty()) {			
				for (int i = 0; i < this.missesLetters.size(); i++) {
					String letter = this.missesLetters.get(i); 
					if ( letter.contentEquals(targetLetterStr)) {
						missedLetter = true;
					}
				}
			}
		
			// Check if the new letter is already in the word
			if (!this.targetLetters.isEmpty()) {
				for (int i = 0; i < this.targetLetters.size(); i++) {
					String letter = this.targetLetters.get(i);
					if (letter.contentEquals(targetLetterStr)) {
						targetLetter = true;
					}
				}	

			}
		
			// work on new letter
			if (!targetLetter && !missedLetter) {
				// if the letter is not missed or target, try to find in word
				find = this.word.findLetter(targetLetterStr.charAt(0));
				// if find, add to target
				if (find) { this.targetLetters.add(targetLetterStr);
				} else { 
					// if do not find and it is not missed
					if (!missedLetter) {
						this.missesLetters.add(targetLetterStr);						
						setNoMisses(getNoMisses() + 1); 
						System.out.println("|         '" + targetLetterStr + "' is not in the word.");									
						System.out.println("|         Try again!");
					}
				}
				System.out.println();
			} else {
				// work if the new letter is already in the word 
				if (targetLetter) {
					System.out.println("|         '" + targetLetterStr + "' is already in the word.");
				} else {
					// work if the new letter is already in missed list
					System.out.println("|         You have already tried '" + targetLetterStr + "' try a new letter.");	
				}
				System.out.println("|         Try again!");
				System.out.println();
			}
		} while (!find);
		
		// work to check if the game end
		String word = this.word.getWord();
		String showWord = this.word.getShowWord();
		if (word.contentEquals(showWord)) { setEndGame(true); }		
	}
	
}
