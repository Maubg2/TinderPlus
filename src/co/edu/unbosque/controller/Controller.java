package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener{
	
	private MainView MV;
	
	public Controller() {
		MV = new MainView();
		setListeners();
	/*	MV.setSize(700,600);
		MV.setLocationRelativeTo(null);
		MV.setVisible(true);*/
	}
	
	public void setListeners() {
		//MainPanel Listeners
		MV.getMP().getLogInButton().addActionListener(this);
		MV.getMP().getLogInButton().setActionCommand("iniciarSesion");
		MV.getMP().getSignInButton().addActionListener(this);
		MV.getMP().getSignInButton().setActionCommand("registrarse");
		
		//LoginView Listeners
		MV.getLV().getBackButton().addActionListener(this);
		MV.getLV().getBackButton().setActionCommand("backLoginView");
		MV.getLV().getLoginButton().addActionListener(this);
		MV.getLV().getLoginButton().setActionCommand("loginButtonLoginView");
		
		//RegisterView Listeners
		MV.getRV().getLeaveButton().addActionListener(this);
		MV.getRV().getLeaveButton().setActionCommand("backRegisterView");
		MV.getRV().getNextButton().addActionListener(this);
		MV.getRV().getNextButton().setActionCommand("nextButtonRegisterView");
		
		//MenRegisterView Listeners
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "iniciarSesion":
			System.out.println("Debug");
			MV.getMP().setVisible(false);
			MV.getLV().setVisible(true);
			break;
		case "registrarse":
			MV.getMP().setVisible(false);
			MV.getRV().setVisible(true);
			break;
		case "backLoginView":
			MV.getLV().setVisible(false);
			MV.getMP().setVisible(true);
			break;
		case "loginButton":
			break;
		case "backRegisterView":
			MV.getRV().setVisible(false);
			MV.getMP().setVisible(true);
			break;
		case "nextButtonRegisterView":
			String resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			
			switch(resRegisterComboBoxMV) {
			case "hombre":
				MV.getRV().setVisible(false);
				MV.getMRV().setVisible(true);
				break;
			case "mujer": 
				MV.getRV().setVisible(false);
				MV.getWRP().setVisible(true);
				System.out.println("Seleccionó mujer");
				break;
			}
			break;
		
		case "exitMRV":
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			break;
		case "nextMRV":
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			break;
			
			default:
			break;
		
		}
		
	}
	
}
