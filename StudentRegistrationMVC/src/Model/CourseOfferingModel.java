package src.Model;

import java.util.ArrayList;
/**
 * ENSF 607 Lab Assignment 3 - CourseOfferingModel
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseOfferingModel {

	private int sectionNumber;
	private int sectionCap;
	private CourseModel theCourse;
	private ArrayList <RegistrationModel> studentList;
	private boolean enoughStudents;
	private int numberOfStudents;
	
	public CourseOfferingModel (int sectionNumber, int sectionCap) {
		setSectionNumber(sectionNumber);
		setSectionCap(sectionCap);
		setStudentList(new ArrayList <RegistrationModel>());
		setEnoughStudents(false);
		setNumberOfStudents(0);
	}
	
	// Adds a registration to the list of enrolled students.
	public void addRegistration(RegistrationModel registration) {
		studentList.add(registration);
		
		// Adds one more to the number of students enrolled in the offering.
		setNumberOfStudents(getNumberOfStudents() + 1);
		
		// If the number of students is 8 or more, there are enough students for the course to run.
		if (getNumberOfStudents() >= 8) {
			setEnoughStudents(true);
		}
		// If the number of students is less than 8, there are not enough students for the course to run.
		else {
			setEnoughStudents(false);
		}
	}
	
	// Removes the registration from the list of enrolled students.
	public void removeRegistration(RegistrationModel registration) {
		studentList.remove(registration);
		setNumberOfStudents(getNumberOfStudents() - 1);
		
		// If the number of students is 8 or more, there are enough students for the course to run.
		if (getNumberOfStudents() >= 8) {
			setEnoughStudents(true);
		}
		
		// If the number of students is less than 8, there are not enough students for the course to run.
		else {
			setEnoughStudents(false);
		}
	}
	
	public int getSectionNumber() {
		return sectionNumber;
	}
	
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	
	public int getSectionCap() {
		return sectionCap;
	}
	
	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public ArrayList <RegistrationModel> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList <RegistrationModel> studentList) {
		this.studentList = studentList;
	}
	
	// Prints the section number, its capacity, a list of enrolled students, and if there are enough students.
	@Override
	public String toString() {
		String temp = "\n" + "Section Number: " + getSectionNumber() + ", Section Capacity: " + getSectionCap() + "\nEnrolled Students: \n";
		for (RegistrationModel s: studentList) {
			temp = temp + s.getTheStudent().getStudentName() + "\n";
		}
		temp = temp + "Enough Students: " + isEnoughStudents();
		return temp;
	}

	public boolean isEnoughStudents() {
		return enoughStudents;
	}

	public void setEnoughStudents(boolean enoughStudents) {
		this.enoughStudents = enoughStudents;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public CourseModel getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(CourseModel theCourse) {
		this.theCourse = theCourse;
	}
}
