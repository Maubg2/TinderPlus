package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;


/**
 * <h2>MainPanel</h2>
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
	/**
	 * Constructor de la clase 
	 */
	public MainPanel() {
		
		setLayout(null);
		funcionar();
		setVisible(true);
		//setOpaque(false);
		setBackground(Color.decode("#FFA1CF"));
		
	}
	/**
	 * Para instanciar y darle coordenadas a los componentes
	 */
	public void funcionar() {
		LogInButton = new JButton("Iniciar sesión");
		LogInButton.setBounds(100, 260, 170, 30);
		LogInButton.setBackground(Color.decode("#EA047E"));
		LogInButton.setBorder(new EtchedBorder(100));
		LogInButton.setForeground(Color.WHITE);
		LogInButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		LogInButton.setFocusable(false); //Que no aparezca la caja que rodea el texto
		add(LogInButton);
		
		SignInButton = new JButton("Registrarse");
		SignInButton.setBounds(350, 260, 170, 30);
		SignInButton.setBackground(Color.decode("#EA047E"));
		SignInButton.setBorder(new EtchedBorder(100));
		SignInButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		SignInButton.setForeground(Color.WHITE);
		SignInButton.setFocusable(false);
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
