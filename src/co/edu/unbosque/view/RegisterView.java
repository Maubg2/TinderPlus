package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterView extends JPanel{
	
	private JButton leaveButton;
	private JButton nextButton;
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
		title.setBounds(210, 20, 190, 80);
		add(title);
		
		nextButton = new JButton("Siguiente");
		nextButton.setBounds(290, 300, 90, 25);
		add(nextButton);
		
		leaveButton = new JButton("Salir");
		leaveButton.setBounds(190, 300, 90, 25);
		add(leaveButton);
		
		box = new JComboBox(listBox);
		box.setBounds(300, 200, 100, 30);
		add(box);
		
		questionBox = new JLabel("Ponga su género:");
		questionBox.setBounds(150, 200, 150, 25);
		add(questionBox);
		
		userName = new JLabel("Nombre de usuario:");
		userName.setBounds(150, 150, 160, 30);
		add(userName);
		
		nameField = new JTextField();
		nameField.setBounds(300, 150, 160, 30);
		add(nameField);
		
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

}
