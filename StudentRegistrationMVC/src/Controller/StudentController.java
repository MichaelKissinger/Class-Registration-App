package src.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.View.*;
import src.Model.*;
/**
 * ENSF 607 Lab Assignment 3 - StudentController
 * @author Brandon Quan, Michael Kissinger
 */
public class StudentController {
    StudentView theView;
    StudentModel studentModel;

    public StudentController (StudentModel studentModel, StudentView theView)
    {
        this.studentModel = studentModel;
        this.theView = theView;

        theView.addStudentListener(new StudentListener());
    }

    class StudentListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theView.clearDisplay();
                theView.addText(studentModel.toString());
            } catch (Exception ex) {
                theView.displayErrorMessage("Something went wrong. Please try again.");
            }
        }
    }
}

