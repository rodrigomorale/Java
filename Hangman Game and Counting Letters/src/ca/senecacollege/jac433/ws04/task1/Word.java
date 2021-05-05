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
 * Class: Word
 * Objective: work in word object
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac433.ws04.task1;

public class Word {

	// class attributes
	private int size;
	private String word;
	private String showWord;
	
	/**
	 * Constructor
	 * @param word
	 */
	public Word(String word) {
		super();
		this.word = word;
		this.size = word.length();
		// fill showWord with '*' with the size of word
		for (int i = 0; i < word.length(); i++) {
			if (i == 0) { this.showWord = "*"; }
			else { this.showWord += "*"; }
		}
	}

	/**
	 * Method: getSize
	 * Objective: return size value
	 * @return int: size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method: getWord
	 * Objective: return word value
	 * @return String: word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Method: getShowWord
	 * Objective: return showWord
	 * @return String: showWord
	 */
	public String getShowWord() {
		return showWord;
	}
	
	/**
	 * Method: setShowWord
	 * Objective: assign value to showWord
	 * @param showWord
	 */
	public void setShowWord(String showWord) {
		this.showWord = showWord;
	}

	/**
	 * Method: findLetter
	 * Objective: find a letter in the word and replace the position in showWord
	 * @param letter
	 * @return boolean: true / false
	 */
	public boolean findLetter(char letter) {
		
		// variables declaration
		boolean finded = false;
		char[] wordArr = new char[word.length()];
		char[] showWordArr = new char[word.length()];
		String word = getWord();
		String showWord = getShowWord();
		
		// get array of chars from Strings word and showWord
		word.getChars(0, word.length(), wordArr, 0);
		showWord.getChars(0, showWord.length(), showWordArr, 0);
		
		// if find the letter in word, replace its position in showWord
		for(int i = 0; i < wordArr.length; i++) {
			if (letter == wordArr[i]) {
				showWordArr[i] = letter;
				finded = true;
			}
		}
		
		
		for (int i = 0; i < showWordArr.length; i++) {
			if (i == 0) { showWord = String.valueOf(showWordArr[i]);}
			else {showWord += String.valueOf(showWordArr[i]);}
		}
		
		setShowWord(showWord);
		return finded;
	}
}
