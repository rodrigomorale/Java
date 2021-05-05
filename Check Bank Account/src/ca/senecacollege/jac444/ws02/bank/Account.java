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
 * Class: Account
 * Objective: This is a generic class for accounts type
 * @author Rodrigo CAnella Garcia Morale
 *
 */
public class Account {
	
	/*
	 * Create class Account that should include one private instance variable of 
	 * type double to represent the account balance.
	 */
	private double balance;
	
	/*
	 * The class should provide a constructor that receives an initial balance 
	 * and uses it to initialize the instance variable with a public property.
	 */
	public Account(double balance) {
		super();
		this.balance = balance;
		
		/*
		 * The property should validate the initial balance to ensure that it’s 
		 * greater than or equal to 0.0; if not, display an error 
		 * message (Explore System.err.println).
		 */
		if (this.balance < 0.0) {
			System.err.println("Invalid initial balance. The initial balance must to be greater or equal than 0.");
		}	
	}
	
	// The class should provide two public methods.
	
	// Method Credit should add an amount to the current balance.
	/**
	 * Method: credit
	 * Objective: Add an amount to account balance
	 * @param amount (positive value)
	 * @return true / false
	 */
	public boolean credit(double amount) {
		boolean transactionOK = true;
		
		if (amount <= 0.0) {
			transactionOK = false;
		} else {
			this.balance += amount;
		}
		
		return transactionOK;
	}
	
	/*
	 * Method Debit should withdraw money from the Account and ensure 
	 * that the debit amount does not exceed the Account’s balance. If 
	 * it does, the balance should be left unchanged, and the method 
	 * should display the message "Debit amount exceeded account balance."
	 */
	
	/**
	 * Method: debit
	 * Objective: Subtract an amount from account balanca
	 * @param amount (Positive value)
	 * @return true / false
	 */
	public boolean debit(double amount) {
		boolean transactionOK = false;
		
		if (amount > 0.00) {
			if (this.balance < amount) {
				System.out.println("Debit amount exceeded account balance.");
			} else {
				this.balance -= amount;
				transactionOK = true;
			}
		}
		
		return transactionOK;
	}
	
	/*
	 * The class should also provide a get accessor in property 
	 * Balance that returns the current balance.
	 */
	
	/**
	 * Method: getBalance
	 * Objective: return the account balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
}
