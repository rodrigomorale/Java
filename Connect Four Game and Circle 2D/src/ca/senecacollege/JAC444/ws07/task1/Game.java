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
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class: Game
 * Objective: holds informations about game
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Game {

	// class attributes
	private static List<Row> board = new ArrayList<Row>();
	private static int row  = 6;
	private static Player winner;
	
	/*
	 * Game status
	 * 0: Continue
	 * 1: Win
	 * 2: Draw 
	 */
	private static int status = 0; 
	
	private static Scanner read = new Scanner(System.in);
	
	/**
	 * Method: main
	 * Objective: this method execute progrma Game
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		// declare variables
		String input;
		
		// fill each row with a new Row object
		for (int i = 0; i < 7; i++) {			
			board.add(new Row());
		}
		
		
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 7");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: March 21, 2021");
		System.out.println("**********************************************/");
		System.out.println("|=============================================|");
		System.out.println("|         Game - Connect Four                 |");
		System.out.println("|=============================================|");
		
		// read players names
		System.out.print("| Enter the name of the 'Red' player: ");
		input = read.nextLine();
		Player playerOne = new Player(input, 1);
		
		System.out.print("| Enter the name of the 'Yellow' player: ");
		input = read.nextLine();		
		Player playerTwo = new Player(input, 2);

		// loop while game not end
		do {
			// read red user
			printBoard();
			System.out.println();
			System.out.print("| Player " + playerOne.getName() + " - Drop a red disk at column (1-7): ");
			board.get(row).getRow().get(readColumn()).setToRed();
			checkRow();
			checkGame(playerOne);
			
			if (status == 0) {
				// read yellow user
				printBoard();
				System.out.println();
				System.out.print("| Player " + playerTwo.getName() + " - Drop a yellow disk at column (1-7): ");
				board.get(row).getRow().get(readColumn()).setToYellow();
				checkRow();
				checkGame(playerTwo);			
			}

		} while (status == 0);
		
		// print final board
		printBoard();
		System.out.println("|");
		
		// print winner
		if (getStatus() == 1) { System.out.println("| The winner is player " + getWinner().getName() + " - " + getWinner().getColor().printDisk()); }
		
		// print draw
		if (getStatus() == 2) { System.out.println("| The game finish with a draw between " +
													playerOne.getName() + " - Red " +
													playerTwo.getName() + " - Yellow"
				); }
		
		// print final message
		System.out.println("|=============================================|");
		System.out.println("|         Game - Finished                     |");
		System.out.println("|=============================================|");

	}
	
	/**
	 * Method: printBoard
	 * Objective: print game board 
	 */
	public static void printBoard() {
		System.out.println();
		System.out.println("  -----------------------------");
		for (int x = 0; x < 7; x++) {
			System.out.print("  ");
			for (int y = 0; y < 7; y++) {
				System.out.print("| " + board.get(x).getRow().get(y).printDisk() + " ");				
			}
			System.out.print("|\n");
		}
		System.out.println("  -----------------------------");
	}
	
	/**
	 * Method: readColumn
	 * Objective: read column of player next round
	 * @return int: column (number)
	 */
	public static int readColumn() {
		// declare variables
		int column = -1;
		String txColumn = "";
		
		// loop while don't have a valid input
		do {
			// read line
			txColumn = read.nextLine();
			
			// check pattern using regex
			if (Pattern.matches("^[1-7]$", txColumn)) {
				
				// parseInt of the string value
				column = Integer.parseInt(txColumn);
				column--;
				
				// if the column is alreasy filled, print message and ask for another input
				if (!board.get(row).getRow().get(column).isEmpty()) {
					System.out.print("| Please, select a empty column in the row: ");
					column = -1;
				}
			} else {
				// if the column do not match regex, as for a valid input
				System.out.print("| Please, entry a valid column number: ");
			}
		} while (column == -1);
		
		return column;
	}
	
	/**
	 * Method: CheckRow
	 * Objective: verify if need to add a new row 
	 */
	public static void checkRow() {
		// declare variables
		boolean newRow = true;
		
		// loop for all columns of the row to chekc for empy spaces
		for (int i = 0; i < 7; i++) {
			if (board.get(row).getRow().get(i).isEmpty()) {
				newRow = false;
			}
		}
		
		// if its need, add new row
		if (newRow) {
			setRow(getRow() - 1);
		}
	}
	
	/**
	 * Method: checkGame
	 * Objective: check and update game status 
	 * @param player
	 */
	public static void checkGame(Player player) {
		// it all the rows were filled, end game
		if (getRow() == -1) { setStatus(2);}
		
		// check if game finished, if not, check row, column and diagonal
		if (getStatus() == 0) {checkRowGame(player); }
		if (getStatus() == 0) {checkColumnGame(player); }
	 	if (getStatus() == 0) {checkDiagonalGame(player); }
	}
	
	/**
	 * Method: checkRowGame
	 * Objective: check if the player filled a row and won the game
	 * @param player
	 */
	public static void checkRowGame(Player player) {
		// declare variables
		int cntDisk = 0;
		
		// loop for every row
		for (int x= 6; x >= getRow(); x--) {
			
			// declare variables
			cntDisk = 0;
			int prevDisk = -1;
			
			// loop for each column of the row
			for (int y= 0 ; y < 7; y++) {
				// check if the disk match
				if (board.get(x).getRow().get(y).getColor() == player.getColor().getColor()) {
					// first find
					if (prevDisk == -1) {
						prevDisk = y;
						cntDisk++;
					// other finds
					} else {
						// if it is not a sequence
						if (prevDisk != y-1) {
							// initialize counter
							cntDisk = 0;
						} else {	
							cntDisk++;
						}
						prevDisk = y;
					}
					// if finds 4 sequential disks in the same row
					if (cntDisk >= 4) {
						// set winner
						setWinner(player);
						// finish game
						setStatus(1);					
					}
				}
			}
		}
	}
	
	/**
	 * Method: checkColumngame
	 * Objective: check if the player filled a column and won the game
	 * @param player
	 */
	public static void checkColumnGame(Player player) {
		// declare variable
		int cntDisk = 0;
		
		// loop in all columns
		for (int y= 0 ; y < 7; y++) {
			// declare variable
			cntDisk = 0;
			int prevDisk = 7;
			
			// loop i all rows
			for (int x= 6; x >= getRow(); x--) {
				if (board.get(x).getRow().get(y).getColor() == player.getColor().getColor()) {
					// first find
					if (prevDisk == 7) {
						prevDisk = x;
						cntDisk++;
					// other finds
					} else {
						// if it is not a sequence
						if (prevDisk != x+1) {
							// initialize counter
							cntDisk = 0;
						} else {	
							cntDisk++;
						}
						prevDisk = x;
					}

					// if finds 4 sequential disks in the same row
					if (cntDisk >= 4) {
						// set winner
						setWinner(player);
						// finish game
						setStatus(1);					
					}
				}
			}
		}		
	}
	
	/**
	 * Method: checkDiagonalGame
	 * Objective: check if the player filled a diagonal and won the game
	 * @param player
	 */
	public static void checkDiagonalGame(Player player) {
		checkDiagonalToRight(player);
		checkDiagonalToLeft(player);
	}
	
	public static void checkDiagonalToRight(Player player) {
		
	}
	
	public static void checkDiagonalToLeft(Player player) {
		
	}
	
	/**
	 * Method: getRow
	 * Objective: return row value
	 * @return int: row
	 */
	public static int getRow() {
		return row;
	}

	/**
	 * Method: setRow
	 * Objective: set a new value to a row
	 * @param row
	 */
	public static void setRow(int row) {
		Game.row = row;
	}
	
	/**
	 * Method: getWinner
	 * Objective: return the winner object
	 * @return Player: winner
	 */
	public static Player getWinner() {
		return winner;
	}

	/**
	 * Method: setWinner
	 * Objective: set a new game winner
	 * @param winner
	 */
	public static void setWinner(Player winner) {
		Game.winner = winner;
	}

	/**
	 * Method: getStatus
	 * Objective: return the status of the game
	 * @return int: status
	 */
	public static int getStatus() {
		return status;
	}

	/**
	 * Method: setStatus
	 * Objective: set a new status to the game
	 * @param status
	 */
	public static void setStatus(int status) {
		Game.status = status;
	}	
}
