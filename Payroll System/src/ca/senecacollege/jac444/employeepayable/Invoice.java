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
 * Class: Invoice
 * Objective: implement interface Payable
 * @author Rodrigo Canella Garcia Morale
 */

package ca.senecacollege.jac444.employeepayable;

public class Invoice implements Payable {

	// Attributes
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	/**
	 * Constructor
	 * @param partNumber
	 * @param partDescription
	 * @param quantity
	 * @param pricePerItem
	 */
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		super();
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}

	// Getters / Setters
	
	/**
	 * Method: getPartNumber
	 * Objective: return part number
	 * @return String: part number
	 */
	public String getPartNumber() {
		return partNumber;
	}


	/**
	 * Method: setPartNumber
	 * Objective: set part number
	 * @param partNumber
	 */
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}


	/**
	 * Method: getPartDescription
	 * Objective: return part description
	 * @return String: part description
	 */
	public String getPartDescription() {
		return partDescription;
	}


	/**
	 * Method: setPartDescription
	 * Objective: set part description
	 * @param partDescription
	 */
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}


	/**
	 * Method: getQuantity
	 * Objective: return quantity value
	 * @return int: quantity value
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * Method: setQuantity
	 * Objective: set quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * Method: getPricePerItem
	 * Objective: return price per item value
	 * @return double: price per item value
	 */
	public double getPricePerItem() {
		return pricePerItem;
	}


	/**
	 * Method: setPricePerItem
	 * Objective: set price per item value
	 * @param pricePerItem
	 */
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}


	/**
	 * Method: getPaymentAmount
	 * Objective: return the amount the amount of payment of this invoice
	 * Parameters: none
	 * Return: double: invoice amount
	 */
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getQuantity() * getPricePerItem();
	}

	/**
	 * Method: toString
	 * Objective: return a string with the object features
	 * @return String: object features
	 */
	@Override
	public String toString() {
		return "Invoice [partNumber=" + getPartNumber() + 
					  ", partDescription=" + getPartDescription() + 
					  ", quantity=" + getQuantity() + 
					  ", pricePerItem=" + getPricePerItem() + 
					  ", getPaymentAmount()=" + getPaymentAmount() + "]";
	}	
}
