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
	/**
	 * Crea un objeto hombre
	 * @param username
	 * @param age
	 * @param mail
	 * @param gender
	 * @param height
	 * @param salary
	 * @param name
	 * @param isAvailable
	 * @param bornDate
	 * @param password
	 * @param likesAmount
	 * @param likesSent
	 * @return
	 */
	//Ningún dato puede ser nulo
	public static User createMan(String username, int age, String mail, String gender,int height, double salary, String name, boolean isAvailable, Date bornDate, String password, int likesAmount, int likesSent) {
		return new Man(username, age, mail, gender, height, salary, name, isAvailable, bornDate, password, likesAmount, likesSent);
	
	}
	/**
	 * Crea un objeto mujer sin la altura
	 * @param username
	 * @param password
	 * @param name
	 * @param age
	 * @param mail
	 * @param bornDate
	 * @param isAvailable
	 * @param isDivorced
	 * @param gender
	 * @param likesAmount
	 * @param likesSent
	 * @return
	 */
	public static User createWoman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int likesAmount, int likesSent) {
		return new Woman(username, password, name, age, mail, bornDate, isAvailable, isDivorced, gender, likesAmount, likesSent);
	}
	/**
	 * Crea un objeto mujer con la altura
	 * @param username
	 * @param password
	 * @param name
	 * @param age
	 * @param mail
	 * @param bornDate
	 * @param isAvailable
	 * @param isDivorced
	 * @param gender
	 * @param height
	 * @param likesAmount
	 * @param likesSent
	 * @return
	 */
	public static User createWoman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int height, int likesAmount, int likesSent) {
		return new Woman(username, password, name, age, mail, bornDate, isAvailable, isDivorced, gender, height, likesAmount, likesSent);
	}
	/**
	 * Crea un objeto Administrador
	 * @param name
	 * @param username
	 * @param password
	 * @return
	 */
	//Admin creator
	public static Admin createAdmin(String name, String username, String password) {
		return new Admin(name, username, password);
	}
	
	
}
