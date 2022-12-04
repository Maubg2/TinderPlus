package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * <h2>LoginView</h2>
 * Clase con todos los elementos graficos del panel de iniciar sesion
 * 
 * @author J&M Sistemas
 */
public class LoginView extends JPanel{
	
	private JLabel loginTitle;
	private JLabel userLabel;
	private JTextField userField;
	private JLabel psswdLabel;
	private JPasswordField psswdField;
	private JButton backButton;
	private JButton loginButton;
	
	/**
	 * Constructor de la clase
	 */
	public LoginView() {
		
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	
	/**
	 * Se instancian y se les da coordenadas a los elementos
	 */
	public void funcionar() {
		
		//Title
		loginTitle = new JLabel("Iniciar sesión");
		loginTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		loginTitle.setBounds(210, 20, 190, 80);
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
		psswdLabel.setBounds(90, 160, 120, 50);
		add(psswdLabel);
				
		psswdField = new JPasswordField();
		psswdField.setBounds(200, 170, 200, 30);
		add(psswdField);
		
		//Buttons
		backButton = new JButton("Volver");
		backButton.setBounds(180, 300, 110, 30);
		backButton.setBackground(Color.decode("#EA047E"));
		backButton.setBorder(new EtchedBorder(100));
		backButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		backButton.setForeground(Color.WHITE);
		backButton.setFocusable(false);
		//backButton.setIcon(); //Para agregarle imágenes al botón
		//backButton.setHorizontalTextPosition();
		//backButton.setVerticalTextPosition();
		//backButton.setIconTextGap();
		add(backButton);
		
		loginButton = new JButton("Iniciar sesión");
		loginButton.setBounds(310, 300, 110, 30);
		loginButton.setBackground(Color.decode("#EA047E"));
		loginButton.setBorder(new EtchedBorder(100));
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusable(false);
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

	public void setUserField(String userField) {
		this.userField.setText(userField);
	}

	public JLabel getPsswdLabel() {
		return psswdLabel;
	}

	public void setPsswdLabel(JLabel psswdLabel) {
		this.psswdLabel = psswdLabel;
	}

	public JPasswordField getPsswdField() {
		return psswdField;
	}

	
	public void setPsswdField(String psswdField) {
		this.psswdField.setText(psswdField);
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
