package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.View.*;
import src.Model.*;
/**
 * ENSF 607 Lab Assignment 3 - RegistrationController
 * @author Brandon Quan, Michael Kissinger
 */
public class RegistrationController {
    RegistrationView theView;
    StudentModel studentModel;
    CourseCatalogueModel courseCatalogue;
    String courseName = null;
    int courseNumber = -1;
    int sectionNumber = -1;
    String result;

    public RegistrationController (StudentModel studentModel, RegistrationView theView, CourseCatalogueModel courseCatalogue)
    {
        this.studentModel = studentModel;
        this.courseCatalogue = courseCatalogue;
        this.theView = theView;

        theView.addRegistrationListener(new RegistrationListener());
    }

    class RegistrationListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand() == "Add a course") {
                    theView.clearDisplay();
                    theView.addText("Adding Course:\n");
                    // Prompts the user to input a course name and adds an enter button listener.
                    theView.promptCourseName(new RegistrationListener());
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
                        theView.promptCourseNumber(new RegistrationController.RegistrationListener());
                        return;
                    }
                    else if (courseName != null && courseNumber == -1) {
                        // If the course name is filled, the string is assigned to the courseNumber.
                        courseNumber = theView.getIntegerInput();
                        // Prints the course number in display.
                        theView.addText(String.valueOf(courseNumber));
                        // Removes the action listener on the enter button.
                        theView.removeEnterButtonListener(this);
                        // Prompts the user to input a section number and adds an enter button listener.
                        theView.promptSectionNumber(new RegistrationController.RegistrationListener());
                        return;
                    } else if (courseName != null && courseNumber != -1 && sectionNumber == -1) {
                        // If the course name is filled, the string is assigned to the courseNumber.
                        sectionNumber = theView.getIntegerInput();
                        // Prints the section number in display.
                        theView.addText(String.valueOf(sectionNumber));
                        // Removes the action listener on the enter button.
                        theView.removeEnterButtonListener(this);
                        // Registers the course catalogue for a course with the name and number.
                        result = studentModel.registerForCourse(courseCatalogue, courseName, Integer.toString(courseNumber), sectionNumber);
                        
                        if (result != null) {
                        	// If registration is successful, the course is displayed.
                        	theView.addText("\n" + result + "\n");
                        	theView.addText(studentModel.toString());
                        	courseName = null;
                            courseNumber = -1;
                            sectionNumber = -1;
                        }
                        else {
                        	// If course not found, a message is printed.
                            theView.addText("\nCourse was not found.");
                            courseName = null;
                            courseNumber = -1;
                            sectionNumber = -1;
                        }
                    }
                }
            }
            catch (NumberFormatException ex) {
            	theView.displayErrorMessage("Please enter a valid integer.");
            }
            catch (IndexOutOfBoundsException ex) {
            	theView.displayErrorMessage("Section number not found. Please try again with a valid section number.");
            	courseName = null;
                courseNumber = -1;
                sectionNumber = -1;
            }
            catch (Exception ex) {
            	theView.displayErrorMessage("Something went wrong. Please try again.");
            }
        }
    }
}

