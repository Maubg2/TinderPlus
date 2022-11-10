package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	
	private JLabel tinderTitle; 
	private ImageIcon image;
	
	public MainPanel() {
		
		setLayout(null);
		funcionar();
		setVisible(true);
		//setOpaque(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	
	public void funcionar() {
		LogInButton = new JButton("Iniciar sesión");
		LogInButton.setBounds(100, 260, 170, 30);
		add(LogInButton);
		
		SignInButton = new JButton("Registrarse");
		SignInButton.setBounds(350, 260, 170, 30);
		add(SignInButton);
		
		image = new ImageIcon("media/Tinder.png");
		tinderTitle = new JLabel();
		tinderTitle.setIcon(new ImageIcon(image.getImage().getScaledInstance(300, 230, Image.SCALE_SMOOTH)));
		tinderTitle.setBounds(150, 5, 300, 230);
		add(tinderTitle);
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
