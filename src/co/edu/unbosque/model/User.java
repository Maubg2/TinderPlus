package co.edu.unbosque.model;

public class User {
	
	protected String username;
	protected int age;
	protected String mail;
	protected int height; //Obligatorio para hombres, opcional para mujeres
	
	//Para mujeres
	public User(String username, int age, String mail) {
		this.username = username;
		this.age = age;
		this.mail = mail;
	}
	
	//Para hombres, porque la altura es obligatoria
	public User(String username, int age, String mail, int height) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.height = height;
		
	}
	
	
	//Por completar
	public void sendLike() {
		
	}
	
	//por completar
	public void sendDislike() {
		
	}
}
