package co.edu.unbosque.model;

import java.util.Date;

public class Man extends User{

	private double salary;
	
	public Man(String username, int age, String mail, String gender,int height, double salary, String name, boolean isAvailable, Date bornDate, String password) {
		super(username, age, mail, gender, name ,height, isAvailable, bornDate, password);
		
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
