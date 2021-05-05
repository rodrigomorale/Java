/**********************************************
Workshop 2
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February, 7th 2021
**********************************************/

package ca.senecacollege.jac444.ws02.bank;

/**
 * Class: SavingsAccount
 * Objective: This class is a subclass of accounts (specialization)
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class SavingsAccount extends Account {
	
	/*
	 * Class SavingsAccount should inherit the functionality of an 
	 * Account, but also include a double instance variable 
	 * indicating the interest rate (percentage) assigned to 
	 * the Account.
	 */
	private double interestRate;

	
	/*
	 * SavingsAccount’s constructor should receive the initial 
	 * balance, as well as an initial value for the interest rate.
	 */
	public SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	
	/*
	 * SavingsAccount should provide public method CalculateInterest 
	 * that returns a double indicating the amount of interest earned 
	 * by an account.
	 */
	
	/**
	 * Method: calculateInterest
	 * Objective: calculate the amount of interest 
	 * @return amount of interest
	 */
	public double calculateInterest() {
		/*
		 * Method CalculateInterest should determine this amount by 
		 * multiplying the interest rate by the account balance.
		 */	
		return interestRate * getBalance();
	}

	/**
	 * Method: getInterestRate
	 * Objective: Return the interest rate
	 * @return interest rate
	 */
	public double getInterestRate() {
		return interestRate;
	}	
}
