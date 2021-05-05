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
 * Class: LiveLab
 * Objective: main class of the workshop 11
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class LiveLab {
	
	// class attributes
	final static int END = 5;
	public static int option = 0;
	public static Db database;
	
	/**
	 * Method: main
	 * Objective: main method of the program
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			// create database object
			database = new Db();
			
			// print header
			System.out.println("/**********************************************");
			System.out.println("Workshop 11");
			System.out.println("Course: JAC 444 - Semester 4");
			System.out.println("Last Name: Canella Garcia Morale");
			System.out.println("First Name: Rodrigo");
			System.out.println("ID: 135297190");
			System.out.println("Section: NEE");
			System.out.println("This assignment represents my own work in accordance with Seneca Academic Policy.");
			System.out.println("Signature");
			System.out.println("Date: April 16, 2021");
			System.out.println("**********************************************/");
			
			// add new students
			addStudent(new Student("abc", "p1", "Kyle Wright", "a@senencacollege.ca"));
			addStudent(new Student("cde", "p2", "Yao Mi", "c@senencacollege.ca"));
			addStudent(new Student("wbc", "p3", "Jack Jill", "a@senencacollege.ca"));
			
			//add assignments
			addAssignment(new Assignment("a@senencacollege.ca", "e1", 10));
			addAssignment(new Assignment("a@senencacollege.ca", "e2", 10));
			addAssignment(new Assignment("c@senencacollege.ca", "e1", 4));
			addAssignment(new Assignment("c@senencacollege.ca", "e4", 20));

			// add logs
			addLog(new Log("abc", "e1", 9, 1));
			addLog(new Log("wbc", "e2", 7, 1));
			
			// main section screen printer
			System.out.println("|=============================================|");
			System.out.println("|       Assignments Processing                |");
			System.out.println("|=============================================|");
			
			
			// get all assignments
			Assignment[] asssignments = selectAllAssignments();
			
			// process student score
			Student[] students = selectAllStudents();
			for(Student student: students) {
				for(Assignment assignment: asssignments) {
					if (student.getInstructorEmail().equalsIgnoreCase(assignment.getInstructorEmail())) {
						addLog(new Log(student.getUsername(), assignment.getExerciseName(), 0, 0));
					}
				}
			}

			// print final message
			System.out.println("|=============================================|");
			System.out.println("|         Final tables result                 |");
			
			System.out.println("|=============================================|");
			System.out.println("|         Students                            |");
			System.out.println("|---------------------------------------------|");
			Student[] studentsList = selectAllStudents();
			for(Student student: studentsList) {
				System.out.println("|" + student.toString());
			}
			
			System.out.println("|=============================================|");
			System.out.println("|         Assignments                         |");
			System.out.println("|---------------------------------------------|");
			Assignment[] assignmentList = selectAllAssignments();
			for(Assignment assignment: assignmentList) {
				System.out.println("|" + assignment.toString());
			}
			
			System.out.println("|=============================================|");
			System.out.println("|         Logs                                |");
			System.out.println("|---------------------------------------------|");
			Log[] logList = selectAllLogs();
			for(Log log: logList) {
				System.out.println("|" + log.toString());
			}
			
			database.closeDb();
			
			// print final message
			System.out.println("|=============================================|");
			System.out.println("|         Program - Finished                  |");
			System.out.println("|=============================================|");
	}
	
	/**
	 * Method: addStudent
	 * Objective: add a new student
	 * @param student
	 * @return
	 */
	public static boolean addStudent(Student student) {
		System.out.println("| Student add with success: " + student.toString());
		return database.insertStudent(student);
	}
	
	/**
	 * Method: addAssignment
	 * Objective: add new assignment
	 * @param assignment
	 * @return
	 */
	public static boolean addAssignment(Assignment assignment) {
		boolean success =  database.insertAssignment(assignment);
		if (success) { System.out.println("| Assignment add with success: " + assignment.toString()); }
		return success;
	}
	
	/**
	 * Method: addLog
	 * Objective: add new log
	 * @param log
	 * @return
	 */
	public static boolean addLog(Log log) {
		boolean success =  database.insertLog(log);
		if (success) { System.out.println("| Log add with success: " + log.toString()); }
		return success;
	}
	
	/**
	 * Method: selectAllStudents
	 * Objective: return a list of all students
	 * @return Student[]: students
	 */
	public static Student[] selectAllStudents() {
		return database.getStudents();
	}
	
	/**
	 * Method: selectAllAssignments
	 * Objective: return a list o all assignments
	 * @return Assignment[]: assignment
	 */
	public static Assignment[] selectAllAssignments() {
		return database.getAssignments();
	}
	
	/**
	 * Method: selectAllLogs
	 * Objective: return a list o all logs
	 * @return Log[]: logs
	 */
	public static Log[] selectAllLogs() {
		return database.getLogs();
	}

}
