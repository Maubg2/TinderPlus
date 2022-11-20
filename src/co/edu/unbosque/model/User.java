package co.edu.unbosque.model;

public class User {
	
	protected String username;
	protected String name;
	protected int age;
	protected String mail;
	protected int height; //Obligatorio para hombres, opcional para mujeres
	protected String gender;
	
	//Para mujeres
	public User(String username, int age, String mail, String gender, String name) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.gender = gender;
		this.name = name;
	}
	
	//Para hombres, porque la altura es obligatoria
	public User(String username, int age, String mail, String gender, String name, int height) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.height = height;
		this.gender = gender;
		this.name = name;
		
	}
	
	
	//Por completar
	public void sendLike() {
		
	}
	
	//por completar
	public void sendDislike() {
		
	}
}
