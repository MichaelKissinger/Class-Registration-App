package src;
import src.View.*;
import src.Model.*;
import javax.swing.*;
import src.Controller.*;
/**
 * ENSF 607 Lab Assignment 3 - RegistrationApp
 * @author Brandon Quan, Michael Kissinger
 */
public class RegistrationApp {

    public static void main(String [] args) {

        //Initialize the student to be enrolled
        StudentModel theStudent = new StudentModel("Andrew", 1);

        //Initialize course catalogue
        CourseCatalogueModel courseCatalogue = new CourseCatalogueModel();
        
        // Creates a GUI capable of accessing all of the views.
        View theView = new View();
        
        // Creates the individual views.
        CourseCatalogueView theCourseCatalogueView = new CourseCatalogueView(theView);
        CourseView theCourseView = new CourseView(theView);
        RegistrationView theRegistrationView = new RegistrationView(theView);
        StudentView theStudentView = new StudentView(theView);
        UnregisterView theUnregisterView = new UnregisterView(theView);

        // Creates individual controllers for each GUI function
        RegistrationController theRegistrationController= new RegistrationController (theStudent, theRegistrationView, courseCatalogue);
        UnregisterController theUnregisterController= new UnregisterController(theStudent, theUnregisterView, courseCatalogue);
        CourseController theController = new CourseController (theCourseView, courseCatalogue);
        StudentController theStudentController= new StudentController (theStudent, theStudentView);
        CourseCatalogueController theCourseCatalogueController = new CourseCatalogueController (courseCatalogue, theCourseCatalogueView);

        // Shows the GUI
        theView.setVisible(true);
        theView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
