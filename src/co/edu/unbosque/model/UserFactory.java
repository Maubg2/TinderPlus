package co.edu.unbosque.model;

import java.util.Date;

/**
 * Clase únicamente diseñada para crear objetos (Patrón GRASP)
 * @author J&M Sistemas
 *
 */
public class UserFactory {
	
	
	
	public UserFactory() {
		
	}
	
	//Ningún dato puede ser nulo
	public static User createMan(String username, int age, String mail, String gender,int height, double salary, String name, boolean isAvailable, Date bornDate, String password) {
		return new Man(username, age, mail, gender, height, salary, name, isAvailable, bornDate, password);
	
	}
	
	public static User createWoman(String username, int age, String mail, String name) {
		return new Woman(username, age, mail, name);
	}
	
	
	
}
