package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.View.*;
import src.Model.*;
/**
 * ENSF 607 Lab Assignment 3 - UnregisterController
 * @author Brandon Quan, Michael Kissinger
 */
public class UnregisterController {
    UnregisterView theView;
    StudentModel studentModel;
    CourseCatalogueModel courseCatalogue;
    String courseName = null;
    int courseNumber = -1;
    String result;

    public UnregisterController (StudentModel studentModel, UnregisterView theView, CourseCatalogueModel courseCatalogue)
    {
        this.studentModel = studentModel;
        this.courseCatalogue = courseCatalogue;
        this.theView = theView;

        theView.addUnregisterListener(new UnregisterListener());
    }

    class UnregisterListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand() == "Remove a course") {
                    theView.clearDisplay();
                    theView.addText("Removing Course:\n");
                    // Prompts the user to input a course name and adds an enter button listener.
                    theView.promptCourseName(new UnregisterListener());
                }
                if (e.getActionCommand() == "ENTER") {

                    // If the course name is null when the enter button is pressed, the string is assigned to the courseName.
                    if (courseName == null) {
                        courseName = theView.getStringInput();
                        // Prints the course name in the display.
                        theView.addText(courseName);
                        // Removes the action listener on the enter button.
                        theView.removeEnterButtonListener(this);
                        // Prompts the user to input a course number and adds an enter button listener.
                        theView.promptCourseNumber(new UnregisterController.UnregisterListener());
                        return;
                    }
                    else if (courseName != null && courseNumber == -1) {
                        // If the course name is filled, the string is assigned to the courseNumber.
                        courseNumber = theView.getIntegerInput();
                        // Prints the course number in display.
                        theView.addText(String.valueOf(courseNumber));
                        // Removes the action listener on the enter button.
                        theView.removeEnterButtonListener(this);
                        result = studentModel.removeCourse(courseCatalogue, courseName, Integer.toString(courseNumber));
                        
                        if (result != null) {
                        	theView.addText("\n" + result + "\n");
                            theView.addText(studentModel.toString());
                            // Sets the course name, course number,a nd section number back to default.
                            courseName = null;
                            courseNumber = -1;
                        }
                        else {
	                        // If course not found, a message is printed.
	                        theView.addText("\nCourse was not found.");
	                        // Sets the course name and number back to default.
	                        courseName = null;
	                        courseNumber = -1;
                        }
                    }
                }
            }
            catch (NumberFormatException ex) {
            	theView.displayErrorMessage("Please enter a valid integer.");
            }
            catch (Exception ex) {
            	theView.displayErrorMessage("Something went wrong. Please try again.");
            }
        }
    }
}

