package src.View;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import src.Model.CourseModel;

/**
 * ENSF 607 Lab Assignment 3 - CourseCatalogueView
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseCatalogueView {
	//Initialize a view object, this is so this view can interact with the GUI
	public View view;

	//Constructor method
	public CourseCatalogueView(View theView) {
		view = theView;
	}

	//Activates action listener when option 4 (View all courses in the catalogue) is selected on the GUI
	public void addCourseCatalogueListener(ActionListener listener) {
		view.option4.addActionListener(listener);
	}

	//Method displays all courses and their corresponding prerequisites
	public void displayCourseCatalogue(ArrayList<CourseModel> courseList) {
		view.addText("List of Courses in Catalogue:\n");
		for (CourseModel c: courseList) {
			view.addText("Course Name:\n");
            view.addText(c.toString() + "\n");
			view.addText("Has the following Prerequisites:\n");
			view.addText(c.getPreReq().toString() + "\n");
			view.addText("\n");
        }
	}

	public void clearDisplay() {
		view.clearDisplay();
	}
	
	public void addText(String string) {
		view.addText(string);
	}
	
	public void displayErrorMessage(String errorMessage) {
		view.displayErrorMessage(errorMessage);
	}
}
