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

/**
 * Class: Task2Program
 * Objective: Execute the main method of task2 program 
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Task2Program {

	/**
	 * Method: main
	 * Objective: Execute task2 program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 9");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: April 02, 2021");
		System.out.println("**********************************************/");
		System.out.println("|=============================================|");
		System.out.println("|         Task 2 - Philosophers               |");
		System.out.println("|=============================================|");
		
		
		// add philosophers
		Philosopher[] philo = new Philosopher[5];
		philo[0] = new Philosopher("Socrates");
		philo[1] = new Philosopher("Plato");
		philo[2] = new Philosopher("Kant");
		philo[3] = new Philosopher("Voltaire");
		philo[4] = new Philosopher("Nietzsche");
		boolean allAte = false;
		
		// print philosophers
		System.out.println("| ### Adding Philosophers to the table ###    |");
		System.out.println("|---------------------------------------------|");
		for(Philosopher dude: philo) {
			System.out.println("|---------------------------------------------|");
			System.out.println("| Phisolopher " + dude.getName() + " added!");
		}
		System.out.println("|---------------------------------------------|");
		
		do {
			allAte = true;
			for(Philosopher dude: philo) {
				if (dude.isFinished() == false) {
					allAte = false;
				}
			}
			
			if (!allAte) {
				Try[] eatRound = new Try[5];
				for (int i = 0; i < eatRound.length; i++) {
					eatRound[i] = philo[i].isFinished() ? null : new Try(philo[i]);
				}
				
				for(Try round: eatRound) { 
					if (round != null) {round.start();}
				}
		
				for(Philosopher dude: philo) {
					synchronized (dude) {
						dude.notify();						
						System.out.println("| Phisolopher " + dude.getName() + " notified!");
					}					
				}
				
				for(Try round: eatRound) { 
					if (round != null) {round.interrupt();}
				}
			}
			
		} while (!allAte);
		
		// print final message
		System.out.println("|---------------------------------------------|");
		System.out.println("| All philosophers finished to eat!           |");
		
		for(Philosopher dude: philo) {
			System.out.println("|---------------------------------------------|");
			System.out.println("| Phisolopher " + dude.getName() + " ate " + dude.getNoChopstickAte() + " chopsticks.");
		}
		
		System.out.println("|=============================================|");
		System.out.println("|         Program - Finished                  |");
		System.out.println("|=============================================|");

	}

}
