package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
/**
 * <h2>RegisterView</h2>
 * JPanel para identificar si el usuario que se quiere registrar es hombre o mujer
 * 
 * @author J&M Sistemas 
 */
public class RegisterView extends JPanel{
	
	private JButton leaveButton;
	private JButton nextButton;
	
	private JLabel title;
	private JLabel questionBox;
	private JLabel userName;
	private JLabel passwordLabel;
	
	private JComboBox registerGenderBox;
	private String listBox[] = {"Hombre", "Mujer"};
	
	private JTextField nameField;
	private JPasswordField passwordField;
	/**
	 * Contructor de la clase
	 */
	public RegisterView() {
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
	}
	/**
	 * Metodo para instanciar y darle coordenadas a los elementos
	 */
	public void funcionar() {
		title = new JLabel("Registrarse");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(220, 20, 190, 80);
		add(title);
		
		nextButton = new JButton("Siguiente");
		nextButton.setBounds(300, 300, 90, 25);
		nextButton.setBackground(Color.decode("#EA047E"));
		nextButton.setBorder(new EtchedBorder(100));
		nextButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nextButton.setForeground(Color.WHITE);
		nextButton.setFocusable(false);
		add(nextButton);
		
		leaveButton = new JButton("Salir");
		leaveButton.setBounds(200, 300, 90, 25);
		leaveButton.setBackground(Color.decode("#EA047E"));
		leaveButton.setBorder(new EtchedBorder(100));
		leaveButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		leaveButton.setForeground(Color.WHITE);
		leaveButton.setFocusable(false);
		add(leaveButton);
		
		registerGenderBox = new JComboBox(listBox);
		registerGenderBox.setBounds(300, 240, 100, 30);
		add(registerGenderBox);
		
		questionBox = new JLabel("Ponga su g??nero:");
		questionBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		questionBox.setBounds(184, 240, 150, 25);
		add(questionBox);
		
		userName = new JLabel("Nombre de usuario:");
		userName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		userName.setBounds(170, 150, 160, 30);
		add(userName);
		
		nameField = new JTextField();
		nameField.setBounds(300, 150, 160, 30);
		add(nameField);
		
		passwordLabel = new JLabel("Contrase??a: ");
		passwordLabel.setBounds(216, 190, 160, 30);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 190, 160, 30);
		add(passwordField);
		
	}

	public JComboBox getRegisterGenderBox() {
		return registerGenderBox;
	}

	public void setRegisterGenderBox(JComboBox registerGenderBox) {
		this.registerGenderBox = registerGenderBox;
	}

	public JButton getLeaveButton() {
		return leaveButton;
	}

	public void setLeaveButton(JButton leaveButton) {
		this.leaveButton = leaveButton;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField.setText(nameField);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField.setText(passwordField);
	}
	
}
