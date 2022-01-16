package src.Model;

import java.util.ArrayList;
/**
 * ENSF 607 Lab Assignment 3 - CourseCModel
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseModel {
	
	private String courseName;
	private String courseNumber;
	private ArrayList <CourseModel> preReq;
	private ArrayList <CourseOfferingModel> offeringList;
	
	public CourseModel(String courseName, String courseNumber) {
		setCourseName(courseName);
		setCourseNumber(courseNumber);
		offeringList = new ArrayList <CourseOfferingModel>();
		preReq = new ArrayList <CourseModel>();
	}
	
	public void addOffering(CourseModel theCourse, int sectionNumber, int sectionCap) {
		// Creates an offering object.
		CourseOfferingModel theOffering = new CourseOfferingModel(sectionNumber, sectionCap);
		// Adds the offering to the list of offerings for the course.
		offeringList.add(theOffering);
		// Sets the course variable in the offering to the course.
		theOffering.setTheCourse(theCourse);
	}

	// Adds a prerequisite course to the course's prerequisite list.
	public void addPreReq(CourseModel theCourse) {
		preReq.add(theCourse);
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	// Prints the course's name and number.
	@Override
	public String toString() {
		String temp = getCourseName() + " " + getCourseNumber();
		return temp;
	}

	public ArrayList <CourseModel> getPreReq() {
		return preReq;
	}

	public void setPreReq(ArrayList <CourseModel> preReq) {
		this.preReq = preReq;
	}

	public ArrayList <CourseOfferingModel> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList <CourseOfferingModel> offeringList) {
		this.offeringList = offeringList;
	}
}
