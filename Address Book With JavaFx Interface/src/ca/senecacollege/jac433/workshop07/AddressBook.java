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

import ca.senecacollege.jac433.workshop07.Canada.Province;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Class: AddressBook
 * Objective: this class execute the program
 * @author Rodrigo Canella Garcia Morale
 *
 */

public class AddressBook extends Application {
	
	// attributes and global variables
	
	// filename
	final String fileName = "addressBook.txt";
	
	// form fields
	public TextField fname = new TextField();
	public TextField lname = new TextField();
	public TextField city = new TextField();
	public final ComboBox<String> province = new ComboBox<String>();
	public TextField postalCode = new TextField();
	final String listProvinces = "Select Province";
	
	// message
	public Label message = new Label("");
	
	// classes
	public ReadData read;
	public Person person;
	
	
	/**
	 * Method: main
	 * Objective: launch screen
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
		
	}

	/**
	 * Method: start
	 * Objective: build stage
	 */
	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		
		// declare variables
		read = new ReadData(fileName);
		Canada canada = new Canada();
		Printer printer = new Printer();
		
		// print program header at console
		printer.programHeader();
		
		// start file
		if (read.start()) {
		
		   // create fields
		   GridPane gp = new GridPane();
		   gp.setAlignment(Pos.CENTER);
		   gp.setHgap(20);
		   gp.setVgap(10);
		   
		   // create fields name
		   GridPane gpName = new GridPane();
		   gpName.setAlignment(Pos.CENTER);
		   gpName.setHgap(6);
		   gpName.setVgap(6);
		   
		   // First name
		   gpName.add(new Label("First Name:"), 0, 0);
		   fname.setPrefWidth(500);
		   fname.setPromptText("Enter the first name..");
		   gpName.add(fname, 1, 0);
		   
		   // Last name
		   gpName.add(new Label("Last Name:"), 0, 1);
		   lname.setPrefWidth(500);
		   lname.setPromptText("Enter the last name...");
		   gpName.add(lname, 1, 1);
		   
		   gp.add(gpName, 0, 0);
		   
		   // create fields address
		   GridPane gpAddress = new GridPane();
		   gpAddress.setAlignment(Pos.CENTER);
		   gpAddress.setHgap(6);
		   gpAddress.setVgap(6);
		   
		   // city
		   gpAddress.add(new Label("City:"), 0, 0);
		   city.setPrefWidth(150);
		   city.setPromptText("Enter the city...");
		   gpAddress.add(city, 1, 0);
		   
		   // province
		   Province[] provinces = canada.getProvinces();
		   String[] provincesList = new String[provinces.length + 1];
		   provincesList[0] = listProvinces;
		   for(int i = 0; i < provinces.length; i++) {
		   	provincesList[i+1] = provinces[i].getAbbr();
		   }
		   
		   gpAddress.add(new Label("Province"), 2, 0);
		   province.getItems().addAll(provincesList);
		   province.setValue(listProvinces);
		   province.setPrefWidth(150);
		   gpAddress.add(province, 3, 0);
		   
		   // postal code
		   gpAddress.add(new Label("Postal Code:"), 4, 0);
		   postalCode.setPrefWidth(100);
		   postalCode.setPromptText("Postal Code");
		   gpAddress.add(postalCode, 5, 0);
		   
		   gp.add(gpAddress, 0, 1);
		   
		   
		   // create message label
		   GridPane gpMessage = new GridPane();
		   gpMessage.setAlignment(Pos.CENTER);
		   gpMessage.setHgap(6);
		   gpMessage.setVgap(6);
		   message.setVisible(false);
		   gpMessage.add(message, 0, 0);
		   
		   gp.add(gpMessage, 0, 2);
		   
		   // create fields buttons
		   GridPane gpButtons = new GridPane();
		   gpButtons.setAlignment(Pos.CENTER);
		   gpButtons.setHgap(10);
		   gpButtons.setVgap(6);
		   
		   // create buttons
		   Button btnAdd = new Button("Add");
		   btnAdd.setOnAction(new OnClick());
		   
		   Button btnFirst = new Button("First");
		   btnFirst.setOnAction(new OnClick());
		   
		   Button btnNext = new Button("Next");
		   btnNext.setOnAction(new OnClick());
		   
		   Button btnPrevious = new Button("Previous");
		   btnPrevious.setOnAction(new OnClick());
		   
		   Button btnLast = new Button("Last");
		   btnLast.setOnAction(new OnClick());
		   
		   Button btnUpdate = new Button("Update");
		   btnUpdate.setOnAction(new OnClick());
		   
		   // add buttons to screen
		   gpButtons.add(btnAdd, 1, 3);
		   gpButtons.add(btnFirst, 2, 3);
		   gpButtons.add(btnNext, 3, 3);
		   gpButtons.add(btnPrevious, 4, 3);
		   gpButtons.add(btnLast, 5, 3);
		   gpButtons.add(btnUpdate, 6, 3);
		   
		   gpButtons.getChildrenUnmodifiable();
           
		   gp.add(gpButtons, 0, 3);
		   
		   // Scene creation
		   Scene sc = new Scene(gp, 600, 200);
		   						
		   // Window creation
		   ps.setResizable(false);
		   ps.setTitle("Address Book");
		   ps.setScene(sc);
		   ps.show();
		   
		   // load first address of the file
		   fillfields(read.readFirst());
		   
		} else { System.out.println("Error when try to start file.");}
		
	}
	
	/**
	 * Method: fillfields
	 * Objective: fill fields at form
	 * @param person
	 */
	public void fillfields(Person person) {
		  fname.setText(person.getfName());
		  lname.setText(person.getlName());
		  city.setText(person.getCity());
		  province.setValue(person.getProvince());
		  postalCode.setText(person.getPostalCode());
	}
	
	/**
	 * Inner Class: OnClick
	 * Objective: handle OnClick button actions
	 * @author Rodrigo Canella Garcia Morale
	 *
	 */
	public class OnClick implements EventHandler<ActionEvent>{

		/**
		 * Method: handle
		 * Objective: handle button actions
		 */
		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			
			// get button target
			Button button = (Button)e.getTarget();

			// check if the form is filled
			if (checkForm()) {
				
				// update person object with fields form information
				person = new Person(city.getText(), province.getValue(), postalCode.getText(), fname.getText(), lname.getText());
			
				// execute different actions for each button target
				switch (button.getText()) {
				case "Add": 
					add(person);
					break;
				case "First":
					first();
					break;
				case "Next":
					next();
					break;
				case "Previous":
					previous();
					break;
				case "Last":
					last();
					break;
				case "Update":
					update(person);
					break;
				default:
					System.out.println("Invalid button");
					break;
				}
			} else {
				System.out.println("Fill all fields");
			}
			
		}
		
		/**
		 * Method: checkForm
		 * Objective: check if form fields are filled
		 * @return boolean: true / false
		 */
		public boolean checkForm() {
			boolean formOk = true;
			
			if (fname.getText() == "") { formOk = false;}
			if (lname.getText() == "") { formOk = false;}
			if (city.getText() == "") { formOk = false;}
			if (province.getValue() == listProvinces) { formOk = false;}
			if (postalCode.getText() == "") { formOk = false;}

			return formOk;
		}
		
		/**
		 * Method: add
		 * Objective: handle add button
		 * @param person
		 */
		public void add(Person person) {
			if (read.writeAddress(person, "END")) {
				message.setText("Address added with success!");
				message.setVisible(true);
			} else {
				System.out.println("Error when try to add " + person.getfName() + " " + person.getlName() + " address!");
			}
		}

		/**
		 * Method: first
		 * Objective: handle first button
		 */
		public void first() {
			message.setText("");
			message.setVisible(false);
			
			fillfields(read.readFirst());
		}
		
		/**
		 * Method: next
		 * Objective: handle next button
		 */
		public void next() {
			message.setText("");
			message.setVisible(false);
			
			fillfields(read.read());
		}
		
		/**
		 * Method: previous
		 * Objective: handle previous button
		 */
		public void previous() {
			message.setText("");
			message.setVisible(false);
			
			fillfields(read.readPrevious());
		}
		
		/**
		 * Method: last
		 * Objective: handle last button
		 */
		public void last() {
			message.setText("");
			message.setVisible(false);
			
			fillfields(read.readLast());
		}
		
		/**
		 * Method: update
		 * Objective: handle update button
		 * @param person
		 */
		public void update(Person person) {
			if (read.updateAddress(person)) {
				message.setText("Address updated with success!");
				message.setVisible(true);
			} else {
				System.out.println("Error when try to update " + person.getfName() + " " + person.getlName() + " address!");
			}
		}
	}
	
}
