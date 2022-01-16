package src.View;

import java.awt.event.ActionListener;

public class StudentView {
	//Initialize a view object, this is so this view can interact with the GUI
	public View view;

	//Constructor method
	public StudentView(View theView) {
		view = theView;
	}

	//Activates action listener when option 5 (View all your registered courses) is selected on the GUI
	public void addStudentListener(ActionListener listener) {
		view.option5.addActionListener(listener);
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
