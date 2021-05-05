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
 * Class: Log
 * Objective: handle log
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Log implements AGSLog {

	// fields values
	public String username;
	public String exerciseName;
	public double score;
	public int submitted;
	
	/**
	 * Empty Constructor
	 */
	public Log() {
		super();
		this.username = "";
		this.exerciseName = "";
		this.score = 0.00;
		this.submitted = 0;
	}
	
	/**
	 * Constructor
	 * @param username
	 * @param exerciseName
	 * @param score
	 * @param submitted
	 */
	public Log(String username, String exerciseName, double score, int submitted) {
		super();
		this.username = username;
		this.exerciseName = exerciseName;
		this.score = score;
		this.submitted = submitted;
	}

	/**
	 * Method: getUsername
	 * Objecctive: get username
	 * @return String: username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Method: setUsername
	 * Objective: set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Method: getExerciseName
	 * Objective: get exercise name
	 * @return String: exerciseName 
	 */
	public String getExerciseName() {
		return exerciseName;
	}

	/**
	 * Method: setExerciseName
	 * Objective: set exercise name
	 * @param exerciseName
	 */
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	/**
	 * Method: getScore
	 * Objective: get score
	 * @return double: score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * Method: setScore
	 * Objective: set score
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * Method: getSubmitted
	 * Objective: get submitted
	 * @return int: submitted
	 */
	public int getSubmitted() {
		return submitted;
	}

	/**
	 * Method: setSubmitted
	 * Objective: set submitted
	 * @param submitted
	 */
	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}
	
	/**
	 * Method: toString
	 * Objective: return a string of the object
	 * @return String: Object
	 */
	@Override
	public String toString() {
		return "Log = [" 
				+ AGSLog.USERNAME + " = " + getUsername() + ", "
				+ AGSLog.EXERCISENAME + " = " + getExerciseName() + ", "
				+ AGSLog.SCORE + " = " + getScore() + ", "
				+ AGSLog.SUBMITTED + " = " + getSubmitted() + "]";
	}
}
