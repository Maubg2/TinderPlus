package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase que contiene funcionalidades varias
 * @author J&M Sistemas
 *
 */
public class Toolkit {
	
	final static String illegalChar[]= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
			"°", "|", "!", "#", "\"", "$", "%", "&", "/", "(", ")", "=", "?",
			"'", "\\", "¡", "¿", "¨", "+", "*", "´", "~", "}", "]", "`", "{",
			"[", "^", ",", ";", ".", ":", "-", "_", "@", "¬"};
	
	final static String[] charactersArray = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d","f", "g", "h",
			"j", "k", "l", "ñ", "z", "x", "c", "v", "b", "n", "m"};
	
	public Toolkit() {
		
	}
	
	//Check String
	public static boolean checkData(String data) {
		for(String x : illegalChar) {
			if(data.contains(x)) {
				return false; 
			}
		}
		return true;
	}
	
	public static boolean isFullName(String name) {
		int spacesInName = 0;
		for(char x : name.toCharArray()) {
			if(x == ' ') { //si encuentra un espacio (Deben haber 2)
				spacesInName++;
			}
		}
		
		return spacesInName == 2 ? true: false;
	}
	
	public static boolean checkNumber(String data) {
		for(String x : charactersArray) {
			if(data.contains(x)) {
				return false; 
			}
		}
		return true;
	}
	
	public static Date parseDateAsString(String date) {
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDate = null;
		
		try {
			parsedDate = ft.parse(date);
		}catch(ParseException e) {
			System.out.println("Error convirtiendo la fecha a formato Date (Toolkit: 52)");
		}
		return parsedDate;
	}
	
	public static void sendMail(User target) {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(prop);
		String sourceMail = "registerbottinder@gmail.com";
		String sourceMailPassword = "xujfajvbmhjmxyms";
		String targetMail = target.getMail();
		//System.out.println("Target mail: " + target.getMail());
		String header = "Gracias por registrarse en TinderPlus";
		String body = "Bienvenido " + target.getFirstName() + " a TinderPlus!"
				+ "\nSu nombre de usuario es: " + target.getUsername()
						+ "\nSu contraseña es: " + target.getPassword()
						+ "\nEsperamos que le sea de agrado nuestro software!"
						+ "\nRealizado por J&M Sistemas (Yeferson Acosta, Jessica Bogotá, Mauricio Beltrán y Johann Toncon)";
		MimeMessage mail = new MimeMessage(session);
		try {
			mail.setFrom(new InternetAddress(sourceMail));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(targetMail));
			mail.setSubject(header);
			mail.setText(body);
			
			Transport proto = session.getTransport("smtp");
			proto.connect(sourceMail, sourceMailPassword);
			proto.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			proto.close();
		}catch(AddressException e) {
			System.out.println("Error con las direcciones de correo");
		}catch(MessagingException e) {
			System.out.println("Error creando el mensaje del correo");
			e.printStackTrace();
		}
	}
}
