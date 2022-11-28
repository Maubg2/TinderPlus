package co.edu.unbosque.model;

import java.util.Date;

public class Woman extends User{

	private boolean isDivorced = false;
	private String isDivorcedString;
	
	//Mujeres sin altura
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int likesAmount, int likesSent) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced, likesAmount, likesSent);
		this.isDivorced = isDivorced;
		
	}
	//Mujeres con altura
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int height, int likesAmount, int likesSent) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced, height, likesAmount, likesSent);
		this.isDivorced = isDivorced;
	}

	public String getIsDivorced() {
		return isDivorced ? "SI" : "NO";
		
	}

	public void setDivorced(boolean isDivorced) {
		this.isDivorced = isDivorced;
	}
	@Override
	public String toString() {
		return "Woman [isDivorced=" + isDivorced + ", isDivorcedString=" + isDivorcedString + ", username=" + username
				+ ", name=" + name + ", firstName=" + firstName + ", firstSurname=" + firstSurname + ", lastSurname="
				+ lastSurname + ", age=" + age + ", mail=" + mail + ", height=" + height + ", gender=" + gender
				+ ", isAvailable=" + isAvailable + ", isAvailableString=" + isAvailableString + ", simpleBornDate="
				+ simpleBornDate + ", dateFormat=" + dateFormat + ", password=" + password + ", likesAmount="
				+ likesAmount + ", sentLikesAmount=" + sentLikesAmount + ", matchAmount=" + matchAmount + "]";
	}
	

}
