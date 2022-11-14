package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.lang.Integer;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import co.edu.unbosque.model.AppDTO;
import co.edu.unbosque.model.Toolkit;
import co.edu.unbosque.model.User;
import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.UserFactory;

public class Controller implements ActionListener{
	
	private MainView MV;
	private AppDTO DTO;
	
	//Collected data
	String age;
	String name;
	String username;
	String email;
	String height;
	
	//Checking data
	boolean isNameCorrect;
	boolean isAgeCorrect;
	
	public Controller() {
		MV = new MainView();
		DTO = new AppDTO();
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
		
		//GeneralRegisterView Listeners
		MV.getMRV().getExitButton().addActionListener(this); //MenRegisterView
		MV.getMRV().getExitButton().setActionCommand("exitMRV");
		MV.getMRV().getNextButton().addActionListener(this);
		MV.getMRV().getNextButton().setActionCommand("nextMRV");
		
		MV.getWRP().getExitButton().addActionListener(this); //WomenRegisterView
		MV.getWRP().getExitButton().setActionCommand("exitWRP");
		MV.getWRP().getNextButton().addActionListener(this);
		MV.getWRP().getNextButton().setActionCommand("nextWRP");
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
			//Pendiente
			break;
		case "backRegisterView":
			MV.getRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar campos
			MV.getRV().setNameField("");
			break;
		case "nextButtonRegisterView":
			String resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			String resUsernameFieldRegister = MV.getRV().getNameField().getText();
			
			if(resUsernameFieldRegister.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Información", JOptionPane.WARNING_MESSAGE); //INFORMATION_MESSAGE, QUESTION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE
			}else {
				switch(resRegisterComboBoxMV) {
				case "hombre":
					MV.getRV().setVisible(false);
					MV.getMRV().setVisible(true);
					break;
				case "mujer": 
					MV.getRV().setVisible(false);
					MV.getWRP().setVisible(true);
					break;
				}
			}
			break;
		
		case "exitMRV":
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar valores
			MV.getRV().setNameField("");
			break;
		case "nextMRV": //Boton siguiente hombre
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Recolectar datos y crear objeto
			//resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			name = MV.getMRV().getUsernameRegField().getText();
			username = 
			age = MV.getMRV().getAgeRegField().getText();
			email = MV.getMRV().getMailRegField().getText();
			height = MV.getMRV().getHeightRegField().getText();
			String salary = MV.getMRV().getSalaryMRPField().getText();
			
			isNameCorrect = Toolkit.checkData(name);
			isAgeCorrect = Toolkit.checkNumber(age);
			//Eliminar campos de texto
			break;
		case "exitWRP":
			MV.getWRP().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar valores
			MV.getRV().setNameField("");
			break;
		case "nextWRP": //Recoger datos de mujer
			//System.out.println("Next woman");
			MV.getWRP().setVisible(false);
			name = MV.getWRP().getUsernameRegField().getText();
			age = MV.getWRP().getAgeRegField().getText();
			username = MV.getRV().getNameField().getText();
			email = MV.getWRP().getMailRegField().getText();
			height = MV.getWRP().getHeightRegField().getText(); //Opcional
			boolean isDivorced = MV.getWRP().getCheckBox().isSelected();
			System.out.println(isDivorced);
			isNameCorrect = Toolkit.checkData(name);
			isAgeCorrect = Toolkit.checkNumber(name);

			if(isNameCorrect && isAgeCorrect) {
													//Username
				//User newUser = UserFactory.createMan(username, Integer.parseInt(age), email, "hombre", Integer.parseInt(height), Integer.parseInt(salary), name);
				//DTO.addUser(newUser);
			//} else if(name == null || age == null || username == null || email == null || height == null || salary == null) {
				JOptionPane.showMessageDialog(null, "Error :)", "información", JOptionPane.PLAIN_MESSAGE);
			}
													
			
			//Eliminar campos de texto
			break;
		default:
			break;
		
		}
		
	}
	
}
