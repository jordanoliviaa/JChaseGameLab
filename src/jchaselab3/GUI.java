package jchaselab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

	private JButton button;
	private JTextArea text;
	private JPanel panel;
	private JLabel label;
	private JTextField textfield;
	
	
	public GUI() {
		buildWindow();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		
	}

	private void buildWindow() {
		setTitle("Game");
		setLayout(new BorderLayout()); // Specifies border layout
		 text = new JTextArea();
		 panel = new JPanel();
		 label = new JLabel("What would you like to do?");
		 textfield = new JTextField();
		 button = new JButton("Execute");
		 panel.add(label);
		 panel.add(textfield);
		 panel.add(button);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}

}

