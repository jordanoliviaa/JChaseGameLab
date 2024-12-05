package jchaselab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

	
	
	public GUI() {
		buildWindow();
	}
	public JTextArea text;
	private JTextField textfield;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String s = textfield.getText();
		Game.processCommand(s);
		textfield.setText("");
	}

	private void buildWindow() {
		setTitle("Game");
		setLayout(new BorderLayout()); // Specifies border layout 
	
		textfield = new JTextField();
		text = new JTextArea();
		
		JLabel label = new JLabel("What would you like to do?");
		JPanel panel = new JPanel(new GridLayout(3,1));
		JButton button = new JButton("Execute");
		button.addActionListener(this);
		
		add(text, BorderLayout.CENTER); 
		add(panel, BorderLayout.SOUTH);
			
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}

}

