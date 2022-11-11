package co.edu.unbosque.model;

public class Man extends User{

	private double salary;
	
	public Man(String username, int age, String mail, int height, double salary) {
		super(username, age, mail, height);
		
		this.salary = salary;
	}

}
