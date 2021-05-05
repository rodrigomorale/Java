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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ca.senecacollege.JAC444.workshop10.chatApp.Server.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Class: Client
 * Objective: client program to chat
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Client extends Application  {
	
	// class attributes
	private static String name;
	private static String message;
	
	private TextArea messArea = new TextArea();
	private TextField chatInput = new TextField();
	
	private static BufferedReader input;
	private static PrintWriter output;

	/**
	 * Method: main
	 * Objective: launch window
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	/**
	 * Constructor
	 */
	public Client() {
		super();
		// connect to server localhost port 5000
		name = "";
		message = "";
	}


	/**
	 * Method: start
	 * Objective: override Application method to start stage
	 */
	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		
		// start text area text
		messArea.setPrefHeight(550);
		message = "Enter your name...";
		messArea.appendText(message + "\n");
		
		// handle with input at chatInput text field
		chatInput.setOnAction(event->{
			// check if have name, if its not filled and send client name to server
			if (getName() == "") {
				// print message on screen
				message = "Welcome to our chat ";
				message += chatInput.getText();
				
				// sent name
				setName(chatInput.getText());
				
				// set window name
				ps.setTitle(getName());
				
				// send data to server
				output.println(chatInput.getText());
			} else {
				// print message on screen
				message = getName().toUpperCase() + " : ";
				message += chatInput.getText();
				
				// send data to server
				output.println(chatInput.getText());
			}
			// clear text field
			chatInput.clear();
			
			// print message o screen
			messArea.appendText(message + "\n");
		});


		// creat window layout
		VBox root =  new VBox(20, messArea, chatInput);
		root.setPrefSize(600, 600);
		ps.setScene(new Scene(root));
		ps.setResizable(false);
		ps.setTitle("New chat window");
		ps.show();
		
		// listener thread to handle server connection
		Thread listener = new Thread(new Runnable(){
			// override run method from Thread class
			@Override
            public void run(){
				// start connection with server
            	try(Socket socket = new Socket("localhost", 5000)) {
					
        			// create buffers for server input and output
            		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            		output = new PrintWriter(socket.getOutputStream(), true);
        			
            		// loop while we have connection
        			while (true) {
        					
      					// wait until the buffer is read
       					while(!input.ready()) {}
		
       					// loop to read all lines from the buffer
       					do {
       						// if buffer is read
       						if (input.ready()) {
			
      							// read line from the buffer	
       							message = input.readLine();
			
       							// if the text is from the other user, print
       							if (!(message.substring(0, getName().length()).equals(getName().toUpperCase()))) {
       									messArea.appendText(message + "\n");
       							}
       						}
       					} while (input.ready());        		
        			}
            	} catch (Exception err) {
            		System.out.println("Error when try to retrieve chat data: " + err);
            	}
            }
        });
		listener.start();
		
	}
	
	/**
	 * Method: getName
	 * Objective: retrieve name
	 * @return String: name
	 */
	public static String getName() {
		return name;
	}

	/**
	 * Method: setName
	 * Objective: set name value
	 * @param n
	 */
	public static void setName(String n) {
		name = n;
	}

}
