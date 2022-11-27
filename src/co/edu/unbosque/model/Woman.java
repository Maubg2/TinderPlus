package co.edu.unbosque.model;

import java.util.Date;

public class Woman extends User{

	private boolean isDivorced = false;
	private String isDivorcedString;
	
	//Mujeres sin altura
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced);
		this.isDivorced = isDivorced;
		
	}
	//Mujeres con altura
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int height) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced, height);
		this.isDivorced = isDivorced;
	}

	public String getIsDivorced() {
		return isDivorced ? "SI" : "NO";
		
	}

	public void setDivorced(boolean isDivorced) {
		this.isDivorced = isDivorced;
	}

}
