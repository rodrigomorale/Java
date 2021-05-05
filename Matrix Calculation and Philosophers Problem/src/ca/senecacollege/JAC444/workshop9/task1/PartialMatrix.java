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

package ca.senecacollege.JAC444.workshop9.task1;

/**
 * Class: PartialMatrix
 * Objective: class that implement Runnable to create tasks 
 *            to use in the threads 
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class PartialMatrix implements Runnable{

	// class attributes
	private double [][] matrixResult;
	private double [][] matrixA;
	private double [][] matrixB;
	private int columnStart;
	private int columnEnd;
	private int rowSize;
	
	/**
	 * Constructor
	 * @param matrixA
	 * @param matrixB
	 * @param columnStart
	 * @param columnEnd
	 * @param rowSize
	 */
	public PartialMatrix(double[][] matrixA, double[][] matrixB, int columnStart, int columnEnd, int rowSize) {
		super();
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.columnStart = columnStart;
		this.columnEnd = columnEnd;
		this.rowSize = rowSize;
		this.matrixResult = new double[columnEnd - columnStart][rowSize];
	}

	/**
	 * Method: run
	 * Objective: overrided method from parent class Runnable 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// execute the calculations
		for(int x = columnStart; x < columnEnd; x++ ) {
			for(int y = 0; y < rowSize; y++) {
				// set zero if the range is outside the size of the matrix
				double cValue = (matrixA.length >= x) && (matrixA[0].length >= y) ? matrixA[x][y] : 0;
				double dValue = (matrixB.length >= x) && (matrixB[0].length >= y) ? matrixB[x][y] : 0;
				
				matrixResult[x - columnStart][y] = cValue * dValue;
			}
		}
	}

	/**
	 * Method: getMatrixResult
	 * Objective: return a result matrix of the multiplication
	 * @return double[][]: matrixResult
	 */
	public double[][] getMatrixResult() {
		return matrixResult;
	}

	/**
	 * Method: getColumnStart
	 * Objective: get columnStart value
	 * @return int: columnStart
	 */
	public int getColumnStart() {
		return columnStart;
	}

	/**
	 * Method: getColumnEnd
	 * Objective: get columnEnd value
	 * @return int: columnEnd
	 */
	public int getColumnEnd() {
		return columnEnd;
	}

	/**
	 * Method: getRowSize
	 * Objective: get row size value
	 * @return int: rowSize
	 */
	public int getRowSize() {
		return rowSize;
	}
}
