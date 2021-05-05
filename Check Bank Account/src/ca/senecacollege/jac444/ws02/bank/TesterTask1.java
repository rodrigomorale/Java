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

public class TesterTask1 {

	public static void main(String[] args) {
		/*
		 * After defining the classes in this hierarchy, write 
		 * an app that creates objects of each class and tests 
		 * their methods. Add interest to the SavingsAccount 
		 * object by first invoking its CalculateInterest method, 
		 * then passing the returned interest amount to the object’s 
		 * Credit method. The tester class should be a different class.
		 */
		
		
		//******************** Test of Account Type *****************************//
		System.out.println("//******************** Test of Account Type *****************************//");
		// Object creation
		Account account = new Account(1000);   
		System.out.println("Object type Account created: " + account.toString());
		System.out.println();
		
		// getbalance test
		System.out.println("The initial balance of the account is: " + account.getBalance());
		System.out.println();
		
		// credit method test
		System.out.println("The balance before credit was: " + account.getBalance());
		account.credit(100);
		System.out.println("the balance after $100 credit is: " + account.getBalance());
		System.out.println();
		
		// debit method test
		System.out.println("The balance before debit was: " + account.getBalance());
		account.debit(110);
		System.out.println("the balance after $110 debit is: " + account.getBalance());
		System.out.println();
		
		
		
		//******************** Test of SavingsAccount Type *****************************//
		System.out.println("//******************** Test of SavingsAccount Type *****************************//");
		// Object creation
		SavingsAccount savingsAccount = new SavingsAccount(2000, 3.2);
		System.out.println("Object type Savings Account created: " + savingsAccount.toString());
		System.out.println();
		
		// getbalance test
		System.out.println("The initial balance of the Savings Account is: " + savingsAccount.getBalance());
		System.out.println();
		
		// getInterestRate test
		System.out.println("The interest rate of the Savings Account is: " + savingsAccount.getInterestRate());
		System.out.println();
		
		// calculateInterest test
		System.out.println("The interest amount of the Savings Account is: " + savingsAccount.calculateInterest());
		System.out.println();
			
		// credit method test
		System.out.println("The balance before credit was: " + savingsAccount.getBalance());
		savingsAccount.credit(200);
		System.out.println("the balance after $200 credit is: " + savingsAccount.getBalance());
		System.out.println();
				
		// debit method test
		System.out.println("The balance before debit was: " + savingsAccount.getBalance());
		savingsAccount.debit(220);
		System.out.println("the balance after $220 debit is: " + savingsAccount.getBalance());
		System.out.println();
		
		
		//******************** Test of ChekingAccount Type *****************************//
		System.out.println("//******************** Test of ChekingAccount Type *****************************//");
		// Object creation
		CheckingAccount checkingAccount = new CheckingAccount(3000, 33.33);
		System.out.println("Object type Checking Account created: " + checkingAccount.toString());
		System.out.println();
		
		// getbalance test
		System.out.println("The initial balance of the Checking Account is: " + checkingAccount.getBalance());
		System.out.println();
		
		// getFee test
		System.out.println("The fee of the Checking Account is: " + checkingAccount.getFee());
		System.out.println();
					
		// credit method test
		System.out.println("The balance before credit was: " + checkingAccount.getBalance());
		checkingAccount.credit(300);
		System.out.println("the balance after $300 credit is: " + checkingAccount.getBalance());
		System.out.println();
				
		// debit method test
		System.out.println("The balance before debit was: " + checkingAccount.getBalance());
		checkingAccount.debit(330);
		System.out.println("the balance after $330 debit is: " + checkingAccount.getBalance());
		System.out.println();
	}
}
