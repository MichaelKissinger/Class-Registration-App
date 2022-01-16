package src.Model;

import java.util.ArrayList;
/**
 * ENSF 607 Lab Assignment 3 - CourseCatalogueModel
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseCatalogueModel {

	private ArrayList <CourseModel> courseList;
	
	// When constructor is called, loads dummy data from a hypothetical database.
	public CourseCatalogueModel() {
		courseList = loadFromDB();
	}

	//Replaces listCourses
	public ArrayList<CourseModel> returnCourses() {
		return courseList;
	}
	
	// Searches through the catalogue for a course with the specified name and number.
	public CourseModel searchCat(String courseName, String courseNumber) {
		for (CourseModel c: courseList) {
			// If the course name and number matches a course in the catalogue, it is returned.
			if (c.getCourseName().equals(courseName) && c.getCourseNumber().equals(courseNumber)) {
				return c;
			}
		}
		// If the course is not found, null is returned.
		return null;
	}
	
	private static ArrayList <CourseModel> loadFromDB() {
		
	// In real life, courses will be loaded from the DB or at least some
	// file on disk. So for now, we're imagining this is coming from a DB.
		ArrayList <CourseModel> imaginaryDB = new ArrayList <CourseModel>();
		
		imaginaryDB.add(new CourseModel ("ENSF", "607"));
		imaginaryDB.add(new CourseModel ("ENSF", "608"));
		imaginaryDB.add(new CourseModel ("ENSF", "611"));
		imaginaryDB.add(new CourseModel ("ENSF", "612"));
		imaginaryDB.add(new CourseModel ("ENSF", "614"));
		
		// Adds imaginary prerequisites to each of the courses.
		for (CourseModel c: imaginaryDB) {
			c.addPreReq(new CourseModel("ENSF", "592"));
			c.addPreReq(new CourseModel("ENSF", "593"));
			c.addPreReq(new CourseModel("ENSF", "594"));
		}
		
		// Adds imaginary offerings for each of the courses.
		for (CourseModel c: imaginaryDB) {
			c.addOffering(c, 1, 90);
			c.addOffering(c, 2, 90);
			c.addOffering(c, 3, 90);
		}
		return imaginaryDB;
	}
	
	// Prints each course in the catalogue.
	@Override
	public String toString() {
		String temp = "\n";
		for (CourseModel c: courseList) {
			temp = temp + c + "\n\n";
		}
		return temp;
	}

	public ArrayList <CourseModel> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList <CourseModel> courseList) {
		this.courseList = courseList;
	}
}
