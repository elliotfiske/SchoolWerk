
/****
 * Class Student stores their id number and last name.
 * It also provides a comparison between two students so we know which student is better.
 * 
 * @author Thomas Steinke, Elliot Fiske
 */

public class Student implements Comparable<Student> {

	/** The student's id number */
	private long studentId;
	/** The last name of the student */
	private String lastName;
	
	/**
	 * The Student constructor accepts a student ID and a last name.
	 * @param studentId The student's last name.  Should be a positive integer.
	 * @param lastName The student's last name.  Should contain no spaces.
	 */
	public Student(long studentId, String lastName) {
		super();
		this.studentId = studentId;
		this.lastName = lastName;
	}

	/**
	 * Method compareTo compares students based on their student ID values.
	 */
	@Override
	public int compareTo(Student other) {
		if(studentId < other.studentId) return -1;
		if(studentId > other.studentId) return 1;
		return 0;
	}

	/**
	 * toString returns a string containing a student's last name and ID.
	 */
	@Override
	public String toString() {
		return "{ id: " + studentId + ", name: " + lastName + " }";
	}
}
