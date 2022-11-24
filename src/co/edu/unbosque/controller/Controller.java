package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import co.edu.unbosque.model.AppDTO;
import co.edu.unbosque.model.Toolkit;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.UserFactory;
import co.edu.unbosque.view.MainView;

public class Controller implements ActionListener{
	
	private MainView MV;
	private AppDTO DTO;
	
	//Collected data
	String age;
	String name;
	String username;
	String email;
	String height;
	Date bornDate;
	boolean isAvailable;
	String salary; //Solo hombres
	
	//User & Password & Gender
	String resRegisterComboBoxMV; //Gender
	String resUsernameFieldRegister; //Username(Not full name)
	String resPasswordFieldRegister; //Password
	
	//Checking data
	boolean isNameCorrect;
	boolean isFullName;
	boolean isAgeCorrect;
	
	//Random data
	String randomImage;
	
	public Controller() {
		MV = new MainView();
		DTO = new AppDTO();
		setListeners();
	/*	MV.setSize(700,600);
		MV.setLocationRelativeTo(null);
		MV.setVisible(true);*/
		//DTO.displayDB(); //Debug
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
		
		//Main user view Listeners
		MV.getMUV().getBackButtonUser().addActionListener(this);
		MV.getMUV().getBackButtonUser().setActionCommand("backMUV");
		
		MV.getMUV().getLikeButtonUser().addActionListener(this);
		MV.getMUV().getLikeButtonUser().setActionCommand("nextMUV");
		
		MV.getMUV().getDislikeButtonUser().addActionListener(this);
		MV.getMUV().getDislikeButtonUser().setActionCommand("dislikeMUV");
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
		case "loginButtonLoginView": //Boton de inicio de sesión
			//1. Traer datos de los fields
			
			//Para probar: User: juagalindo Password: P,u[2PyrjNM_:_9
			
			String username = MV.getLV().getUserField().getText();
			String password = String.valueOf(MV.getLV().getPsswdField().getPassword()); //ValueOf porque getPassword devuelve un array de chars
			//2. Mandar a buscar el usuario con esos datos
			boolean validUser = DTO.checkUser(username, password);
			boolean validAdmin = DTO.checkAdmin(username, password);
			if(validUser) {
				//System.out.println("Usuario existe");
				MV.getLV().setVisible(false);
				MV.getMUV().setVisible(true);
				MV.getLV().setUserField("");
				MV.getLV().setPsswdField("");
				
				//Crear imagenes
				randomImage = DTO.retrieveImageSrc();
				MV.getMUV().setRandomImage(randomImage);
				MV.getMUV().updateImage();
			}else if(validAdmin) {
				MV.getLV().setVisible(false);
				MV.getMAV().setVisible(true);
				MV.getLV().setUserField("");
				MV.getLV().setPsswdField("");
			}
			else {
				//System.out.println("Usuario no existe");
				MV.getLV().setPsswdField("");
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
			}
			break;
		case "backRegisterView":
			MV.getRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar campos
			MV.getRV().setNameField("");
			MV.getRV().setPasswordField("");
			break;
		case "nextButtonRegisterView":
			resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			resUsernameFieldRegister = MV.getRV().getNameField().getText();
			resPasswordFieldRegister = String.valueOf(MV.getRV().getPasswordField().getPassword());
			
			if(resUsernameFieldRegister.isEmpty() || resPasswordFieldRegister.isEmpty()) {
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
		
		//Men register view
		case "exitMRV":
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar valores
			MV.getRV().setNameField("");
			MV.getRV().setPasswordField("");
			break;
		case "nextMRV": //Boton siguiente hombre
			MV.getMRV().setVisible(false);
			MV.getMP().setVisible(true);
			//Recolectar datos y crear objeto
			/*
			//resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			name = MV.getMRV().getUsernameRegField().getText();
			username = 
			age = MV.getMRV().getAgeRegField().getText();
			email = MV.getMRV().getMailRegField().getText();
			height = MV.getMRV().getHeightRegField().getText();
			String salary = MV.getMRV().getSalaryMRPField().getText();
			*/
			ArrayList<Object> collectedMenData = MV.getMRV().collectMenData(); //Arraylist con todos los campos de texto
			
			/* collectedMenData summary: Aquí no se incluye el usuario y la contraseña de RV
			 * for(Object x : collectedMenData) {
				System.out.println(x);
			   }	
			 * 0. Username
			 * 1. Age
			 * 2. Mail
			 * 3. Height
			 * 4. Born date
			 * 5. isAvailable (boolean)
			 * 6. Salary (Caso de hombre)
			 */
			name = (String) collectedMenData.get(0);
			age = (String) collectedMenData.get(1);
			email = (String) collectedMenData.get(2);
			height = (String) collectedMenData.get(3);
			bornDate = Toolkit.parseDateAsString((String)collectedMenData.get(4));
			isAvailable = (boolean) collectedMenData.get(5);
			salary = (String) collectedMenData.get(6);
			
			//Debug
			System.out.println("Nombre: " + name + "\n" + "Edad: " + age + "\n" + "Email: " + email + "\n" + "Altura: " + height + "\nFecha: " + bornDate + "\nDisponible: " + isAvailable + "\nSalario: " + salary);
			
			isNameCorrect = Toolkit.checkData(name); 
			if(!isNameCorrect) {
				JOptionPane.showMessageDialog(null, "El nombre no debe contener caracteres especiales");
			}
			isFullName = Toolkit.isFullName(name); //Debe tener 1 nombre y 2 apellidos
			if(!isFullName) {
				JOptionPane.showMessageDialog(null, "Debe ingresar 1 nombre y 2 apellidos");
			}
			isAgeCorrect = Toolkit.checkNumber(age);
			if(!isAgeCorrect) {
				JOptionPane.showMessageDialog(null, "La edad deberían ser solo números");
			}
			
			if(isNameCorrect && isFullName && isAgeCorrect) {
				//Crear objeto y agregarlo a la base de datos
				User newUser = UserFactory.createMan(resUsernameFieldRegister, Integer.parseInt(age), email, resRegisterComboBoxMV, Integer.parseInt(height), Double.parseDouble(salary), name, isAvailable, bornDate, resPasswordFieldRegister);
				//System.out.println(newUser.getClass().getSimpleName());
				DTO.addUser(newUser);
				//Eliminar campos de texto
				
				MV.getMRV().resetAllFieldsMRV();
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
			}
			
			break;
			
		//Woman register view
		case "exitWRP":
			MV.getWRP().setVisible(false);
			MV.getMP().setVisible(true);
			//Reiniciar valores
			MV.getRV().setNameField("");
			MV.getRV().setPasswordField("");
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
			
		//MainUserView
		case "backMUV":
			MV.getMUV().setVisible(false);
			MV.getMP().setVisible(true);
			break;
			
		case "nextMUV":
			//Cambiar foto y datos
			randomImage = DTO.retrieveImageSrc();
			System.out.println(randomImage);
			MV.getMUV().setRandomImage(randomImage);
			MV.getMUV().updateImage();
			
			break;
			
		case "dislikeMUV":
			//Cambiar foto y datos
			randomImage = DTO.retrieveImageSrc();
			MV.getMUV().setRandomImage(randomImage);
			MV.getMUV().updateImage();
			break;
		default:
			break;
		
		}
		
	}
	
}
