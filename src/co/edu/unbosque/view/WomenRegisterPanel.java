package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class WomenRegisterPanel extends GeneralRegister{
	
	private JCheckBox divorcedWRPCheck;
	private JLabel divorcedWRPLabel;
	
	public WomenRegisterPanel() {
		
		super();
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#FFA1CF"));
		
		divorcedWRPCheck = new JCheckBox();
		divorcedWRPCheck.setBounds(200, 242, 20, 20);
		divorcedWRPCheck.setOpaque(false);
		add(divorcedWRPCheck);
		
		divorcedWRPLabel = new JLabel("Se ha divorciado:");
		divorcedWRPLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		divorcedWRPLabel.setBounds(44, 240, 150, 24);
		add(divorcedWRPLabel);
		
	}
	
}