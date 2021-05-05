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

public class Craps {
	
	public static void main(String[] args) {
		// variables definition
		Dice[] dices = new Dice[2];
		Round round = new Round(2);
		String lose = "Craps, Better Luck Next Time, You lose";
		String win = "Congratulations, You win";
		
		// initialize dices
		for (int i = 0; i < dices.length; i++) {			
			dices[i] = new Dice();
			dices[i].Roll();
		}
				
		// sum up dices
		round.setDices(dices);
		round.printRound();

		// switch depending on Sum value
		switch (round.getSum()) {
		case 2:
		case 3:
		case 12:
			System.out.println(lose);
			break;
		case 7:
		case 11:
			System.out.println(win);
			break;
		default:
			round.setPoint();
			System.out.println("Point is (established) set to " + round.getSum());
			break;			
		}
		
		if (round.getPoint() != 0) {
			boolean end = false;
			do {
				// roll dices
				for (int i = 0; i < dices.length; i++) {			
					dices[i].Roll();
				}
				
				// sum up dices
				round.setDices(dices);
				round.printRound();
				
				if (round.getSum() == 7) {
					System.out.println(lose);
					end = true;
				} else {
					if (round.win()) {
						System.out.println(win);
						end = true;
					} else {
						end = false;
					}
				} 
				
			} while (!end);
		}
		
	}

}
