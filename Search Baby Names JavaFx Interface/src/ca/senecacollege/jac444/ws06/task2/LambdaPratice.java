/**********************************************
Workshop 6
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 15, 2021
**********************************************/

package ca.senecacollege.jac444.ws06.task2;

import java.util.Scanner;

public class LambdaPratice {
		
	/**
	 * Method: Main
	 * Objective: test lambda 
	 * @param args
	 */
	public static void main (String[] args) {
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 6");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("**********************************************/");
		
		// define Scanner
		Scanner scan = new Scanner(System.in);
		String[] lsInput;
		
		// get numbers from the user
		System.out.print("| Please, enter a list of numeric values: ");
		String input = scan.nextLine();
	
		// separate numbers
		lsInput = input.split(" ");
		
		double[] attLsValue = new double[lsInput.length];
		for(int i = 0; i < attLsValue.length; i++) {
			attLsValue[i] = Double.parseDouble(lsInput[i]);
		}
				
		/*
		 * Write a class that defines four public static final variables of type ArrayProcessor that
		   process an array in the following ways:
				1. find the maximum value in the array
				2. find the minimum value in an array
				3. find the sum of the values in the array
				4. find the average of the values in the array.
		 */
		//In each case, the value of the variable should be given by a lambda expression.
		final ArrayProcessor max = (lsValue) -> {
			double maxV = 0;
			for (double value: lsValue) { if (maxV < value) { maxV = value; } }
			return maxV;
		};
		
		final ArrayProcessor min = (lsValue) -> {
			double minV = 0;
			for (int i = 0; i < lsValue.length; i++) {
				if (i == 0) { minV = lsValue[i];}
				else {
					if (lsValue[i] < minV) {
						minV = lsValue[i];
					}
				}
			}
			
			return minV;
		};
		
		final ArrayProcessor sum = (lsValue) -> {
			double sumV = 0;
			for(double value: lsValue) { sumV += value;}
			return sumV;
		};
		
		final ArrayProcessor avg = (lsValue) -> {
			double sumV = 0;
			double avgV = 0;
			
			for(double value: lsValue) { sumV += value;}
			avgV = sumV / lsValue.length;
			
			return avgV;
		};
		
		
		// Show the result
		System.out.println();
		System.out.println("| The maximun value of the list is : " + max.apply(attLsValue));
		
		System.out.println();
		System.out.println("| The minimun value of the list is : " + min.apply(attLsValue));
		
		System.out.println();
		System.out.println("| The sum value of the list is : " + sum.apply(attLsValue));
		
		System.out.println();
		System.out.println("| The average value of the list is : " + avg.apply(attLsValue));
		
		// ask for the value to count
		System.out.println();
		System.out.print("| Select a value to be counted in the value list: ");
		String cntVal = scan.nextLine();
		
		cntVal = cntVal.split(" ")[0];		
		double cntDouble = Double.parseDouble(cntVal);
		
		// show count result
		System.out.println();
		System.out.println("| The number of '" + cntDouble  +"' in the list is : " + counter(cntDouble).apply(attLsValue));
		
	}
	
	/**
	 * Method: counter
	 * Objective: count number of value in the value list
	 * @param value
	 * @return ArrayProcessor: cntr
	 */
	public static ArrayProcessor counter( double value ) {
		ArrayProcessor cntr = (attLsValue) -> {
			double cntVal = 0;
			
			for(double val: attLsValue) {
				if (val == value) { cntVal++;}
			}
			
			return cntVal;
		};
		
		return cntr;		
	}

}
