package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.model.Admin;
import co.edu.unbosque.model.AppDTO;
import co.edu.unbosque.model.Man;
import co.edu.unbosque.model.Toolkit;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.UserFactory;
import co.edu.unbosque.model.Woman;
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
	boolean isDivorced; //Solo mujeres
	String salary; //Solo hombres
	
	//User & Password & Gender
	String resRegisterComboBoxMV; //Gender
	String resUsernameFieldRegister; //Username(Not full name)
	String resPasswordFieldRegister; //Password
	
	//Checking data
	boolean isNameCorrect;
	boolean isFullName;
	boolean isAgeCorrect;
	boolean isHeightCorrect;
	boolean isSalaryCorrect;
	
	//Random data
	String randomImage;
	User randomUser;
	
	//Logged user
	User actualUser;
	
	//Logged admin
	Admin actualAdmin;
	
	/**
	 * Constructor de la clase, usado para instanciar los objetos importnates como la vista 
	 * principal, el DTO y el usuario Admin
	 */
	public Controller() {
		MV = new MainView();
		DTO = new AppDTO();
		setListeners();
	/*	MV.setSize(700,600);
		MV.setLocationRelativeTo(null);
		MV.setVisible(true);*/
		//DTO.displayDB(); //Debug
		
		//Admin init
		//DTO.addUser(UserFactory.createAdmin("Administrador", "admin", "1234"));
		setMainInvariants();
		
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
		
		//Main user view listeners
		MV.getMUV().getBackButtonUser().addActionListener(this);
		MV.getMUV().getBackButtonUser().setActionCommand("backMUV");
		
		MV.getMUV().getLikeButtonUser().addActionListener(this);
		MV.getMUV().getLikeButtonUser().setActionCommand("likeMUV");
		
		MV.getMUV().getDislikeButtonUser().addActionListener(this);
		MV.getMUV().getDislikeButtonUser().setActionCommand("dislikeMUV");
		
		//Main admin view listeners (CRUD)
		MV.getMAV().getAddAdminView().addActionListener(this);
		MV.getMAV().getAddAdminView().setActionCommand("addUserAdmin");
		
		MV.getMAV().getModifyAdminView().addActionListener(this);
		MV.getMAV().getModifyAdminView().setActionCommand("modifyUserAdmin");
		
		MV.getMAV().getDeleteAdminView().addActionListener(this);
		MV.getMAV().getDeleteAdminView().setActionCommand("deleteUserAdmin");
		
		MV.getMAV().getSearchAdminView().addActionListener(this);
		MV.getMAV().getSearchAdminView().setActionCommand("searchUserAdmin");
		
		MV.getMAV().getBackButtonAdmin().addActionListener(this);
		MV.getMAV().getBackButtonAdmin().setActionCommand("backAdminView");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case "iniciarSesion":
			//System.out.println("Debug");
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
			assert !username.isEmpty(): "El nombre no debe estar vacío"; 
			assert !password.isEmpty(): "La contraseña no debe estar vacía";
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
					
					//Cargar usuario actual
					actualUser = DTO.searchUser(username);
					assert actualUser != null: "El usuario logueado no debe ser nulo";
					//System.out.println(actualUser.toString()); //Debug
					
					//Cargar datos
					randomUser = DTO.retrieveRandomUser();
					assert randomUser != null: "El usuario random no debe ser nulo";
					MV.getMUV().setNameValue(randomUser.getName());
					MV.getMUV().setUsernameValue(randomUser.getUsername());
					MV.getMUV().setAgeValue(Integer.toString(randomUser.getAge()));
					MV.getMUV().setHeightValue(Integer.toString(randomUser.getHeight()));
					if(randomUser.getClass().getSimpleName().toLowerCase().equals("man")) {
						MV.getMUV().setSalaryValue(Double.toString(((Man)randomUser).getSalary()));
						MV.getMUV().setDivorceValue("No aplica");
					}
					else if(randomUser.getClass().getSimpleName().toLowerCase().equals("woman")) {
						MV.getMUV().setDivorceValue(((Woman) randomUser).getIsDivorced());
						MV.getMUV().setSalaryValue("No aplica");
					}
					MV.getMUV().updateUserData();
					
				}
				else if(validAdmin) {
					//System.out.println("Probando admin");
					MV.getLV().setVisible(false);
					MV.getMAV().setVisible(true);
					MV.getLV().setUserField("");
					MV.getLV().setPsswdField("");
					actualAdmin = DTO.searchAdmin(username);
					assert actualAdmin != null: "El administrador actual no debe ser nulo";
				}else {
					MV.getLV().setPsswdField("");
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
			break;
		case "backRegisterView":
			if(actualAdmin != null) {
				//Volver al panel de admin si es administrador
				MV.getRV().setVisible(false);
				MV.getMAV().setVisible(true);
				
				//Reiniciar campos (Si es admin)
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				
			}else {
				//Volver al panel principal si es usuario
				MV.getRV().setVisible(false);
				MV.getMP().setVisible(true);
				
				//Reiniciar campos (Si es usuario)
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
			}
			break;
		case "nextButtonRegisterView":
			resRegisterComboBoxMV = MV.getRV().getRegisterGenderBox().getSelectedItem().toString().toLowerCase();
			resUsernameFieldRegister = MV.getRV().getNameField().getText();
			resPasswordFieldRegister = String.valueOf(MV.getRV().getPasswordField().getPassword());
			assert !resRegisterComboBoxMV.isEmpty() && !resUsernameFieldRegister.isEmpty() && !resPasswordFieldRegister.isEmpty(): "Los datos del registro principal no deben estar vacíos";
			
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
			
			if(actualAdmin != null) {
				//Volver al panel principal de admin
				MV.getMRV().setVisible(false);
				MV.getMAV().setVisible(true);
				//Reiniciar valores
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				MV.getMRV().resetAllFieldsMRV();
			}else {
				//Volver al panel principal de usuario
				MV.getMRV().setVisible(false);
				MV.getMP().setVisible(true);
				//Reiniciar valores
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				MV.getMRV().resetAllFieldsMRV();
			}
			
				
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
			assert (Integer.parseInt(age) < 18): "La edad no debe ser menor a 18";
			email = (String) collectedMenData.get(2);
			height = (String) collectedMenData.get(3);
			bornDate = Toolkit.parseDateAsString((String)collectedMenData.get(4));
			isAvailable = (boolean) collectedMenData.get(5);
			salary = (String) collectedMenData.get(6);
			
			//Debug
			//System.out.println("Nombre: " + name + "\n" + "Edad: " + age + "\n" + "Email: " + email + "\n" + "Altura: " + height + "\nFecha: " + bornDate + "\nDisponible: " + isAvailable + "\nSalario: " + salary);
			
			//Checkear validez de datos
			isNameCorrect = Toolkit.checkData(name); 
			if(!isNameCorrect) {
				JOptionPane.showMessageDialog(null, "El nombre no debe contener caracteres especiales", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			isFullName = Toolkit.isFullName(name); //Debe tener 1 nombre y 2 apellidos
			if(!isFullName) {
				JOptionPane.showMessageDialog(null, "Debe ingresar 1 nombre y 2 apellidos", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			isAgeCorrect = Toolkit.checkNumber(age);
			if(!isAgeCorrect) {
				JOptionPane.showMessageDialog(null, "La edad deberían ser solo números", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			isSalaryCorrect = Toolkit.checkNumber(salary);
			if(!isSalaryCorrect) {
				JOptionPane.showMessageDialog(null, "El salario debe ser correcto", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			isHeightCorrect = Toolkit.checkNumber(height);
			if(!isHeightCorrect) {
				JOptionPane.showMessageDialog(null, "La altura debe ser correcta", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
			
			if(isNameCorrect && isFullName && isAgeCorrect && isSalaryCorrect && isHeightCorrect) {
				//Crear objeto y agregarlo a la base de datos
				User newUser = UserFactory.createMan(resUsernameFieldRegister, Integer.parseInt(age), email, resRegisterComboBoxMV, Integer.parseInt(height), Double.parseDouble(salary), name, isAvailable, bornDate, resPasswordFieldRegister, 0, 0);
				//System.out.println(newUser.getClass().getSimpleName());
				DTO.addUser(newUser); //Está dejando muchos espacios antes en el csv
				
				//Eliminar campos de texto
				MV.getMRV().resetAllFieldsMRV();
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				
				//Enviar correo de información
				Toolkit.sendMail(newUser);
				//Mirar quién fue el que entró a esta vista
				if(actualAdmin != null) {
					MV.getMRV().setVisible(false);
					MV.getMAV().setVisible(true);
					JOptionPane.showMessageDialog(null, "Usuario creado exitosamente\nVolverá al panel del administrador", "Información", JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					MV.getMRV().setVisible(false);
					MV.getMP().setVisible(true);
					JOptionPane.showMessageDialog(null, "Usuario creado exitosamente\nInicie sesión a continuación", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
			break;
			
		//Woman register view
		case "exitWRP":
			//Si fue el usuario quien ingresó al resgitro, al volver volverá a la página principal
			//Si fue el administrador quien ingresó, al volver volverá al panel principal de admin
			if(actualAdmin != null) {
				//Volver al panel principal de admin
				MV.getWRP().setVisible(false);
				MV.getMAV().setVisible(true);
				//Reiniciar valores
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				MV.getWRP().resetAllDataWRV();
				
			}else {
				//Volver al panel principal de usuario
				MV.getWRP().setVisible(false);
				MV.getMP().setVisible(true);
				//Reiniciar valores
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				MV.getWRP().resetAllDataWRV();
			}
			break;
			
		case "nextWRP": //Recoger datos de mujer (Botón siguiente mujer)
			//System.out.println("Next woman");
			ArrayList<Object> collectedWomanData = MV.getWRP().collectWomenData();
			
			/* collectedWomanData summary: Aquí no se incluye el usuario y la contraseña de RV
			 * 	for(Object x : collectedWomanData) {
				System.out.println(x);
			}
			 * 0. Username (Full name)
			 * 1. Age
			 * 2. Mail
			 * 3. Height
			 * 4. Born date
			 * 5. isAvailable (boolean)
			 * 6. isDivorced
			 */
			name = (String) collectedWomanData.get(0);
			age = (String) collectedWomanData.get(1);
			email = (String) collectedWomanData.get(2);
			if(!MV.getWRP().getHeightRegField().getText().isEmpty()) {
				height = (String) collectedWomanData.get(3);
			}
			bornDate = Toolkit.parseDateAsString((String) collectedWomanData.get(4));
			isAvailable = (boolean) collectedWomanData.get(5);
			isDivorced = (boolean) collectedWomanData.get(6);
			
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
				if(!MV.getWRP().getHeightRegField().getText().isEmpty()) { //Si puso altura
					isHeightCorrect = Toolkit.checkNumber(height);
					if(isHeightCorrect) {
						User newUser = UserFactory.createWoman(resUsernameFieldRegister, resPasswordFieldRegister, name, Integer.parseInt(age), email, bornDate, isAvailable, isDivorced, resRegisterComboBoxMV, Integer.parseInt(height), 0, 0);
						//System.out.println(newUser.getPassword());
						DTO.addUser(newUser);
						Toolkit.sendMail(newUser);
					}else {
						JOptionPane.showMessageDialog(null, "La altura debe ser correcta", "Alerta", JOptionPane.WARNING_MESSAGE);
					}
					
				}else { //Si no puso altura
					User newUser = UserFactory.createWoman(resUsernameFieldRegister, resPasswordFieldRegister, name, Integer.parseInt(age), email, bornDate, isAvailable, isDivorced, resRegisterComboBoxMV, 0, 0);
					DTO.addUser(newUser);
					Toolkit.sendMail(newUser);
				}
				//Mirar quién fue el que entró a esta vista
				if(actualAdmin != null) {
					MV.getWRP().setVisible(false);
					MV.getMAV().setVisible(true);
					JOptionPane.showMessageDialog(null, "Usuario creado exitosamente\nVolverá al panel del administrador", "Información", JOptionPane.INFORMATION_MESSAGE);
					
				}else{ //Fue un usuario
					MV.getWRP().setVisible(false);
					MV.getMP().setVisible(true);
					JOptionPane.showMessageDialog(null, "Usuario creado exitosamente\nInicie sesión a continuación", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
				}
				//Eliminar campos de texto
				MV.getRV().setNameField("");
				MV.getRV().setPasswordField("");
				MV.getWRP().resetAllDataWRV();
				
			}
			break;
			
		//MainUserView
		case "backMUV":
			MV.getMUV().setVisible(false);
			MV.getMP().setVisible(true);
			
			//Eliminar al usuario actual
			actualUser = null;
			
			break;
			
		case "likeMUV":
			//Cambiar foto y datos
			randomImage = DTO.retrieveImageSrc();
			//System.out.println(randomImage); //Debug
			MV.getMUV().setRandomImage(randomImage);
			MV.getMUV().updateImage();
			
			//Actualizar datos
			randomUser = DTO.retrieveRandomUser();
			try {
			MV.getMUV().setNameValue(randomUser.getName());
			MV.getMUV().setUsernameValue(randomUser.getUsername());
			MV.getMUV().setAgeValue(Integer.toString(randomUser.getAge()));
			MV.getMUV().setHeightValue(Integer.toString(randomUser.getHeight()));
			
			//Give like
			randomUser.setLikesAmount(randomUser.getLikesAmount() + 1);
			actualUser.setSentLikesAmount(actualUser.getSentLikesAmount() + 1);
			//Debug
			//System.out.println("Likes enviados: " + actualUser.getSentLikesAmount());
			
			//Actualizar datos especiales
			if(randomUser.getClass().getSimpleName().toLowerCase().equals("man")) {
				MV.getMUV().setSalaryValue(Double.toString(((Man)randomUser).getSalary()));
				MV.getMUV().setDivorceValue("No aplica");
			}
			else if(randomUser.getClass().getSimpleName().toLowerCase().equals("woman")) {
				MV.getMUV().setDivorceValue(((Woman) randomUser).getIsDivorced());
				MV.getMUV().setSalaryValue("No aplica");
			}
			MV.getMUV().updateUserData();
			}catch(NullPointerException x) {
				System.out.println("No se pudo extraer un usuario al azar");
			}
			break;
			
		case "dislikeMUV":
			//Cambiar foto
			randomImage = DTO.retrieveImageSrc();
			MV.getMUV().setRandomImage(randomImage);
			MV.getMUV().updateImage();
			
			//Actualizar datos
			randomUser = DTO.retrieveRandomUser();
			MV.getMUV().setNameValue(randomUser.getName());
			MV.getMUV().setUsernameValue(randomUser.getUsername());
			MV.getMUV().setAgeValue(Integer.toString(randomUser.getAge()));
			MV.getMUV().setHeightValue(Integer.toString(randomUser.getHeight()));
			if(randomUser.getClass().getSimpleName().toLowerCase().equals("man")) {
				MV.getMUV().setSalaryValue(Double.toString(((Man)randomUser).getSalary()));
				MV.getMUV().setDivorceValue("No aplica");
			}
			else if(randomUser.getClass().getSimpleName().toLowerCase().equals("woman")) {
				MV.getMUV().setDivorceValue(((Woman) randomUser).getIsDivorced());
				MV.getMUV().setSalaryValue("No aplica");
			}
			MV.getMUV().updateUserData();
			break;
			
		//MainAdminView section
		case "addUserAdmin":
			MV.getMAV().setVisible(false);
			MV.getRV().setVisible(true);
			//DTO.addUser()
			break;
			
		case "modifyUserAdmin":
			String targetUsername = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario", "Modificar usuario", JOptionPane.INFORMATION_MESSAGE);
			String targetParameter = JOptionPane.showInputDialog(null, "Ingrese el atributo a modificar", "Modificar usuario", JOptionPane.INFORMATION_MESSAGE);
			String newValue = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor para " + targetParameter.toLowerCase(), "Modificar usuario");
			try {
				DTO.modifyUser(newValue, targetUsername, targetParameter);
				JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente"
						+ "\nUsuario: " + targetUsername + "\nParametro: " + targetParameter
						+ "\nValor final: " + newValue, "Modificar usuario" , JOptionPane.INFORMATION_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario: Error en Controller: 558", "Error", JOptionPane.ERROR_MESSAGE);
			}
			//Pendiente
			break;
		
		case "deleteUserAdmin":
			String targetUsernameToDel = JOptionPane.showInputDialog(null, "Ingrese el usuario a eliminar", "Eliminar usuario", JOptionPane.INFORMATION_MESSAGE);
			User targetUserToDel = DTO.searchUser(targetUsernameToDel);
			int confirm = JOptionPane.showConfirmDialog(null, "Está seguro de querer borrar a " + targetUserToDel.getFirstName() + "?", "Eliminar usuario", JOptionPane.YES_NO_OPTION);
			//System.out.println(confirm);
			if(confirm == 0) {
				DTO.deleteUser(targetUserToDel);
				JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Eliminar usuario", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Operación cancelada", "Eliminar usuario", JOptionPane.INFORMATION_MESSAGE);
			}
			
			break;
		
		case "searchUserAdmin":
			break;
			
		case "backAdminView":
			MV.getMAV().setVisible(false);
			MV.getMP().setVisible(true);
			
			//Eliminar al administrador actual
			actualAdmin = null;
			break;
		default:
			break;
		
		}
		
	}
	
	public void setMainInvariants() {
		assert MV != null: "La vista principal no debe ser nula";
		assert DTO != null: "El DTO no puede ser nulo";
	}
	
}
