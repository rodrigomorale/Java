/**********************************************
Workshop 10
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: April 11, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop10.chatApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class: HandleChatFile
 * Objective: handle chat files
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class HandleChatFile {

	// class attributes	
	private String fileName;
	private RandomAccessFile raf;
				
	/**
	 * Constructor
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public HandleChatFile(String fileName) throws FileNotFoundException {
		super();
		this.fileName = fileName;
		this.raf = new RandomAccessFile(this.fileName, "rw");
	}

	/**
	 * Method: read
	 * Objective: read information from the file from a position on
	 * @param pos
	 * @return String[]: text
	 * @throws IOException
	 */
	public String[] read(int pos) throws IOException {
		String text = "";
			
		// read address
		raf.seek(pos);	
		
		while (raf.getFilePointer() != raf.length()) {
			text += raf.readLine() + "\n";
		}
		return text.split("\n");
	}
		
	/**
	 * Method: write
	 * Objective: wriite a new line in chat file
	 * @param text
	 * @throws IOException
	 */
	public void write(String text) throws IOException {
	    raf.seek(raf.length());	
	    raf.write((text + "\n").getBytes());
	}		
}