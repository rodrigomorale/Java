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
 * Class: CheckingAccount
 * Objective: This class is a subclass of Account (specialization)
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class CheckingAccount extends Account {
	/*
	 * Class CheckingAccount should inherit from base class Account 
	 * and include a double instance variable that represents the 
	 * fee charged per transaction.
	 */
	private double fee;

	/*
	 * CheckingAccount’s constructor should receive the initial 
	 * balance, as well as a parameter indicating a fee amount.
	 */
	public CheckingAccount(double balance, double fee) {
		super(balance);
		this.fee = fee;
	}

	/*
	 * Class CheckingAccount should redefine methods Credit and 
	 * Debit so that they subtract the fee from the account balance 
	 * whenever either transaction is performed successfully.
	 */
	
	/*
	 * CheckingAccount’s versions of these methods should invoke 
	 * the base-class Account version to perform the updates to 
	 * an account balance.
	 */
	
	/**
	 * Method: credit (Override)
	 * Objective: Add amount to account balance and do fees debit for the transaction
	 * @return true / false
	 */
	@Override
	public boolean credit(double amount) {
		boolean transactionOK = false;
		if (super.credit(amount)) {
			transactionOK = super.debit(fee);
		}
		
		return transactionOK;
	}

	/*
	 * CheckingAccount’s Debit method should charge a fee only if 
	 * money is actually withdrawn (i.e., the debit amount does 
	 * not exceed the account balance).
	 */
	
	/**
	 * Method: debit
	 * Objective: Subtract amount from balance and do fees debit for the transaction
	 * @return true / false
	 */
	@Override
	public boolean debit(double amount) {
		boolean transactionOK = false;
		if (super.debit(amount)) {
			transactionOK = super.debit(fee);
		}
		
		return transactionOK;
	}

	public double getFee() {
		return fee;
	}

	
}
