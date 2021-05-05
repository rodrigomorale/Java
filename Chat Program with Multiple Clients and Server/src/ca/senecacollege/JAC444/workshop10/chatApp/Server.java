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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class: Server
 * Objective: server program that handle multi threads
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Server  extends Application {
	
	// class attributes
	private static TextArea messArea = new TextArea();
	private static String message = "";
	private static String fileName;
	final private String dash = "----------------------------------------------\n";
	
	/**
	 * Constructor
	 */
	public Server() {
		super();
		// TODO Auto-generated constructor stub
		// create a new file name for every execution
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		fileName = timestamp.toString().substring(0, 10) + "-" +
		           timestamp.toString().substring(12, 13) + 
		           timestamp.toString().substring(15, 16) +
		           timestamp.toString().substring(18, 19) + ".txt";
	}

	/**
	 * Method: main
	 * Objective: launch stage
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		launch(args);
	}

	/**
	 * Method: override start method from Application
	 * Objective: start stage windown
	 */
	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		
		// Window design and creation	
		messArea.setPrefHeight(600);
		VBox root =  new VBox(20, messArea);
		root.setPrefSize(600, 600);
		ps.setScene(new Scene(root));
		ps.setResizable(false);
		ps.setTitle("Multi-Threaded Server");
		ps.show();
		
		// thread to handle with multiple treads
		Thread listener = new Thread(new Runnable(){
            public void run(){
            	// ready to connect clients
        		try(ServerSocket serverSocket = new ServerSocket(5000)) {
        				
        			// execute this loop while the program not ended
        			while (true) {
        				// create new thread for each client connection
        				new User(serverSocket.accept(), fileName).start();
        				
        				// print information on console
        				System.out.println(dash);
        				System.out.println("New client connected...");
        				
        				// print information on screen
        				messArea.appendText(dash);
        				message = "New client connected...";
        				messArea.appendText(message + "\n");
        			}
        		} catch (Exception err) {
        			System.out.println("Erro when try to connect to a new client...");
        		}
            }
        });
		listener.start();
		
	}
	
	/**
	 * Class: User (Inner class)
	 * Objective: handle multiple users using multi threads
	 * @author Rodrigo Canella Garcia Morale
	 *
	 */
	public class User extends Thread {
		
		// classs attributes
		private String userName;
		public HandleChatFile handleFile;
		private Socket socket;
		private int pos;

		/**
		 * Constructor
		 * @param socket
		 * @param filename
		 * @throws FileNotFoundException
		 */
		public User(Socket socket, String filename) throws FileNotFoundException {
			this.socket = socket;
			this.handleFile = new HandleChatFile(filename);
			this.pos = 0;
		}
		
		/**
		 * Method: override run method from Thread to run it
		 */
		@Override
		public void run() {
			

				// wraps in the bufferedReader (This is the input from client)
			try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// use printWriter to send output to the client
				PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
				
				String[] text;
				// read user name
				String data = input.readLine();
				setUserName(data);
	
				message = "User " + getUserName() + " added to chat...";
				
				// print message on console
				System.out.println(message);
				System.out.println(dash);
				
				// print message on screen
				messArea.appendText(message + "\n");
				messArea.appendText(dash);
				
				// loop while it is connected
				while (true) {
					// read client input
					data = input.readLine();
					
					// format data and print on console and screen
					message = getUserName().toUpperCase() + " : " + data;
					System.out.println(message);
    				messArea.appendText(message + "\n");
    				
    				// write data in file
    				handleFile.write(getUserName().toUpperCase() + " : " + data);
    				
    				// read data from file and send to client
					text = handleFile.read(pos);
					for (String line: text) {
						pos += line.length() + 1;
						output.println(line);
					}
					
					// if read null from clint, close connection
					if (data == null) { 
						message = "User " + getUserName() + " leaved chat...";
						System.out.println(dash);
						System.out.println(message);
						System.out.println(dash);
						messArea.appendText(dash);
						messArea.appendText(message + "\n");
						messArea.appendText(dash);
						break;
					}
				}
			} catch (Exception err) {
				System.out.println("Error when try tp retrieve client data: " + err);
			}
			
		}

		/**
		 * Method: getUserName
		 * Objective: retrieve user name
		 * @return String: userName
		 */
		public String getUserName() {
			return userName;
		}

		/**
		 * Method: setUserName
		 * Objective: set user name
		 * @param userName
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
	}
}
