package src.View;

import java.awt.event.ActionListener;
/**
 * ENSF 607 Lab Assignment 3 - UnregisterView
 * @author Brandon Quan, Michael Kissinger
 */
public class UnregisterView {
	//Initialize a view object, this is so this view can interact with the GUI
	public View view;

	//Constructor method
	public UnregisterView(View theView) {
		view = theView;
	}

	//Activates action listener when option 4 (View all courses in the catalogue) is selected on the GUI
	public void addUnregisterListener(ActionListener listener) {
		view.option3.addActionListener(listener);
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
