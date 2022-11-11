package co.edu.unbosque.view;

import co.edu.unbosque.model.Man;
import co.edu.unbosque.model.User;
import co.edu.unbosque.model.Woman;

public class UserFactory {
	
	
	
	public UserFactory() {
		
	}
	
	//Ningún dato puede ser nulo
	public static User createMan(String username, int age, String mail, String gender,int height, double salary, String name) {
		return new Man(username, age, mail, gender, height, salary, name);
	
	}
	
	public static User createWoman(String username, int age, String mail, String name) {
		return new Woman(username, age, mail, name);
	}
	
	
	
}
