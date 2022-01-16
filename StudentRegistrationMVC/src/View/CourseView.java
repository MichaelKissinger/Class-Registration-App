package src.View;

import java.awt.event.ActionListener;
import src.Model.CourseModel;
import src.Model.CourseOfferingModel;
/**
 * ENSF 607 Lab Assignment 3 - CourseView
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseView {
	//Initialize a view object, this is so this view can interact with the GUI
	public View view;

	//Constructor method
	public CourseView(View theView) {
		view = theView;
	}

	//Activates action listener when option 1 (Search course catalogue) is selected on the GUI
	public void addCourseListener(ActionListener listener) {
		view.option1.addActionListener(listener);
	}
	
	public void displayCourse(CourseModel course) {
		view.addText("\nCourse found: \n");
		view.addText(course.toString());
		for (CourseOfferingModel c: course.getOfferingList()) {
			view.addText(c.toString());
		}
	}

	//Used to get user input for course number as an int
	public int getIntegerInput() {
		int temp = view.getIntegerInput();
		return temp;
	}
	//Used to get user input for course name as a string
	public String getStringInput() {
		String temp = view.getStringInput();
		return temp;
	}

	//Displays message to GUI, prompting user to enter course name
	public void promptCourseName (ActionListener listener) {
		view.addText("Enter the course name. e.g. ENSF\n");
		view.addEnterButtonListener(listener);
	}

	//Displays message to GUI, prompting user to enter course number
	public void promptCourseNumber (ActionListener listener) {
		view.addText("\nEnter the course number. e.g. 607\n");
		view.addEnterButtonListener(listener);
	}
	
	public void clearDisplay() {
		view.clearDisplay();
	}
	
	public void addText(String string) {
		view.addText(string);
	}
	
	public void removeEnterButtonListener(ActionListener listener) {
		view.enterButton.removeActionListener(listener);
	}
	
	public void displayErrorMessage(String errorMessage) {
		view.displayErrorMessage(errorMessage);
	}
}
