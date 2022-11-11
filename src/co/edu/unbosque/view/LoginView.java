package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JPanel{
	
	private JLabel loginTitle;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel psswdLabel;
	private JTextField psswdField;
	private JButton backButton;
	private JButton loginButton;
	
	
	public LoginView() {
		
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	
	public void funcionar() {
		
		//Title
		loginTitle = new JLabel("Iniciar sesión");
		loginTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		loginTitle.setBounds(200, 20, 190, 80);
		add(loginTitle);
			
		//User section
		userLabel = new JLabel("Usuario: ");
		userLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userLabel.setBounds(90, 100, 100, 80);
		add(userLabel);
				
		userField = new JTextField();
		userField.setBounds(200, 124, 200, 30);
		add(userField);
				
		//Password section
		psswdLabel = new JLabel("Contraseña: ");
		psswdLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		psswdLabel.setBounds(90, 200, 120, 50);
		add(psswdLabel);
				
		psswdField = new JTextField();
		psswdField.setBounds(200, 210, 200, 30);
		add(psswdField);
		
		//Buttons
		backButton = new JButton("Volver");
		backButton.setBounds(160, 300, 110, 30);
		add(backButton);
		
		loginButton = new JButton("Iniciar sesión");
		loginButton.setBounds(290, 300, 110, 30);
		add(loginButton);
		
	}

	public JLabel getLoginTitle() {
		return loginTitle;
	}

	public void setLoginTitle(JLabel loginTitle) {
		this.loginTitle = loginTitle;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JTextField getUserField() {
		return userField;
	}

	public void setUserField(JTextField userField) {
		this.userField = userField;
	}

	public JLabel getPsswdLabel() {
		return psswdLabel;
	}

	public void setPsswdLabel(JLabel psswdLabel) {
		this.psswdLabel = psswdLabel;
	}

	public JTextField getPsswdField() {
		return psswdField;
	}

	public void setPsswdField(JTextField psswdField) {
		this.psswdField = psswdField;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton back) {
		this.backButton = back;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

}
