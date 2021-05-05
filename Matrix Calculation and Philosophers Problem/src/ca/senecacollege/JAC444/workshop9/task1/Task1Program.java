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
 * Class: Task1Program
 * Objective: Execute the main method of task 1 program
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Task1Program {

	/**
	 * Method: main
	 * Objective: Execute task 1 program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// print header
		System.out.println("/**********************************************");
		System.out.println("Workshop 9");
		System.out.println("Course: JAC 444 - Semester 4");
		System.out.println("Last Name: Canella Garcia Morale");
		System.out.println("First Name: Rodrigo");
		System.out.println("ID: 135297190");
		System.out.println("Section: NEE");
		System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
		System.out.println("Signature");
		System.out.println("Date: April 02, 2021");
		System.out.println("**********************************************/");
		System.out.println("|=============================================|");
		System.out.println("|         Task 1 - Matrix Calculation         |");
		System.out.println("|=============================================|");
		
		// create matrixes randomly
		int size = 2000;
		double[][] matrixA = new double[size][size];
		double[][] matrixB = new double[size][size];
		
		// fill matrixes
		for(int x = 0; x < size; x ++) {
			for (int y = 0; y < size; y++) {
				matrixA[x][y] = (Math.random() * 100);
				matrixB[x][y] = (Math.random() * 100);
				
			}
		}
		
		// print matrixes
		//System.out.println("| Original matrixes values: ");
		//System.out.println("|---------------------------------------------|");
		//System.out.println("| Matrix A values: ");
		//System.out.print("| ");
		//printMatrix(matrixA);
		//System.out.println("|");
		//System.out.println("|");
		
		// print matrixes
		//System.out.println("| Matrix B values: ");
		//System.out.print("| ");
		//printMatrix(matrixB);
		//System.out.println("|");
		//System.out.println("|");
		
		System.out.println("|=============================================|");
		System.out.println("| Generation result matrixes:                 |");
		System.out.println("|---------------------------------------------|");
		System.out.println("|");
		double[][] seqMultMatrix = sequentialMultiplyMatrix(matrixA, matrixB);
		System.out.println("|");
		double[][] parMultMatrix = parallelMultiplyMatrix(matrixA, matrixB);
		System.out.println("|");
		
		// print matrixes
		//System.out.println("|=============================================|");
		//System.out.println("| Results of the mutiplications:              |");
		//System.out.println("|---------------------------------------------|");
		//System.out.println("|");
		//System.out.println("| Matrix result of sequential multiplication values: ");
		//System.out.print("| ");
		//printMatrix(seqMultMatrix);
		//System.out.println("|");
		//System.out.println("|");
		
		
		// print matrixes
		//System.out.println("|");
		//System.out.println("| Matrix result of parallel multiplication values: ");
		//System.out.print("| ");
		//printMatrix(parMultMatrix);
		//System.out.println("|");
		//System.out.println("|");
		
		
		System.out.println("|=============================================|");
		System.out.println("| Generation result fo addition matrix:       |");
		System.out.println("|---------------------------------------------|");
		System.out.println("|");
		double[][] seqAddMatrix = sequentialAdditionMatrix(matrixA, matrixB);
		System.out.println("|");
		
		// print matrixes
		//System.out.println("|=============================================|");
		//System.out.println("| Results of the addition:                    |");
		//System.out.println("|---------------------------------------------|");
		//System.out.println("|");
		//System.out.println("| Matrix result of sequential addition values: ");
		//System.out.print("| ");
		//printMatrix(seqAddMatrix);
		//System.out.println("|");
		//System.out.println("|");
		
		// print final message
		System.out.println("|=============================================|");
		System.out.println("|         Program - Finished                  |");
		System.out.println("|=============================================|");

	}
	
	/**
	 * Method: sequentialMultiplyMatrix
	 * Objective: multiply sequentially two matrixes
	 * @param a
	 * @param b
	 * @return double[][]: result
	 */
	public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b) {
		// start timer
		long startTime = System.nanoTime();
			
		// define column size
		int columnSize = (a.length >= b.length) ? a.length : b.length;
		int rowSize = (a[0].length >= b[0].length) ? a[0].length : b[0].length;
				
		// create the result matrix with the size of the bigger matrix 
		double[][] result = new double[columnSize][rowSize];
				
		for(int x = 0; x < result.length; x++ ) {
			for(int y = 0; y <result[0].length; y++) {
				// set zero if the range is outside the size of the matrix
				double cValue = (a.length >= x) && (a[0].length >= y) ? a[x][y] : 0;
				double dValue = (b.length >= x) && (b[0].length >= y) ? b[x][y] : 0;
						
				result[x][y] = cValue * dValue;
			}
		}
				
		// finish timer
		long endTime = System.nanoTime();	 
        long timeElapsed = endTime - startTime;
		        
        // print timeElapsed
        System.out.println("| The elapsed time to compute matrix result using sequencial method is " + timeElapsed + " nanoseconds.");
				
		return result;
	}
	
	/**
	 * Method: parallelMultiplyMatrix
	 * Objective: multiply in parallel way two matrixes, using threads
	 * @param a
	 * @param b
	 * @return double[][]: result
	 */
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
		// start timer
		long startTime = System.nanoTime();
		
		// define column size
		int columnSize = (a.length >= b.length) ? a.length : b.length;
		int rowSize = (a[0].length >= b[0].length) ? a[0].length : b[0].length;

		// declare variables
		int columnStart = 0;
		int columnIncrement = (columnSize / 4);
		int rowIncrement = (rowSize / 4);
		int columnEnd = 0;
		
		// create the result matrix with the size of the bigger matrix 
		double[][] result = new double[columnSize][rowSize];
		
		Runnable[] matrixTasks = new PartialMatrix[4];
		Thread[] matrixThreads = new Thread[4];
		
		// split matrix multiplication
		for(int i = 0; i < 4; i++) {
			// compute column row start and end
			columnStart = columnEnd;
			columnEnd = ((columnStart + columnIncrement) <= columnSize) ? columnStart + columnIncrement : columnSize;
			matrixTasks[i] = new PartialMatrix(a, b, columnStart, columnEnd, rowSize);		
			matrixThreads[i] = new Thread(matrixTasks[i]);
		} 
		
		// start all threads
		for(Thread threads: matrixThreads) { threads.start(); }
		
		// wait until all threads finished before continue
		try { for(Thread threads: matrixThreads) { threads.join(); } } 
		catch (Exception ex) { System.out.println("Error when try to join all threads: " + ex); }
		
		for(Runnable matrix: matrixTasks) {
			columnStart = ((PartialMatrix)matrix).getColumnStart();
			columnEnd = ((PartialMatrix)matrix).getColumnEnd();
			double[][] partialResult = ((PartialMatrix)matrix).getMatrixResult();
			for (int x = 0; x < partialResult.length; x++) {
				for (int y = 0; y < partialResult[0].length; y++) {
					result[x + columnStart][y] = partialResult[x][y];
				}
			}
		}
		
		// finish timer
		long endTime = System.nanoTime();	 
        long timeElapsed = endTime - startTime;
        
        // print timeElapsed
        System.out.println("| The elapsed time to compute matrix result using parallel method is " + timeElapsed + " nanoseconds.");
		
		return result;
	}
	
	/**
	 * Method: sequentialAdditionMatrix
	 * Objective: compute and addition of two matrixes sequentially
	 * @param c
	 * @param d
	 * @return double[][]: result
	 */
	public static double[][] sequentialAdditionMatrix(double[][] c, double[][] d) {
		// start timer
		long startTime = System.nanoTime();
		
		// define column size
		int columnSize = (c.length >= d.length) ? c.length : d.length;
		int rowSize = (c[0].length >= d[0].length) ? c[0].length : d[0].length;
		
		// create the result matrix with the size of the bigger matrix 
		double[][] result = new double[columnSize][rowSize];
		
		for(int x = 0; x < result.length; x++ ) {
			for(int y = 0; y <result[0].length; y++) {
				// set zero if the range is outside the size of the matrix
				double cValue = (c.length >= x) && (c[0].length >= y) ? c[x][y] : 0;
				double dValue = (d.length >= x) && (d[0].length >= y) ? d[x][y] : 0;
				
				result[x][y] = cValue + dValue;
			}
		}
		
		// finish timer
		long endTime = System.nanoTime();	 
        long timeElapsed = endTime - startTime;
        
        // print timeElapsed
        System.out.println("| The elapsed time to compute the sum of matrixes using sequential method is " + timeElapsed + " nanoseconds.");
		
		return result;
	}
	
	/**
	 * Method: printMatrix
	 * Objective: print matrix items.
	 *            this method was not used because the size of the matrix break the program
	 * @param matrix
	 */
	public static void printMatrix(double[][] matrix) {
		int cnt = 0;
		for(int x = 0; x < matrix.length; x ++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.print("[" + x + "][" + y + "] = " + matrix[x][y]); 			
				cnt++;
				if (cnt % 100 == 0) { System.out.print("\n| ");}
				else { System.out.print(", "); }
			}
		}
	}
	
}
