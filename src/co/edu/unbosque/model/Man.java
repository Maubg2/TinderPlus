package co.edu.unbosque.model;

public class Man extends User{

	private double salary;
	
	public Man(String username, int age, String mail, String gender,int height, double salary, String name) {
		super(username, age, mail, gender, name ,height);
		
		this.salary = salary;
	}

}
