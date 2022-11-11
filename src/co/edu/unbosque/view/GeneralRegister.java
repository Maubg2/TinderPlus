package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class GeneralRegister extends JPanel{
	
	protected JLabel title;
	protected JLabel usernameRegLabel;
	protected JTextField usernameRegField;
	protected JLabel ageRegLabel;
	protected JTextField ageRegField;
	protected JLabel mailRegLabel;
	protected JTextField mailRegField;
	protected JLabel heightRegLabel;
	protected JTextField heightRegField;
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
		usernameRegLabel = new JLabel("Nombre completo: ");
		usernameRegLabel.setBounds(42, 80, 120, 100);
		usernameRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(usernameRegLabel);
				
		usernameRegField = new JTextField();
		usernameRegField.setBounds(160, 118, 180, 24);
		add(usernameRegField);
				
		//Age section
		ageRegLabel = new JLabel("Edad: ");
		ageRegLabel.setBounds(120, 124, 80, 80);
		ageRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(ageRegLabel);
				
		ageRegField = new JTextField();
		ageRegField.setBounds(160, 150, 100, 24);
		add(ageRegField);
				
		//Mail section
		mailRegLabel = new JLabel("Correo: ");
		mailRegLabel.setBounds(104, 154, 100, 80);
		mailRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(mailRegLabel);
				
		mailRegField = new JTextField();
		mailRegField.setBounds(160, 180, 100, 24);
		add(mailRegField);
				
		//Height section
		heightRegLabel = new JLabel("Altura: ");
		heightRegLabel.setBounds(108, 182, 100, 80);
		heightRegLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(heightRegLabel);
				
		heightRegField = new JTextField();
		heightRegField.setBounds(160, 210, 100, 24);
		add(heightRegField);
		
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
	
	public ArrayList<Object> collectData(){
		ArrayList<Object> returnableData = new ArrayList<Object>();
		returnableData.add(usernameRegField.getText());
		returnableData.add(ageRegField.getText());
		returnableData.add(mailRegField.getText());
		returnableData.add(heightRegField.getText());
		return returnableData;
		
	}

	public JTextField getUsernameRegField() {
		return usernameRegField;
	}

	public void setUsernameRegField(JTextField usernameRegField) {
		this.usernameRegField = usernameRegField;
	}

	public JTextField getAgeRegField() {
		return ageRegField;
	}

	public void setAgeRegField(JTextField ageRegField) {
		this.ageRegField = ageRegField;
	}

	public JTextField getMailRegField() {
		return mailRegField;
	}

	public void setMailRegField(JTextField mailRegField) {
		this.mailRegField = mailRegField;
	}

	public JTextField getHeightRegField() {
		return heightRegField;
	}

	public void setHeightRegField(JTextField heightRegField) {
		this.heightRegField = heightRegField;
	}

	public JLabel getOptionalHeight() {
		return optionalHeight;
	}

	public void setOptionalHeight(JLabel optionalHeight) {
		this.optionalHeight = optionalHeight;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}
	
}
