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

public class TesterTask2 {
	
	public static void main(String[] args) {
		
		// global variables
		int noAccounts = -1;
		double transactionValue = 0.0;
		boolean exit = false;
		boolean newAccount = false;
		boolean newTransaction = false;
		boolean transactionOk = false;
		String accountType = "A";
		String transactionType = "N";
		
		/*
		 * Let’s update the Task1 and create an 
		 * array of Account references to SavingsAccount 
		 * and CheckingAccount objects.
		 */
		Account[] accounts = new Account[5];
		
		/*
		 * For each Account in the array, allow the user 
		 * to specify an amount of money to withdraw from 
		 * the Account using method Debit and an amount of 
		 * money to deposit into the Account using method 
		 * Credit.
		 */
		
		// program header
		System.out.println("|******************** Task 2 Account tester *****************************|");
		System.out.println("| You can define up to 5 accounts.");
		System.out.println("| First define the account type: Savings (S) or Cheking (C).");
		System.out.println("| Second, add (C) or subtract (D) values from accounts.");
		System.out.println("| Third, when finished entry (S) to show account final balance and");
		System.out.println("| if it is a savings account the amount of interest will be shown too.");
		System.out.println("|========================================================================|");
		
		/*
		 * As you process each Account, determine its type. 
		 * If an Account is a SavingsAccount, calculate the 
		 * amount of interest owed to the Account using method 
		 * CalculateInterest, then add the interest to the 
		 * account balance using method Credit. After processing 
		 * an Account, display the updated account balance 
		 * obtained by using baseclass property Balance.
		 */
		
		// loop while user don't finish to add new accounts and transactions
		do {
			System.out.println("|");
			newAccount = Helpers.readYesNo("| Would you like to add a new account? (Y/N): ");
			System.out.println("|");
			
			// ask if user want to add a new account
			if (newAccount) {
				System.out.println("|========================================================================|");
				double balance = 0.0;
				noAccounts++;
				
				// ask for the account type
				System.out.println("| What kind of account you would like to add:");
				String[] accountTypeValues = {"S", "s", "C", "c"};
				accountType = Helpers.readString("| Savings (S) or Checking (C)? (S/C): ", accountTypeValues);
				System.out.println("|");
				
				// if the new account is a Savings
				if (accountType.contentEquals("S") || accountType.contentEquals("s")) {
					double interestRate = 0.0;
					System.out.println("| Enter informations about your new Savings Account.");
					balance = Helpers.readValue("| Enter the inital balance: ", balance);
					interestRate = Helpers.readValue("| Enter the interest rate: ", interestRate);
					accounts[noAccounts] = new SavingsAccount(balance, interestRate); 
				} else {
					// if the new account is a Checking
					double fees = 0.0;
					System.out.println("| Enter informations about your new Cheking Account.");
					balance = Helpers.readValue("| Enter the inital balance: ", balance);
					fees = Helpers.readValue("| Enter the fees: ", fees);
					accounts[noAccounts] = new CheckingAccount(balance, fees); 
				}
				
				// loop while user add transactions
				do {
					System.out.println("|");
					newTransaction = Helpers.readYesNo("| Would you like to add transactions to your account? (Y/N): ");
					if (newTransaction) {
						// ask for the type of transaction
						String[] transactionTypeValues = {"C", "c", "D", "d"};
						transactionType = Helpers.readString("| Credit (C) or Debit (D)? (C/D): ", transactionTypeValues);
						transactionValue = Helpers.readValue("| Enter the transaction value: ", transactionValue);
						
						if (transactionType.contains("C") || transactionType.contentEquals("c")) {
							transactionOk = accounts[noAccounts].credit(transactionValue);
						} else { transactionOk = accounts[noAccounts].debit(transactionValue);}
						
						// check if the transaction was executed with success
						if (transactionOk) { System.out.println("| Your transaction was executed with success!");}
						else { System.out.println("| Failure to execute your transaction.");}
						
						System.out.println("| Your new account balance is: " + accounts[noAccounts].getBalance());
					}
				} while (newTransaction);
				
				// if the type o the new account is savings: add the interest amount to account balance
				if (accounts[noAccounts] instanceof SavingsAccount) {
					double interestAmount = ((SavingsAccount) accounts[noAccounts]).calculateInterest();
					System.out.println("| The interest amount is: " + interestAmount);
					transactionOk = accounts[noAccounts].credit(interestAmount);
				}
				
				// shows the final balance of the account
				System.out.println("| The final balance of your account is: " + accounts[noAccounts].getBalance());
			} else { exit = true; }
			
			// check if the array of accounts was full
			if (noAccounts + 1 == accounts.length) { 
				System.out.println("|");
				System.out.println("| *** Max number of accounts loaded! ***"); 
			}
			
		} while (((noAccounts + 1) < accounts.length) && !exit);
		
		System.out.println("|");
		// close Scanner class
		Helpers.closeRead();
		
		// print the resume of all accounts 
		if (noAccounts >= 0) {
			// print the final values for each account
			System.out.println("|========================================================================|");
			System.out.println("|********************* Final Account Values *****************************|");
			System.out.println("|");
			for (int i = 0; i < noAccounts + 1; i++) {
				System.out.println("| Account [" + i + "]-Type: " + accounts[i].getClass());
				System.out.println("| Account balance: " + accounts[i].getBalance());
				System.out.println("|");
			}			
			System.out.println("|========================================================================|");
		} else { 
			System.out.println("|========================================================================|");
			System.out.println("|********************* No Account defined *******************************|");
			System.out.println("|========================================================================|");
		}
	}

}
