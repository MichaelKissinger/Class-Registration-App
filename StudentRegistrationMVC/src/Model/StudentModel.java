package src.Model;

import java.util.ArrayList;
/**
 * ENSF 607 Lab Assignment 3 - StudentModel
 * @author Brandon Quan, Michael Kissinger
 */
public class StudentModel {
	
	private String studentName;
	private int studentID;
	private ArrayList <RegistrationModel> courseList;
	private int numberOfCourses;
	
	public StudentModel(String name, int id) {
		setStudentID(id);
		setStudentName(name);
		setCourseList(new ArrayList <RegistrationModel>());
		setNumberOfCourses(0);
	}
	
	public String registerForCourse(CourseCatalogueModel catalogue, String courseName, String courseNumber, int sectionNumber) {
		
		// If the student is enrolled in more than six courses, a message is displayed.
		if (getNumberOfCourses() >= 6) {
			return "Student is enrolled in too many courses.";
		}
		
		// Searches the catalogue for a course with the specified name and number.
		CourseModel myCourse = catalogue.searchCat(courseName, courseNumber);
		
		// If the course is not found, returns.
		if (myCourse == null)
			return null;
		else {
			// Searches through every registered course in the student's course list.
			// If a course in the list matches the course that's being added, the student is already enrolled.
			// A message is displayed saying that the student is already enrolled in the course.
			for (RegistrationModel c: courseList) {
				if (c.getTheOffering().getTheCourse().getCourseName().equals(myCourse.getCourseName())
				&& c.getTheOffering().getTheCourse().getCourseNumber().equals(myCourse.getCourseNumber())) {
//					System.out.println("Already enrolled in course.");
					return "Already enrolled in course.";
				}
			}
		}
		
		// If the course exists, then we can look at the section.
		CourseOfferingModel theOffering = myCourse.getOfferingList().get(sectionNumber - 1);
		
		// Calls the constructor method for a Registration object.
		// Constructor adds the registration to the student's list of enrolled courses.
		// Constructor also adds the registration to the offering's list of enrolled students.
		RegistrationModel theRegistration = new RegistrationModel(this, theOffering);
		theRegistration.addRegistration();
//		System.out.println("Successfully enrolled.");
		return "Successfully enrolled.\n";
	}
		
	public String removeCourse(CourseCatalogueModel catalogue, String courseName, String courseNumber) {
		
		// Searches the catalogue for a course with the specified name and number.
		CourseModel myCourse = catalogue.searchCat(courseName, courseNumber);
		
		// If course is not found, returns.
		if (myCourse == null)
			return null;
		
		// Sets the registration to a null value.
		RegistrationModel theRegistration = null;
		
		// Searches through every registered course in the student's course list.
		// If a course in the list matches the course that's being removed, the registration is set to it.
		for (RegistrationModel c: courseList) {
			if (c.getTheOffering().getTheCourse().getCourseName().equals(myCourse.getCourseName())
			&& c.getTheOffering().getTheCourse().getCourseNumber().equals(myCourse.getCourseNumber())) {
				theRegistration = c;
				break;
			}
		}
		
		// If the registration was found in the list, the registration's removeRegistration method is called.
		// This removes the registration from the student's list of enrolled courses.
		// Also removes the registration from the offering's list of enrolled students.
		if (theRegistration != null) {
			theRegistration.removeRegistration();
			return "Successfully removed course.\n";
		}
		// Displays a message if the course was not found in the list of courses.
		else {
			return "Course not found in enrolled courses.";
		}
		
	}
	
	// Adds the registration to the list of courses.
	public void addRegistration(RegistrationModel registration) {
		courseList.add(registration);
		setNumberOfCourses(getNumberOfCourses() + 1);
	}
	
	// Removes the registration from the list of courses.
	public void removeRegistration(RegistrationModel registration) {
		courseList.remove(registration);
		setNumberOfCourses(getNumberOfCourses() - 1);
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public ArrayList <RegistrationModel> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList <RegistrationModel> courseList) {
		this.courseList = courseList;
	}

	// Prints the name, id, and a list of the enrolled courses that the student is enrolled in.
	@Override
	public String toString() {
		String temp = "Name: " + getStudentName() + ", ID: " + getStudentID() + "\nEnrolled Courses:\n";
		for (RegistrationModel c: courseList) {
			temp = temp + "\n" + c.getTheOffering().getTheCourse() + c.getTheOffering() + "\n";
		}
		return temp;
	}

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}
}
