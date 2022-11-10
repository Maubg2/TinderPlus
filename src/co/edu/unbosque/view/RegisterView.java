package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterView extends JPanel{
	
	private JButton leave;
	private JButton next;
	private JLabel title;
	private JLabel questionBox;
	private JLabel userName;
	private JComboBox box;
	private String listBox[] = {"Hombre", "Mujer"};
	private JTextField nameField;
	
	public RegisterView() {
		setLayout(null);
		funcionar();
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
	}
	
	public void funcionar() {
		title = new JLabel("Registrarse");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(200, 20, 190, 80);
		add(title);
		
		next = new JButton("Siguiente");
		next.setBounds(280, 300, 90, 25);
		add(next);
		
		leave = new JButton("Salir");
		leave.setBounds(180, 300, 90, 25);
		add(leave);
		
		box = new JComboBox(listBox);
		box.setBounds(100, 200, 100, 30);
		add(box);
		
		questionBox = new JLabel("Ponga su género:");
		questionBox.setBounds(1, 1, 150, 25);
		add(questionBox);
		
		userName = new JLabel("Nombre de usuario:");
		userName.setBounds(200, 250, 160, 30);
		add(userName);
		
		nameField = new JTextField();
		nameField.setBounds(300, 250, 160, 30);
		add(nameField);
		
	}

}
