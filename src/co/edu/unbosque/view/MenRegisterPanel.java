package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenRegisterPanel extends JPanel{
	
	//Data
	private JLabel title;
	private JLabel usernameMenRegLabel;
	private JTextField usernameMenRegField;
	private JLabel ageMenRegLabel;
	private JTextField ageMenRegField;
	private JLabel mailMenRegLabel;
	private JTextField mailMenRegField;
	private JLabel heightMenRegLabel;
	private JTextField heightMenRegField;
	
	//Buttons
	private JButton exitMRVButton;
	private JButton nextMRVButton;
	
	public MenRegisterPanel() {
		
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		//Title section
		title = new JLabel("Registrarse");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(220, 20, 190, 80);
		add(title);
		
		//Username section
		usernameMenRegLabel = new JLabel("Nombre completo: ");
		usernameMenRegLabel.setBounds(42, 80, 120, 100);
		usernameMenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(usernameMenRegLabel);
		
		usernameMenRegField = new JTextField();
		usernameMenRegField.setBounds(160, 118, 180, 24);
		add(usernameMenRegField);
		
		//Age section
		ageMenRegLabel = new JLabel("Edad: ");
		ageMenRegLabel.setBounds(120, 124, 80, 80);
		ageMenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(ageMenRegLabel);
		
		ageMenRegField = new JTextField();
		ageMenRegField.setBounds(160, 150, 100, 24);
		add(ageMenRegField);
		
		//Mail section
		mailMenRegLabel = new JLabel("Correo: ");
		mailMenRegLabel.setBounds(104, 154, 100, 80);
		mailMenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(mailMenRegLabel);
		
		mailMenRegField = new JTextField();
		mailMenRegField.setBounds(160, 180, 100, 24);
		add(mailMenRegField);
		
		//Height section
		heightMenRegLabel = new JLabel("Altura: ");
		heightMenRegLabel.setBounds(108, 182, 100, 80);
		heightMenRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(heightMenRegLabel);
		
		heightMenRegField = new JTextField();
		heightMenRegField.setBounds(160, 210, 100, 24);
		add(heightMenRegField);
		
		//Buttons section
		exitMRVButton = new JButton("Salir");
		exitMRVButton.setBounds(40, 330, 80, 30);
		add(exitMRVButton);
		
		nextMRVButton = new JButton("Terminar");
		nextMRVButton.setBounds(440, 330, 120, 30);
		add(nextMRVButton);
	}

	public JTextField getUsernameMenRegField() {
		return usernameMenRegField;
	}

	public void setUsernameMenRegField(JTextField usernameMenRegField) {
		this.usernameMenRegField = usernameMenRegField;
	}

	public JTextField getAgeMenRegField() {
		return ageMenRegField;
	}

	public void setAgeMenRegField(JTextField ageMenRegField) {
		this.ageMenRegField = ageMenRegField;
	}

	public JTextField getMailMenRegField() {
		return mailMenRegField;
	}

	public void setMailMenRegField(JTextField mailMenRegField) {
		this.mailMenRegField = mailMenRegField;
	}

	public JTextField getHeightMenRegField() {
		return heightMenRegField;
	}

	public void setHeightMenRegField(JTextField heightMenRegField) {
		this.heightMenRegField = heightMenRegField;
	}

	public JButton getExitMRVButton() {
		return exitMRVButton;
	}

	public void setExitMRVButton(JButton exitMRVButton) {
		this.exitMRVButton = exitMRVButton;
	}

	public JButton getNextMRVButton() {
		return nextMRVButton;
	}

	public void setNextMRVButton(JButton nextMRVButton) {
		this.nextMRVButton = nextMRVButton;
	}
}
