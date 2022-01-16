package src.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * ENSF 607 Lab Assignment 3 - View
 * @author Brandon Quan, Michael Kissinger
 */
@SuppressWarnings("serial")

public class View extends JFrame implements ActionListener {

	JButton option1, option2, option3, option4, option5, option6, enterButton;
	JTextArea display;
	JTextField inputField;
	
	public View() {
		
		setSize(800, 650);
		setTitle("Registration App");
		
		JPanel displayPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(2, 3));
		
		option1 = new JButton("Search course catalogue");
		option2 = new JButton("Add a course");
		option3 = new JButton("Remove a course");
		option4 = new JButton("View all courses in the catalogue");
		option5 = new JButton("View all your registered courses");
		option6 = new JButton("Quit application");
		
		option6.addActionListener(this);
		
		buttonPanel.add(option1);
		buttonPanel.add(option2);
		buttonPanel.add(option3);
		buttonPanel.add(option4);
		buttonPanel.add(option5);
		buttonPanel.add(option6);
		
		
		displayPanel.add("North", buttonPanel);
		
		display = new JTextArea(30, 60);
		display.setLineWrap(true);
		
		displayPanel.add("Center", display);
		
		inputField = new JTextField(10);
		
		inputPanel.add(inputField);
		
		enterButton = new JButton("ENTER");
		
		inputPanel.add(enterButton);
		
		displayPanel.add("South", inputPanel);
		
		add(displayPanel);
	}
	
	public void setVisible() {
		setVisible(true);
	}
	
	public int getIntegerInput() {
		int temp = Integer.parseInt(inputField.getText());
		inputField.setText("");
		return temp;
	}
	
	public String getStringInput() {
		String temp = inputField.getText();
		inputField.setText("");
		return temp;
	}

	public void clearDisplay() {
		display.setText("");
	}
	
	public void addText(String string) {
		display.append(string + "");
	}
	
	public void addEnterButtonListener(ActionListener listener) {
		enterButton.addActionListener(listener);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == option6) {
			System.exit(0);
		}
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
