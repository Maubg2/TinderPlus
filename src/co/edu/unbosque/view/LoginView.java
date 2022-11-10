package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JPanel{
	
	private JLabel loginTitle;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel psswdLabel;
	private JTextField psswdField;
	
	
	public LoginView() {
		
		setVisible(false);
		
		//Title
		loginTitle = new JLabel("Iniciar sesión");
		loginTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		loginTitle.setBounds(100, 20, 100, 80);
		add(loginTitle);
		
		//User section
		userLabel = new JLabel("Usuario: ");
		userLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userLabel.setBounds(50, 100, 100, 80);
		add(userLabel);
		
		userField = new JTextField();
		userField.setBounds(80, 100, 80, 50);
		add(userField);
		
		//Password section
		psswdLabel = new JLabel("Contraseña: ");
		psswdLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		psswdLabel.setBounds(50, 200, 80, 50);
		add(psswdLabel);
		
		psswdField = new JTextField();
		psswdField.setBounds(100, 200, 80, 50);
		add(psswdField);
	}

}
