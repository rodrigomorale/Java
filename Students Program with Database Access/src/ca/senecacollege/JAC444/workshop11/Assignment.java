/**********************************************
Workshop 11
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: April 16, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop11;

/**
 * Class: Assignment
 * Objective: handle Assignment
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Assignment implements ExerciseAssigned {
	
	// fields values
	public String instructorEmail;
	public String exerciseName;
	public double maxscore;
	
	/**
	 * Empty Constructor
	 */
	public Assignment() {
		super();
		this.instructorEmail = "";
		this.exerciseName = "";
		this.maxscore = 0.00;		
	}
	
	/**
	 * Constructor
	 * @param instructorEmail
	 * @param exerciseName
	 * @param maxscore
	 */
	public Assignment(String instructorEmail, String exerciseName, double maxscore) {
		super();
		this.instructorEmail = instructorEmail;
		this.exerciseName = exerciseName;
		this.maxscore = maxscore;
	}

	/**
	 * Method: getInstructorEmail
	 * Objective: return instructor email
	 * @return String: instructorEmail
	 */
	public String getInstructorEmail() {
		return instructorEmail;
	}

	/**
	 * Method: setInstructorEmail
	 * Objective: set instructorEmail
	 * @param instructorEmail
	 */
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}

	/**
	 * Method: getExerciseName
	 * Objective: get exerciseName
	 * @return String: exerciseName
	 */
	public String getExerciseName() {
		return exerciseName;
	}

	/**
	 * Method: setExerciseName
	 * Objective: set exerciseName
	 * @param exerciseName
	 */
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	/**
	 * Method: getMaxscore
	 * Objective: get maxscore
	 * @return double: maxscore
	 */
	public double getMaxscore() {
		return maxscore;
	}

	/**
	 * Method: setMaxscore
	 * Objective: set maxscore
	 * @param maxscore
	 */
	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}
	
	/**
	 * Method: toString
	 * Objective: overrides to String
	 * @return String: Object
	 */
	@Override
	public String toString() {
		return "Assignment = [" 
				+ ExerciseAssigned.INSTRUCTOREMAIL + " = " + getInstructorEmail() + ", "
				+ ExerciseAssigned.EXERCISENAME + " = " + getExerciseName() + ", "
				+ ExerciseAssigned.MAXSCORE + " = " + getMaxscore() + "]";
	}
}
