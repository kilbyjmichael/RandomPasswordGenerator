package com.kilby;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PasswordGeneratorGUI 
{
	private JPanel mainPanel = new JPanel();
	private JPanel optionsPanel = new JPanel();
	private JTextField passwordHolder = new JTextField("Your Password Here");
	private JTextField pwLength = new JTextField("10");
	private JTextField pwPercentN = new JTextField(".7");
	private JTextField pwPercentC = new JTextField(".3");
	//comboBox
	private String[] comboStrings = {"numbers", "chars"};
	private JComboBox pwOrder = new JComboBox(comboStrings);
	
	private JButton newPwButton = new JButton("Generate Password");
	private Font passwordFont = new Font("Monospaced", 1, 20);

	public PasswordGeneratorGUI()
	{
		JFrame frame = new JFrame("Password Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		frame.setVisible(true);
		
		ButtonListener listenToButtons = new ButtonListener();
		newPwButton.addActionListener(listenToButtons);
		newPwButton.setFont(passwordFont);
		pwOrder.setSelectedIndex(0);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	    passwordHolder.setBorder(border);
	    passwordHolder.setPreferredSize(new Dimension(400,100));
	    passwordHolder.setFont(passwordFont);
	    
	    newPwButton.setPreferredSize(new Dimension(400,100));
	    
	    optionsPanel.add(pwLength);
	    pwLength.setPreferredSize(new Dimension(50,25));
	    pwLength.setFont(passwordFont);
	    pwLength.addActionListener(listenToButtons);
	    
	    optionsPanel.add(pwPercentN);
	    pwPercentN.setPreferredSize(new Dimension(50,25));
	    pwPercentN.setFont(passwordFont);
	    pwPercentN.addActionListener(listenToButtons);
	    
	    optionsPanel.add(pwPercentC);
	    pwPercentC.setPreferredSize(new Dimension(50,25));
	    pwPercentC.setFont(passwordFont);
	    pwPercentC.addActionListener(listenToButtons);
	    
	    optionsPanel.add(pwOrder);
	    pwOrder.setPreferredSize(new Dimension(120,25));
	    pwOrder.setFont(passwordFont);
	    pwOrder.addActionListener(listenToButtons);
	    
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.add(passwordHolder, BorderLayout.PAGE_START);
		mainPanel.add(optionsPanel, BorderLayout.CENTER);
		mainPanel.add(newPwButton, BorderLayout.PAGE_END);
		
		frame.add(mainPanel);
	}
	
	private class ButtonListener implements ActionListener
	{
		RandomPasswordGenerator pwGen = new RandomPasswordGenerator();
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//get shit
			int length = Integer.parseInt(pwLength.getText());
			double percentN = Double.parseDouble(pwPercentN.getText());
			double percentC = /*1 - Double.parseDouble(pwPercentN.getText());*/Double.parseDouble(pwPercentC.getText());
			String order = comboStrings[pwOrder.getSelectedIndex()];
			
			//pwPercentN.setText(Double.toString(percentN));
			//pwPercentC.setText(Double.toString(percentC));
			
			passwordHolder.setText(pwGen.generatePassword(length, percentN, percentC, order));
		}
	}
	
	public static void main(String[] args) 
	{
		PasswordGeneratorGUI run = new PasswordGeneratorGUI();
	}

}
