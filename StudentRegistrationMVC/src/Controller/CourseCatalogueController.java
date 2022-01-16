package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import src.View.*;
import src.Model.*;
/**
 * ENSF 607 Lab Assignment 3 - CourseCatalogueController
 * @author Brandon Quan, Michael Kissinger
 */
public class CourseCatalogueController {
	CourseCatalogueView theView;
    CourseCatalogueModel courseCatalogue;
    ArrayList<CourseModel> courseList;

    public CourseCatalogueController (CourseCatalogueModel courseCatalogue, CourseCatalogueView theView)
    {
        this.courseCatalogue = courseCatalogue;
        this.theView = theView;

        theView.addCourseCatalogueListener(new CourseCatalogueListener());
    }

    class CourseCatalogueListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.clearDisplay();
                courseList = courseCatalogue.returnCourses();
                theView.displayCourseCatalogue(courseList);
            } catch (Exception ex) {
                theView.displayErrorMessage("Something went wrong. Please try again.");
            }
        }
    }
}

