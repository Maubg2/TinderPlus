package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class GeneralRegister extends JPanel{
	
	protected JLabel title;
	protected JLabel usernameWomenRegLabel;
	protected JTextField usernameWomenRegField;
	protected JLabel ageWomenRegLabel;
	protected JTextField ageWomenRegField;
	protected JLabel mailWomenRegLabel;
	protected JTextField mailWomenRegField;
	protected JLabel heightWomenRegLabel;
	protected JTextField heightWomenRegField;
	protected JLabel optionalHeight;
	protected JCheckBox checkBox;
	
	protected JButton exitButton;
	protected JButton nextButton;
	
	public GeneralRegister() {
		
		title = new JLabel("Registrarse");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(220, 20, 190, 80);
		add(title);
		
		//Username section
		usernameWomenRegLabel = new JLabel("Nombre completo: ");
		usernameWomenRegLabel.setBounds(42, 80, 120, 100);
		usernameWomenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(usernameWomenRegLabel);
				
		usernameWomenRegField = new JTextField();
		usernameWomenRegField.setBounds(160, 118, 180, 24);
		add(usernameWomenRegField);
				
		//Age section
		ageWomenRegLabel = new JLabel("Edad: ");
		ageWomenRegLabel.setBounds(120, 124, 80, 80);
		ageWomenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(ageWomenRegLabel);
				
		ageWomenRegField = new JTextField();
		ageWomenRegField.setBounds(160, 150, 100, 24);
		add(ageWomenRegField);
				
		//Mail section
		mailWomenRegLabel = new JLabel("Correo: ");
		mailWomenRegLabel.setBounds(104, 154, 100, 80);
		mailWomenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(mailWomenRegLabel);
				
		mailWomenRegField = new JTextField();
		mailWomenRegField.setBounds(160, 180, 100, 24);
		add(mailWomenRegField);
				
		//Height section
		heightWomenRegLabel = new JLabel("Altura: ");
		heightWomenRegLabel.setBounds(108, 182, 100, 80);
		heightWomenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(heightWomenRegLabel);
				
		heightWomenRegField = new JTextField();
		heightWomenRegField.setBounds(160, 210, 100, 24);
		add(heightWomenRegField);
		
		//Button section
		exitButton = new JButton("Salir");
		exitButton.setBounds(40, 330, 80, 30);
		exitButton.setBackground(Color.decode("#EA047E"));
		exitButton.setBorder(new EtchedBorder(100));
		exitButton.setFont(new Font("Times new Roman", Font.BOLD, 14));
		exitButton.setForeground(Color.WHITE);
		add(exitButton);
		
		nextButton = new JButton("Terminar");
		nextButton.setBounds(440, 330, 120, 30);
		nextButton.setBackground(Color.decode("#EA047E"));
		nextButton.setBorder(new EtchedBorder(100));
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nextButton.setForeground(Color.WHITE);
		add(nextButton);
		
	}

}
