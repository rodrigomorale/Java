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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class: Db
 * Objective: handle database
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Db implements AGSStudent, ExerciseAssigned, AGSLog{

	// class attributes
	public String DB_NAME = "dataBase.db";
	public String CONNECTION  = "jdbc:sqlite:C:\\Users\\rodri\\Documents\\Seneca College\\4 Term\\JAC 444\\WorkSpace\\Workshop 11\\src\\" + DB_NAME;
	public Connection conn;
	public String sql;
	
	/** 
	 * Constructor
	 */
	public Db() {
		super();
		
		// initialize sql
		sql = "";
		
		// start connection
		try {
			conn = DriverManager.getConnection(CONNECTION);
			conn.setAutoCommit(true);
			
			// create tables statements
			Statement createTable = conn.createStatement();
			
			// create table AGSStudent
			sql = "create table IF NOT Exists " + AGSStudent.NAME + " ("
					+ AGSStudent.USERNAME + " varchar(50) not null,"
					+ AGSStudent.PASSWORD + " varchar(50) not null,"
					+ AGSStudent.FULLNAME + " varchar(200) not null,"
					+ AGSStudent.INSTRUCTOREMAIL + " varchar(100) not null,"
					+ "constraint pkAGSStudent primary key (" + AGSStudent.USERNAME + ")"
					+ ");";
			createTable.execute(sql);
			
			// create table ExerciseAssigned
			sql = "create table IF NOT Exists " + ExerciseAssigned.NAME + " ("
					+ ExerciseAssigned.INSTRUCTOREMAIL + " varchar(100),"
					+ ExerciseAssigned.EXERCISENAME + " varchar(100),"
					+ ExerciseAssigned.MAXSCORE + " double default 10,"
					+ "constraint pkCustomExercise primary key (" + ExerciseAssigned.INSTRUCTOREMAIL + ", " + ExerciseAssigned.EXERCISENAME + ")"
					+ ");";
			createTable.execute(sql);
			
			// create table ExerciseAssigned
			sql = "create table IF NOT Exists " + AGSLog.NAME + " ("
					+ AGSLog.USERNAME + " varchar(50), "                 // This is the student's user name 
					+ AGSLog.EXERCISENAME + " varchar(100),"             // This is the exercise
					+ AGSLog.SCORE + " double default null,"
					+ AGSLog.SUBMITTED + " bit default 0,"
					+ "constraint pkLog primary key (" + AGSLog.USERNAME + ", " + AGSLog.EXERCISENAME + ")"
					+ ");";
			createTable.execute(sql);
			createTable.close();
			
			// clear tables
			// create tables statements
			Statement deleteTable = conn.createStatement();
			
			sql = "delete from " + AGSStudent.NAME;
			deleteTable.execute(sql);
			
			sql = "delete from " + ExerciseAssigned.NAME;
			deleteTable.execute(sql);
			
			sql = "delete from " + AGSLog.NAME;
			deleteTable.execute(sql);
	
			deleteTable.close();
			
		} catch (Exception err) {
			System.out.println("| *** Error when try to connect to database: " + err);
		}
	}

	/**
	 * Method: insertStudent
	 * Objective: insert new student into database
	 * @param student
	 * @return boolean: true / false
	 */
	public boolean insertStudent(Student student) {
		boolean sqlcode = false;
		try {
			sql = "insert into " + AGSStudent.NAME + "(" 
					+ AGSStudent.USERNAME + ", "
					+ AGSStudent.PASSWORD + ", "
					+ AGSStudent.FULLNAME + ", "
					+ AGSStudent.INSTRUCTOREMAIL + ") values ( " 
					+ "'" + student.getUsername() + "', "
					+ "'" + student.getPassword() + "', "
					+ "'" + student.getFullname() + "', "
					+ "'" + student.getInstructorEmail() + "')";
			conn.createStatement().execute(sql);
			sqlcode = true;
		}
		catch (Exception err) {
			System.out.println("| *** Student " + student.getUsername() + " not added!");
		}
		return sqlcode;
	}
	
	/**
	 * Method: insertAssignment
	 * Objective: insert new assignment into database
	 * @param assignment
	 * @return boolean: true / false
	 */
	public boolean insertAssignment(Assignment assignment) {
		boolean sqlcode = false;
		try {
			sql = "insert into " + ExerciseAssigned.NAME + "(" 
					+ ExerciseAssigned.INSTRUCTOREMAIL + ", "
					+ ExerciseAssigned.EXERCISENAME + ", "
					+ ExerciseAssigned.MAXSCORE + ") values ( "
					+ "'" + assignment.getInstructorEmail() + "', "
					+ "'" + assignment.getExerciseName() + "', "
					+ assignment.getMaxscore() + ")";
			conn.createStatement().execute(sql);
			sqlcode = true;
		}
		catch (Exception err) {
			System.out.println("| *** Assignment " + assignment.getExerciseName() + " not added!");
		}
		return sqlcode;
	}
	
	/**
	 * Method: insertLog
	 * Objective: insert new log into database
	 * @param log
	 * @return boolean: true / false
	 */
	public boolean insertLog(Log log) {
		boolean sqlcode = false;
		boolean exists = false;
		
		// check if log exists
		sql = "select * from " + AGSLog.NAME + " where "
				+ AGSLog.USERNAME + " = '" + log.username + "' and "
				+ AGSLog.EXERCISENAME + " = '" + log.exerciseName + "'";
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			exists = result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("| *** Log of " + log.getUsername() + " and assignment " + log.getExerciseName() + " already exists!");
		}		
		
		// if not exists add new log
		if (!exists) {		
     		try {
     			sql = "insert into " + AGSLog.NAME + "(" 
     					+ AGSLog.USERNAME + ", "
     					+ AGSLog.EXERCISENAME + ", "
     					+ AGSLog.SCORE + ", "
     					+ AGSLog.SUBMITTED + ") values ( "
     					+ "'" + log.getUsername() + "', "
     					+ "'" + log.getExerciseName() + "', "
     					+ log.getScore() + ", "
     					+ log.getSubmitted() + ")";
     			conn.createStatement().execute(sql);
     			sqlcode = true;
     		}
     		catch (Exception err) {
     			System.out.println("| *** Log of " + log.getUsername() + " and assignment " + log.getExerciseName() + " not added!");
     		}
		}
		return sqlcode;
	}
	
	/**
	 * Method: getStudents
	 * Objective: return a list of all students
	 * @return Student[]: students
	 */
	public Student[] getStudents() {
		Student[] students = null;
		int cnt = 0;
		int size = 0;
		
		// retrieve students
		sql = "select count(*) as 'cnt' from " + AGSStudent.NAME;
				
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			size = result.getInt("cnt");
			result.close();
				
			} catch (SQLException err) {
				// TODO Auto-generated catch block
				System.out.println("| *** Error when try to retrieve number of students: " + err);
			}
		
		// retrieve students
		sql = "select * from " + AGSStudent.NAME;
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			students = new Student[size];
			
			while (result.next()) {
				students[cnt++] = new Student(result.getString(AGSStudent.USERNAME), 
											  result.getString(AGSStudent.PASSWORD), 
											  result.getString(AGSStudent.FULLNAME), 
											  result.getString(AGSStudent.INSTRUCTOREMAIL));
			};
			
			result.close();
			
		} catch (SQLException err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to retrieve students: " + err);
		}	
		
		return students;		
	}
	
	/**
	 * Method: getAssignments
	 * Objective: return a list of all assignments
	 * @return Assignment[]: assignments
	 */
	public Assignment[] getAssignments() {
		Assignment[] assignments = null;
		int cnt = 0;
		int size = 0;

		sql = "select count(*) as 'cnt' from " + ExerciseAssigned.NAME;
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			size = result.getInt("cnt");
			result.close();
		} catch (SQLException err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to retrieve number of assignments: " + err);
		}	

		
		// retrieve students
		sql = "select * from " + ExerciseAssigned.NAME;
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			assignments = new Assignment[size];
			
			while (result.next()) {
				assignments[cnt++] = new Assignment(result.getString(ExerciseAssigned.INSTRUCTOREMAIL), 
											  result.getString(ExerciseAssigned.EXERCISENAME), 
											  result.getDouble(ExerciseAssigned.MAXSCORE));
			};
			
			result.close();
			
		} catch (SQLException err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to retrieve assignments: " + err);
		}	
		
		return assignments;		
	}
	
	/**
	 * Method: getLogs
	 * Objective: get a list of logs
	 * @return Log[]: logs
	 */
	public Log[] getLogs() {
		Log[] logs = null;
		int cnt = 0;
		int size = 0;
		
		// retrieve students
		sql = "select count(*) as 'cnt' from " + AGSLog.NAME;
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			size = result.getInt("cnt");
			result.close();
		} catch (SQLException err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to retrieve number of logs: " + err);
		}	
		
		
		sql = "select * from " + AGSLog.NAME;
		
		try {
			ResultSet result = conn.createStatement().executeQuery(sql);
			logs = new Log[size];
			
			while (result.next()) {
				logs[cnt++] = new Log(result.getString(AGSLog.USERNAME), 
											  result.getString(AGSLog.EXERCISENAME), 
											  result.getDouble(AGSLog.SCORE),
											  result.getInt(AGSLog.SUBMITTED));
			};
			
			result.close();
			
		} catch (SQLException err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to retrieve logs: " + err);
		}	
		
		return logs;		
	}
	
	/**
	 * Method: closeDb
	 * Objective: close database connection
	 */
	public void closeDb() {
		try {
			conn.close();
		} catch (Exception err) {
			// TODO Auto-generated catch block
			System.out.println("| *** Error when try to close database connection: " + err);
		}
	}
}
