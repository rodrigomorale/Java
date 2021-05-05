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
 * Class: Circle2D
 * Objective: holds information and methods for circle 2d
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Circle2D {
	
	// class attributes
	
	/*
	 * Two double data fields named x and y that specify the center of the circle with getter methods.
	 */
	private double x;
	private double y;
	
	/*
	 * A data field radius with a getter method.
	 */
	private double radius;

	/*
	 * A no-arg constructor that creates a default circle with (0, 0) for (x, y) and 1 for radius.
	 */
	
	/**
	 * Default Constructor
	 */
	public Circle2D() {
		super();
		this.x = 0;
		this.y = 0;
		this.radius = 1;	
	}
	
	/*
	 * A constructor that creates a circle with the specified x, y, and radius.
	 */
	
	/**
	 * Constructor with parameters
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle2D(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	/**
	 * Method: getArea
	 * Objective: A method getArea() that returns the area of the circle.
	 * @return double: area
	 */
	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}
	
	/**
	 * Method: getPerimeter
	 * Objective: A method getPerimeter() that returns the perimeter of the circle.
	 * @return double: perimeter
	 */
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	/**
	 * Method: contains
	 * Objective: A method contains(double x, double y) that returns true if the specified point (x, y) is inside this circle (Figure - a).
	 * @param x
	 * @param y
	 * @return boolean: true / false
	 */
	public boolean contains(double x, double y) {
		return ((x - getX()) * (x - getX()))  + ((y - getY()) * (y - getY())) == getRadius() * getRadius();
	}
	
	/**
	 * Method: contains
	 * Objective: A method contains(Circle2D circle) that returns true if the specified circle is inside this circle (Figure b).
	 * @param circle
	 * @return boolean: true / false
	 */
	public boolean contains(Circle2D circle) {
		double distance = Math.sqrt(((circle.getX() - getX()) * ((circle.getX() - getX()))) + 
				          ((circle.getY() - getY()) * ((circle.getY() - getY()))));
		return (getRadius() >= (distance + circle.getRadius())); 
	}
	
	/**
	 * Method: overlaps
	 * Objective: A method overlaps(Circle2D circle) that returns true if the specified circle overlaps with this circle (Figure c).
	 * @param circle
	 * @return boolean: true / false
	 */
	public boolean overlaps(Circle2D circle) {
		double distance = (((circle.getX() - getX()) * ((circle.getX() - getX()))) + 
		          ((circle.getY() - getY()) * ((circle.getY() - getY()))));
		
		double radiusSum = (circle.getRadius() + getRadius()) * (circle.getRadius() + getRadius());
		
		return (distance <= radiusSum);
	}
	
	/**
	 * Method: getX
	 * Objective: return the value of x
	 * @return double: x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Method: getY
	 * Objective: return the value of y
	 * @return double: y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Method: getRadius
	 * Objective: return the value of radius
	 * @return double: radius
	 */
	public double getRadius() {
		return radius;
	}

}
