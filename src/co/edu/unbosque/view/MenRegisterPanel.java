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
/**
 * <h2>MenRegisterPanel</h2>
 * Clase creada para especificamente para el registro de hombres
 * 
 * @author J&M Sistemas 
 */
public class MenRegisterPanel extends GeneralRegister{
	
	private JLabel salaryMRPLabel;
	private JTextField salaryMRPField;
	/**
	 * Contructor de la clase
	 */
	public MenRegisterPanel() {
		
		super();
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
		salaryMRPLabel = new JLabel("Salario: ");
		salaryMRPLabel.setBounds(308, 246, 100, 80);
		salaryMRPLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(salaryMRPLabel);
		
		salaryMRPField = new JTextField();
		salaryMRPField.setBounds(360, 276, 100, 24);
		add(salaryMRPField);
		
	}
	/**
	 * Retorna los datos recolectados (en un ArrayList) en el proceso de registro
	 * @return
	 */
	public ArrayList<Object> collectMenData(){
		ArrayList<Object> returnableData = super.collectData();//Traer los datos del super
		returnableData.add(salaryMRPField.getText()); //Añadir los datos propios de la clase hija
		return returnableData;
	}
	/**
	 * Dejar todos los campos de texto en blanco
	 */
	public void resetAllFieldsMRV() {
		super.resetAllGeneralFields();
		salaryMRPField.setText("");
	}

	public JTextField getSalaryMRPField() {
		return salaryMRPField;
	}

	public void setSalaryMRPField(JTextField salaryMRPField) {
		this.salaryMRPField = salaryMRPField;
	}

}
