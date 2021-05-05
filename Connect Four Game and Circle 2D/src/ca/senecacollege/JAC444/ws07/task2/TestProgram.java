/**********************************************
Workshop 7
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 21, 2021
**********************************************/

package ca.senecacollege.JAC444.ws07.task2;

/**
 * Class: TestProgram
 * Objective: this class test the Circle2D class
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class TestProgram {

	public static void main(String[] args) {
		
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 7");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: March 21, 2021");
		System.out.println("**********************************************/");
		System.out.println("|=============================================|");
		System.out.println("|         Test Program                        |");
		System.out.println("|=============================================|");
		
		/*
		 * Write a test program that creates a Circle2D object c1 (new Circle2D(2, 2, 5.5)),
		 */
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		System.out.println("| Circle c1 with x = 2, y = 2 and radius 5.5 created!");
		
		/*
		 * displays its area and perimeter,
		 */
		System.out.println("|");
		System.out.println("| The area of the circle is " + c1.getArea());
		System.out.println("| The perimeter of the circle is " + c1.getPerimeter());
		
		/*
		 * result of c1.contains(3,3)
		 */
		System.out.println("|");
		System.out.println("| The result of c1.contains(3,3) is " + c1.contains(3, 3));
		
		/*
		 * result of c1.contains(new Circle2D(4, 5, 10.5))
		 */
		System.out.println("|");
		System.out.println("| The result of c1.contains(new Circle2D(4, 5, 10.5)) is " + c1.contains(new Circle2D(4, 5, 10.5)));
		
		/*
		 * result of c1.overlaps(new Circle2D(3, 5, 2.3))
		 */
		System.out.println("|");
		System.out.println("| The result of c1.overlaps(new Circle2D(3, 5, 2.3)) is " + c1.overlaps(new Circle2D(3, 5, 2.3)));
	}
}
