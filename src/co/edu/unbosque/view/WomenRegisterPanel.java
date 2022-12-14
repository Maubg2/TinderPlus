package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
/**
 * <h2>WomenRegisterPanel</h2>
 * Clase creada para especificamente para el registro de mujeres
 * 
 * @author J&M Sistemas 
 */
public class WomenRegisterPanel extends GeneralRegister{
	
	private JCheckBox divorcedWRPCheck;
	private JLabel divorcedWRPLabel;
	/**
	 * Constructor de la clase
	 */
	public WomenRegisterPanel() {
		
		super();
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
		divorcedWRPCheck = new JCheckBox();
		divorcedWRPCheck.setBounds(410, 278, 20, 20);
		divorcedWRPCheck.setOpaque(false);
		//divorcedWRPCheck.setText(); Para ponerle texto sin usar un Label
		//divor....setIcon(); //Para cambiar el icono de desmarcado; divor....setSelectedIcon() //Para cambiar el ícono de marcado
		divorcedWRPCheck.setFocusable(false);
		add(divorcedWRPCheck);
		
		divorcedWRPLabel = new JLabel("Se ha divorciado:");
		divorcedWRPLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		divorcedWRPLabel.setBounds(264, 276, 150, 24);
		add(divorcedWRPLabel);
		
	}
	/**
	 * Retorna los datos recolectados (en un ArrayList) en el proceso de registro
	 * @return
	 */
	public ArrayList<Object> collectWomenData(){
		ArrayList<Object> returnableData = super.collectData();
		returnableData.add(divorcedWRPCheck.isSelected());
		return returnableData;
	}
	/**
	 * Dejar todos los campos de texto en blanco
	 */
	public void resetAllDataWRV() {
		super.resetAllGeneralFields();
		divorcedWRPCheck.setSelected(false);
	}
	
}
