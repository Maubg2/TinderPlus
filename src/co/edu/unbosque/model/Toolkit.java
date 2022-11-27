package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
