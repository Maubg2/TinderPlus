package co.edu.unbosque.model;

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
		
	public static boolean checkNumber(String data) {
		for(String x : charactersArray) {
			if(data.contains(x)) {
				return false; 
			}
		}
		return true;
	}
}
