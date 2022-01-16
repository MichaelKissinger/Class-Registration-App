package src.Model;
/**
 * ENSF 607 Lab Assignment 3 - RegistrationModel
 * @author Brandon Quan, Michael Kissinger
 */
public class RegistrationModel {

	private StudentModel theStudent;
	private CourseOfferingModel theOffering;
	private char grade;
	
	public RegistrationModel (StudentModel theStudent, CourseOfferingModel theOffering) {
		setTheStudent(theStudent);
		setTheOffering(theOffering);
	}

	public void addRegistration() {
		// Checks if the number of students in the offering has not exceeded the capacity.
		if (theOffering.getNumberOfStudents() < theOffering.getSectionCap()) {
			// Adds the registration to the student's list of courses.
			theStudent.addRegistration(this);
			// Adds the registration to the offering's list of students.
			theOffering.addRegistration(this);
		}
		// Prints a message if capacity has been reached.
		else {
			System.out.println("Section is at maximum capacity. Please enroll in a different section.");
		}
	}
	
	public void removeRegistration() {
		// Removes the registration from the student's list of courses.
		theStudent.removeRegistration(this);
		// Removes the registration from the offering's list of students.
		theOffering.removeRegistration(this);
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public StudentModel getTheStudent() {
		return theStudent;
	}

	public void setTheStudent(StudentModel theStudent) {
		this.theStudent = theStudent;
	}

	public CourseOfferingModel getTheOffering() {
		return theOffering;
	}

	public void setTheOffering(CourseOfferingModel theOffering) {
		this.theOffering = theOffering;
	}
	
	// Prints the student and the name of the enrolled course.
	@Override
	public String toString() {
		return "Student Name: " + getTheStudent().getStudentName() + ", Enrolled Course: " +
				getTheOffering().getTheCourse().getCourseName() + getTheOffering().getTheCourse().getCourseNumber();
	}
}
