package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DataPanelLoginView extends JPanel{
	
	private JLabel userLabel;
	private JLabel psswdLabel;
	
	public DataPanelLoginView() {
		
		setBackground(Color.PINK);
		
		userLabel = new JLabel("Usuario:");
		userLabel.setBounds(50, 100, 10, 200);
		userLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(userLabel);
		
		psswdLabel = new JLabel("Contraseña:");
		psswdLabel.setBounds(50, 200, 10, 200);
		psswdLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(psswdLabel);
	}
}
