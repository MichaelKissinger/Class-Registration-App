package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.View.*;
import src.Model.*;
/**
 * ENSF 607 Lab Assignment 3 - CourseController
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseController {
    CourseView theView;
    CourseModel course;
    CourseCatalogueModel courseCatalogue;
    String courseName = null;
	int courseNumber = -1;

    public CourseController (CourseView theView, CourseCatalogueModel courseCatalogue)
    {
        this.courseCatalogue = courseCatalogue;
        this.theView = theView;

        theView.addCourseListener(new CourseListener());
    }

    //Creating course object with user input

    class CourseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	if (e.getActionCommand() == "Search course catalogue") {
	            	theView.clearDisplay();
					theView.addText("Searching course catalogue:\n");
	            	// Prompts the user to input a course name and adds an enter button listener.
	                theView.promptCourseName(new CourseListener());
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
            			theView.promptCourseNumber(new CourseListener());
            			return;
            		}
            		else if (courseName != null && courseNumber == -1) {
            			// If the course name is filled, the string is assigned to the courseNumber.
            			courseNumber = theView.getIntegerInput();
            			// Prints the course number in display.
            			theView.addText(String.valueOf(courseNumber));
            			// Removes the action listener on the enter button.
            			theView.removeEnterButtonListener(this);
            			// Searches the course catalogue for a course with the name and number.
            			course = courseCatalogue.searchCat(courseName, String.valueOf(courseNumber));
            			
            			if (course != null) {
            				// Displays the course.
            				theView.displayCourse(course);
            				// Sets the course name and number back to default.
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

