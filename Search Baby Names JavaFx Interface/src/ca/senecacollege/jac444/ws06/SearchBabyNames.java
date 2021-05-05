/**********************************************
Workshop 6
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 15, 2021
**********************************************/

package ca.senecacollege.jac444.ws06;

import java.util.regex.Pattern;

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

public class SearchBabyNames extends Application {
	
	// class attributes
	
	// form fields
	public TextField yearField = new TextField();
	public TextField nameField = new TextField();
	public final ComboBox<String> genderCombo = new ComboBox<String>();
	final String selectGender = "Select Gender";
	
	// labels
	public Label message = new Label("");
	public Label result = new Label("");
	final String yearLabel = "Enter the Year:";
	final String genderLabel = "Enter the Gender:";
	final String nameLabel = "Enter the Name:";
	
	// buttons
	final String yesButton = "Yes";
	final String noButton = "No";
	final String submitButton = "Submit Query";
	final String exitButton = "Exit";
	
	// scenes
	Scene scSearch;
	Scene scResult;
	
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
	 * Objective: start stage. Override from Application class
	 */
	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		
		// create Search stage
		setScSearch(ps);
		
		// create Result stage
		setScResult(ps);
								
		// Window creation
		ps.setResizable(false);
		ps.setTitle("Search Name Ranking Application");
		ps.setScene(getScSearch());
		ps.show();

	}
	
	/**
	 * Method: getScSearch
	 * Objective: get Search scene
	 * @return Scene: scSearch
	 */
	public Scene getScSearch() {
		return scSearch;
	}

	/**
	 * Method: setScSearch
	 * Objective: set and create the search scene
	 * @param ps
	 */
	public void setScSearch(Stage ps) {
	   // create Search grid
	   GridPane gpSearch = new GridPane();
	   gpSearch.setAlignment(Pos.CENTER);
	   gpSearch.setHgap(20);
	   gpSearch.setVgap(10);
	   
	   // create fields search
	   GridPane gpFields = new GridPane();
	   gpFields.setAlignment(Pos.CENTER);
	   gpFields.setHgap(6);
	   gpFields.setVgap(6);
	   
	   // year
	   gpFields.add(new Label(yearLabel), 0, 0);
	   yearField.setPrefWidth(100);
	   yearField.setPromptText("Enter the year...");
	   gpFields.add(yearField, 1, 0);
	   
	   // gender
	   String[] genderList = {selectGender, "Boy", "Girl"};		
	   gpFields.add(new Label(genderLabel), 0, 1);
	   genderCombo.getItems().addAll(genderList);
	   genderCombo.setValue(selectGender);
	   genderCombo.setPrefWidth(100);
	   gpFields.add(genderCombo, 1, 1);
	   
	   // name
	   gpFields.add(new Label(nameLabel), 0, 2);
	   nameField.setPrefWidth(100);
	   nameField.setPromptText("Enter the name...");
	   gpFields.add(nameField, 1, 2);
	   
	   // message grip pane 
	   GridPane gpMessage = new GridPane();
	   gpMessage.setAlignment(Pos.CENTER);
	   gpMessage.setHgap(10);
	   gpMessage.setVgap(6);
	   // Message Label
	   gpMessage.add(message, 0, 3);
	   
	   // buttons
	   GridPane gpButtons = new GridPane();
	   gpButtons.setAlignment(Pos.CENTER);
	   gpButtons.setHgap(10);
	   gpButtons.setVgap(6);
	   
	   // create buttons
	   Button btnSubmit = new Button(submitButton);
	   btnSubmit.setOnAction(new OnClick(ps));
	   
	   Button btnExit = new Button(exitButton);
	   btnExit.setOnAction(new OnClick(ps));
	   
	   // add buttons to screen
	   gpButtons.add(btnSubmit, 0, 0);
	   gpButtons.add(btnExit, 1, 0);
	   
	   // add fields and buttons
	   gpSearch.add(gpFields, 0, 0);
	   gpSearch.add(gpMessage, 0, 1);
	   gpSearch.add(gpButtons, 0, 2);
	   
	   // Search scene
	   this.scSearch = new Scene(gpSearch, 300, 200);
	}

	/**
	 * Method: getScResult
	 * Objective: return Result scene
	 * @return Scene: scResult
	 */
	public Scene getScResult() {
		return scResult;
	}

	/**
	 * Method: setScResult
	 * Objective: set and create Result scene
	 * @param ps
	 */
	public void setScResult(Stage ps) {
		// create Result grid
		GridPane gpResult = new GridPane();
		gpResult.setAlignment(Pos.CENTER);
		gpResult.setHgap(20);
		gpResult.setVgap(10);
		
		// create fields grid
		GridPane gpResFields = new GridPane();
		gpResFields.setAlignment(Pos.CENTER);
		gpResFields.setHgap(6);
		gpResFields.setVgap(6);
		
		// result labels
		gpResFields.add(result, 0, 0);
		gpResFields.add(new Label("Do you want to Search for another Name:"), 0, 2);
		
		// buttons
		GridPane gpResButtons = new GridPane();
		gpResButtons.setAlignment(Pos.CENTER);
		gpResButtons.setHgap(10);
		gpResButtons.setVgap(6);
			
		// create buttons
		Button btnYes = new Button(yesButton);
		btnYes.setOnAction(new OnClick(ps));
			
		Button btnNo = new Button(noButton);
		btnNo.setOnAction(new OnClick(ps));
			
		// add buttons to screen
		gpResButtons.add(btnYes, 0, 0);
		gpResButtons.add(btnNo, 1, 0);
			
			// add fields and buttons
		gpResult.add(gpResFields, 0, 0);
		gpResult.add(gpResButtons, 0, 1);

		// Result scene
		this.scResult = new Scene(gpResult, 300, 200);
	}

	/**
	 * Inner Class: OnClick
	 * Objective: handle OnClick button actions
	 * @author Rodrigo Canella Garcia Morale
	 *
	 */
	public class OnClick implements EventHandler<ActionEvent>{
		
		// class attribute
		Stage ps;
		
		/**
		 * Constructor
		 * @param ps
		 */
		public OnClick(Stage ps) {
			super();
			this.ps = ps;
		}

		/**
		 * Method: handle
		 * Objective: handle button actions
		 */
		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			
			// get button target
			Button button = (Button)e.getTarget();	
				// execute different actions for each button target
				switch (button.getText()) {
				case submitButton: 
					if (checkForm()) {						
						message.setText("");
						
						// check for gender
						boolean gender = true;
						if (genderCombo.getValue() == "Girl") {
							gender = false;
						}
						
						// get year
						int year = Integer.parseInt(yearField.getText());
						
						try {
							Search search = new Search(nameField.getText(), year, gender);
							submit(search);
						} catch (Exception ex) {
							message.setText("Error, when try to open search file.");
						}
					}
					break;
				case exitButton:
				case noButton:
					System.exit(0);
					break;
				case yesButton:
					yes();
					break;
				default:
					System.out.println("Invalid button");
					break;
				}			
		}
		
		/**
		 * Method: checkForm
		 * Objective: check if form fields are filled correctly
		 * @return boolean: true / false
		 */
		public boolean checkForm() {
			boolean formOk = true;
			
			boolean isNumber = Pattern.matches("^[0-9]{4}$", yearField.getText());
						
			if (!isNumber) { 
				yearField.setText("");
				yearField.setFocusTraversable(!isNumber);
				message.setText("Please, enter a valid year.");
				formOk = false; 
			} else {
				if (genderCombo.getValue() == selectGender) {
					message.setText("Please, select Boy or Girl for gender.");
					formOk = false;
				} else {
					if (nameField.getText() == "") { 
						message.setText("Please, enter a name.");
						formOk = false;
					}
				}
			}
			return formOk;
		}
		
		/**
		 * Method: submit
		 * Objective: submit search and return result on Result scene
		 * @param search
		 */
		public void submit(Search search) {
			String txResult = genderCombo.getValue() + " name " + nameField.getText() +
					          " not found in " + search.getYear() + " rank list.";
			// rank is found
			if (search.getRank() != "") {
				// set value of result
				txResult = genderCombo.getValue() + " name " + nameField.getText() +
				           " is ranked #" + search.getRank() + " in " + search.getYear() + " year";
			}
			
			result.setText(txResult);
			
			// clear search fields
			yearField.setText("");
			nameField.setText("");
			genderCombo.setValue(selectGender);
			
			// switch scene
			ps.setScene(getScResult());
			ps.show();
		}
		
		/**
		 * Method: yes
		 * Objective: return to Search scene
		 */
		public void yes() {
			// switch scene
			ps.setScene(getScSearch());
			ps.show();
		}
	}

}
