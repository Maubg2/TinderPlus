package co.edu.unbosque.model;

import java.util.Date;


/**
 * <h2>Woman</h2>
 * Clase que hereda atributos de usuario, que sirve como modelo de un usuario 
 * cuando es mujer, asi que contiene todos sus atributos.
 * 
 * @author J&M Sistemas
 */
public class Woman extends User{

	private boolean isDivorced = false;
	private String isDivorcedString;
	
	/**
	 * En el constructor estan todos los atributos correspondientes a la mujer en los parametros (sin la altura). 
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
	 */
	//Mujeres sin altura
	public Woman(String username, String password, String name, int age, String mail, Date bornDate, boolean isAvailable, boolean isDivorced, String gender, int likesAmount, int likesSent) {
		super(username, age, mail, gender, name, isAvailable, bornDate, password, isDivorced, likesAmount, likesSent);
		this.isDivorced = isDivorced;
		
	}
	/**
	 * En el constructor estan todos los atributos correspondientes a la mujer en los parametros (con la altura).
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
	 */
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
