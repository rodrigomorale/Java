/**********************************************
Workshop 1
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: January, 31st 2021
**********************************************/

/**
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.ws01.pivot;

public class Pivot {
	
	public static void main(String[] args) {	
		// print program header
		Printer.printProgramHeader();
		boolean programEnd = false;
		
		do {
			// get entry list
			int[] entryList = Printer.getEntryList();
			int[] pivotList = checkPivotSize(entryList);
		
			// check pivot size
			if (pivotList != null) {
				int pivotValue = pivotList[0];
				int[] rearrPivotList = rearrangePivot(pivotList, pivotValue);
				Printer.printResult(rearrPivotList);
				programEnd = true;
			} else {
				System.out.println("Sorry, but your list don't match with list size value (" + entryList[0] + ").");
				System.out.println("Run the program again!");
				programEnd = true;
			}
		} while (!programEnd);
		
		// print end of program
		System.out.println("");
		System.out.println("*-----------------------------------------------------------*");
		System.out.println("***             PROGRAM END                               ***");
		System.out.println("*-----------------------------------------------------------*");
	}
	
	
	public static int[] checkPivotSize(int[] entryList) {
		/**
		 * Method checkPivotSize:
		 * Parameters: entryList: int[] type;
		 * Objective: check if the pivot length match with pivot value.
		 * Return values: pivotList with values: matched;
		 *                pivotList with null value: not matched.
		 */
		int[] pivotList = new int[(entryList.length - 1)];
		
		if (entryList[0] == (entryList.length -1)) {
			for (int i = 0; i < pivotList.length; i++) {
				pivotList[i] = entryList[i+1];
			}
		} else {
			pivotList = null;
		}
		return pivotList;
	}
	
	
	public static int[] rearrangePivot(int[] pivot, int pivotValue) {
		/**
		 * Method rearrengePivot:
		 * Parameters: pivot: int[] type;
		 *             pivotValue: int type.
		 * Objective: rearrenge pivot list based on pivotValue.
		 * Return values: return a rearrenged pivot list.
		 */
		int cntLess = 0;
		int cntMore = 0;
		int cntEqual = 0;
		int[] rearrPivot = new int[pivot.length];

		
		// find size of less value list
		for(int item: pivot) {
			if (item <= pivotValue) {
				if (item == pivotValue) {
					cntEqual++;
				} else {
					cntLess++;
				}
			} else {
				cntMore++;
			}
			
		}
		
		// check total items
		if ((cntLess + cntMore + cntEqual) == pivot.length) {
		
			// create less and more list
			int[] lessList = new int[cntLess];
			int[] equalList = new int[cntEqual];
			int[] moreList = new int[cntMore];
		
			// fill lists
			int l = 0;
			int e = 0;
			int m = 0;
			for (int i = 0; (i < pivot.length) && (cntLess >= l) && (cntMore >= m) && (cntEqual >= e); i++) {
				if (pivot[i] <= pivotValue) {
					if (pivot[i] == pivotValue) {
						equalList[e] = pivot[i];
						e++;
					} else {
						lessList[l] = pivot[i];
						l++;
					}
				} else {
					moreList[m] = pivot[i];
					m++;
				}
			}
		
			// join lists
			e = 0;
			m = 0;
			for(int i = 0; i < rearrPivot.length; i++) {
				if (i < lessList.length) {				
					rearrPivot[i] = lessList[i];
				} else {
					if (e != cntEqual) {
						rearrPivot[i] = equalList[e];
						e++;
					} else {
						if (m != cntMore) {							
							rearrPivot[i] = moreList[m];
							m++;
						}
					}
				}
			}
		} else {
			System.out.println("Unmatched list sizes!");

			rearrPivot = null;
		}
		
		// return rearrenged list
		return rearrPivot;
	}
}
