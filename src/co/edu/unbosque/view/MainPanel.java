package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Clase que contiene los botones de iniciar sesion y registrarse
 * 
 * @author J&M Sistemas
 */
public class MainPanel extends JPanel{
	
	//private JLabel
	private JButton LogInButton;
	private JButton SignInButton;
	
	public MainPanel() {
		
		setLayout(null);
		setBounds(50, 50, 600, 500);
		setBackground(Color.PINK);
		LogInButton = new JButton("Iniciar sesión");
		LogInButton.setBounds(50, 220, 170, 30);
		add(LogInButton);
		
		SignInButton = new JButton("Registrarse");
		SignInButton.setBounds(120, 270, 170, 30);
		add(SignInButton);
	}

	public JButton getLogInButton() {
		return LogInButton;
	}

	public void setLogInButton(JButton logInButton) {
		LogInButton = logInButton;
	}

	public JButton getSignInButton() {
		return SignInButton;
	}

	public void setSignInButton(JButton signInButton) {
		SignInButton = signInButton;
	}
	
}
