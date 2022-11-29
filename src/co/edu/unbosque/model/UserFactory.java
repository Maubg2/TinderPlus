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
	public static User createMan(String username, int age, String mail, String gender,int height, double salary, String name, boolean isAvailable, Date bornDate, String password, int likesAmount, int likesSent) {
		return new Man(username, age, mail, gender, height, salary, name, isAvailable, bornDate, password, likesAmount, likesSent);
	
	}
	
	public static User createWoman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int likesAmount, int likesSent) {
		return new Woman(username, password, name, age, mail, bornDate, isAvailable, isDivorced, gender, likesAmount, likesSent);
	}
	public static User createWoman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int height, int likesAmount, int likesSent) {
		return new Woman(username, password, name, age, mail, bornDate, isAvailable, isDivorced, gender, height, likesAmount, likesSent);
	}
	
	//Admin creator
	public static Admin createAdmin(String name, String username, String password) {
		return new Admin(name, username, password);
	}
	
	
}
