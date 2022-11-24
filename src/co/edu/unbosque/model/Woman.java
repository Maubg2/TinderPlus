package co.edu.unbosque.model;

import java.util.Date;

public class Woman extends User{

	private boolean isDivorced = false;
	private String isDivorcedString;
	
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced);
		
	}

	public String getIsDivorced() {
		return isDivorced ? "SI" : "NO";
		
	}

	public void setDivorced(boolean isDivorced) {
		this.isDivorced = isDivorced;
	}

}
