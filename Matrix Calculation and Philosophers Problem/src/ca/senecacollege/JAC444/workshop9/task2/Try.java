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
 * Class: Try
 * Objective: handle thread
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Try extends Thread {

	// class attributes
	private Philosopher philo;

	/**
	 * Constructor
	 * @param philo
	 */
	public Try(Philosopher philo) {
		super();
		this.philo = philo;
	}
	
	/**
	 * Method: run
	 * Objective: override run from parent class Thread
	 */
	@Override
	public void run() {
		synchronized (philo) {
			try {
				System.out.println("| Phylosopher " + philo.getName() + " waiting...");
				philo.wait();
				if (!philo.isFinished()) {
					philo.setNoChopstickAte(philo.getNoChopstickAte() + 1);
					System.out.println("| Phylosopher " + philo.getName() + " ate one chopstick!");
				}
			} catch (InterruptedException e) {
				if (!philo.isFinished()) {
				   System.out.println("| " + philo.getName() + ", another philosopher is trying to eat, please wait your turn!");
				}
			}
		}
	}
	
}
