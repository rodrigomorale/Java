/**********************************************
Workshop 5
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 02, 2021
**********************************************/

package ca.senecacollege.jac433.workshop07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class: ReadData
 * Objective: read and write informations from the file
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class ReadData {
	
	// class attributes
	
	// file name and its creation
	private String fileName;
	private RandomAccessFile raf;
	
	// create a list of addresses
	private Person [] addressBook;
	
	// file positions to find each field information
	private final long fNamePos = 12;
	private final long lNamePos = 12;
	private final long cityPos = 7;
	private final long provincePos = 11;
	private final long postalCodePos = 14;
	private final long lineSize = fNamePos + 
			                      lNamePos +
			                      cityPos  +
			                      provincePos +
			                      postalCodePos + 134;
	
	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public ReadData(String fileName) throws FileNotFoundException {
		super();
		this.fileName = fileName;
		this.addressBook = null;
		this.raf = new RandomAccessFile(this.fileName, "rw");
	}

	/**
	 * Method: start
	 * Objective: start file if it does not exist
	 * @return boolean: true / false
	 */
	public boolean start() {
		boolean success = true;
		
		// create a list of 5 person
		addressBook = new Person[5];
		addressBook[0] = new Person("Toronto", "ON", "M4P0P8", "Rodrigo", "Morale");
		addressBook[1] = new Person("Montreal", "QC", "H1Y3A4", "Jean", "Pierre");
		addressBook[2] = new Person("Vancouver", "BC", "V6R1N8", "Bill", "Smith");
		addressBook[3] = new Person("Halifax", "NS", "B3N3H5", "David", "Jones");
		addressBook[4] = new Person("Charlottetown", "PE", "C1A2C6", "Ana", "Almeida");
		
		// Filled file informations
		// it will replace the first 5 address with the file already exists
		try {
		    for(int i = 0; i < addressBook.length; i++) {
			    if(!writeAddress(addressBook[i], "CURRENT")) { 
			    	throw new IOException("Error to write address of" + addressBook[i].getfName() + 
			    			              " " + addressBook[i].getlName() + " in the file");
			    } 
		    }
		} catch (IOException e) {
			System.out.println(e);
			success = false;
		}
		
		return success;
 	}

	/**
	 * Method: read
	 * Objective: read data from the file and return as a Person object
	 * @return Person: address
	 */
	public Person read() {
		
		// declare variables
		Person address;
		byte[] byteFName = new byte[50];
		byte[] byteLName = new byte[50];
		byte[] byteCity = new byte[25];
		byte[] byteProvince = new byte[2];
		byte[] bytePostalCode = new byte[6];
		byte[] newLine = new byte[1];
		
		
		try {
		// if it is the end of file move position to the beginning of the last address	
		if (raf.getFilePointer() >= raf.length()) {
			raf.seek(raf.length() - lineSize);
		}
		
		// read address
		raf.seek(raf.getFilePointer() + fNamePos);	
		raf.read(byteFName);
		String sFName = new String(byteFName);
		
		raf.seek(raf.getFilePointer() + lNamePos);	
		raf.read(byteLName);
		String sLName = new String(byteLName);
		
		raf.seek(raf.getFilePointer() + cityPos);	
		raf.read(byteCity);
		String sCity = new String(byteCity);
		
		raf.seek(raf.getFilePointer() + provincePos);	
		raf.read(byteProvince);
		String sProvince = new String(byteProvince);
		
		raf.seek(raf.getFilePointer() + postalCodePos);	
		raf.read(bytePostalCode);
		String sPostalCode = new String(bytePostalCode);
		
		// read new line \n
		raf.read(newLine);
		
		// store informations in a new Person object
		address = new Person(sCity, sProvince, sPostalCode, sFName, sLName);
		
		} catch (IOException e) {
			System.out.println("Error when try to read address: " + e);
			address = null;
		} catch (Exception e) {
			System.out.println("Error when try to read address: " + e);
			address = null;
		}
		
		return address;
	}
	
	/**
	 * Method: readFirst
	 * Objective: read the first address of the file
	 * @return Person: address
	 */
	public Person readFirst() {
		Person address;
		
		try {
			// move position to the beginning of the file and read
			raf.seek(0);
			address = read();
		} catch (IOException e) {
			System.out.println("Error when try to read first address: " + e);
			address = null;
		}

		return address;
	}
	
	/**
	 * Method: readLast
	 * Objective: read the last address of the file
	 * @return Person: address
	 */
	public Person readLast() {
		Person address;
		
		try {
			// move position to the start of the last line of the file and read it
			raf.seek(raf.length() - lineSize);
			address = read();
		} catch (IOException e) {
			System.out.println("Error when try to read last address: " + e);
			address = null;
		}

		return address;
	}
	
	/**
	 * Method: readPrevious
	 * Objective: read the previous address
	 * @return Person: address
	 */
	public Person readPrevious() {
		Person address;
		
		try {
			// if it is the first addres, move to the beginning of the file
			long prevPos = raf.getFilePointer() - (lineSize * 2);
			if (prevPos < 0) { prevPos = 0;}
			
			// move position to the beginning of the previous address and read
			raf.seek(prevPos);
			address = read();
		} catch (IOException e) {
			System.out.println("Error when try to read previous address: " + e);
			address = null;
		}

		return address;
	}
	

	/**
	 * Method: writeAddress
	 * Objective: write an address in the file, the position is define by the parameter filePos:
	 *            "BEGIN": start of the file
	 *            "CURRENT": current position of the file
	 *            "MIDDLE": return to the beginning of the current address
	 *            "END": end of the file
	 * @param address
	 * @param filePos
	 * @return boolean: true / false
	 */
	public boolean writeAddress(Person address, String filePos) {
		boolean writed = true;
		long pos;
		
		try {
			
			// define the position according to filePos
			switch (filePos) {
			case "CURRENT" :
				pos = raf.getFilePointer();
				break;
			case "BEGIN" :
				pos = 0;
				break;
			case "MIDDLE" :
				pos = raf.getFilePointer() - lineSize;
				break;
			case "END" :
				pos = raf.length();
				break;
			default:
				throw new IOException("Invalid file position");	
			}
			
			// move to selected position and write 
		    raf.seek(pos);
		    
		    raf.write("first name: ".getBytes());
		    raf.write(address.getfName().getBytes());
		    raf.write(" ".getBytes());
		    
		    raf.write("last name: ".getBytes());
		    raf.write(address.getlName().getBytes());
		    raf.write(" ".getBytes());
		    
		    raf.write("city: ".getBytes());
		    raf.write(address.getCity().getBytes());
		    raf.write(" ".getBytes());
		    
		    raf.write("province: ".getBytes());
		    raf.write(address.getProvince().getBytes());
		    raf.write(" ".getBytes());
		    
		    raf.write("postal code: ".getBytes());
		    raf.write(address.getPostalCode().getBytes());
		    
		    raf.write("\n".getBytes());
		    
		} catch (IOException e) {
			writed = false;
		}

		return writed;
	}
	
	/**
	 * Method: updateAddress
	 * Objective: update address information
	 * @param address
	 * @return boolean: true / false
	 */
	public boolean updateAddress(Person address) {
		boolean updated = true;
		
		try {
			// move position to the beginning fo the current line and write
			if (!writeAddress(address, "MIDDLE")) {
				throw new IOException("Error when try to update " + address.getfName() + 
						               " " + address.getlName() + " address.");
			}
		} catch (IOException e) {
			System.out.println("Error when try to read previous address: " + e);
			address = null;
		}

		return updated;
	}
}
