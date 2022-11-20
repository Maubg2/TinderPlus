package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MenRegisterPanel extends GeneralRegister{
	
	private JLabel salaryMRPLabel;
	private JTextField salaryMRPField;
	
	public MenRegisterPanel() {
		
		super();
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
		salaryMRPLabel = new JLabel("Salario: ");
		salaryMRPLabel.setBounds(108, 210, 100, 80);
		salaryMRPLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(salaryMRPLabel);
		
		salaryMRPField = new JTextField();
		salaryMRPField.setBounds(160, 240, 100, 24);
		add(salaryMRPField);
		
	}
	
	public ArrayList<Object> collectMenData(){
		ArrayList<Object> returnableData = super.collectData();//Traer los datos del super
		returnableData.add(salaryMRPField.getText()); //Añadir los datos propios de la clase hija
		return returnableData;
	}

	public JTextField getSalaryMRPField() {
		return salaryMRPField;
	}

	public void setSalaryMRPField(JTextField salaryMRPField) {
		this.salaryMRPField = salaryMRPField;
	}

}
