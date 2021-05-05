/**********************************************
Workshop 3
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: February, 14 2021
**********************************************/

/**
 * Class: PayrollSystemTest
 * Objective: Tester for workshop 3 
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class PayrollSystemTest {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * The main method for PayrollSystemTest.java should uses the Employee class and its subclasses.
		 * It should first create four objects, one for each subclass of Employee.
		 */
		
		// ComissionEmployee
		ComissionEmployee ce = new ComissionEmployee("John", "Doe", "111-111-111", 10000.13, 0.71);
		
		// HourlyEmployee
		HourlyEmployee he = new HourlyEmployee("Jack", "Willians", "222-222-222", 20.11, 42.12);
		
		// SalariedEmployee
		SalariedEmployee se = new SalariedEmployee("Peter", "Park", "333-333-333", 1000.21);
		
		// BasePlusComissionEmployee
		BasePlusComissionEmployee bpce = new BasePlusComissionEmployee("Tony", "Stark", "444-444-444", 20000.99, 0.97, 5000.13);
		
		/*
		 * Next your test should print information about each object individually, using toString.
		 * Sample:
		 * 	Employees processed individually: 
		 * 		Employee: Kyle Wright; SSN: 123-123-123; Salary {weekly salary:$500.00}
		 * 		earned: $500.00
		 * Note: You must use System.out.printf for this, Learn about Formatting with printf()
		 */
		//**************************!!!!!!!!!!!!!!!!!!!!!!!***********************************
		
		// Print header
		printHeader();
		System.out.printf("1. Test of toString() function for each type of object: %n");
		System.out.println();
		
		System.out.printf("a) ComissionEmployee: %n");
		System.out.printf("%s%n", ce.toString());
		System.out.printf("earned: $%.2f", ce.getPaymentAmount());
		System.out.println();	
		System.out.println();
		
		System.out.printf("b) HourlyEmployee: %n");
		System.out.printf("%s%n", he.toString());
		System.out.printf("earned: $%.2f", he.getPaymentAmount());
		System.out.println();
		System.out.println();
		
		System.out.printf("c) SalariedEmployee: %n");
		System.out.printf("%s%n", se.toString());
		System.out.printf("earned: $%.2f", se.getPaymentAmount());
		System.out.println();
		System.out.println();
		
		System.out.printf("d) BasePlusComissionEmployee: %n");
		System.out.printf("%s%n", bpce.toString());
		System.out.printf("earned: $%.2f",  bpce.getPaymentAmount());
		System.out.println();
		System.out.println();
		
		/*
		 * Next your test program should print information about each object polymorphically. 
		 * (You have four objects in the Array that you created when the test start so you have 
		 * to go over each object and print)
		 * Sample output:
		 * 	Employee: Jack Barney; SSN: 123-123-123; Commission {Gross Sales : 25000.0, Commission Rate: 0.12 }
		 * 	earned: $3000.00
		 */
		System.out.println("/**********************************************/");
		System.out.println("2. Test of toString() polymorphic function for each object of the array:");
		System.out.println();
		Employee[] employees = new Employee[4];
		employees[0] = ce;
		employees[1] = he;
		employees[2] = se;
		employees[3] = bpce;
		
		for(Employee emp: employees) {
			System.out.println(emp.toString());
			System.out.printf("earned: $%.2f", emp.getPaymentAmount());
			System.out.println();
			System.out.println();
		}
		
		
		/*
		 * The last for loop illustrates how to find out the specific class for each object.
		 * Sample: 
		 * 	Employee: Jack Barney is of class ca.senecacollege.ict.CommissionEmployee
		 */
		System.out.println("/**********************************************/");
		System.out.println("3. Print the specific object for each item of the array:");
		System.out.println();
		
		for(Employee emp: employees) {
			System.out.println(emp.getFirstName() + " " + emp.getLastName() + " is of class " + emp.getClass());
			System.out.println();
		}		
	}

	public static void printHeader() {
		System.out.println("/**********************************************");
		System.out.println("Workshop 3");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: February, 14 2021");
		System.out.println("**********************************************/");
	}

}
