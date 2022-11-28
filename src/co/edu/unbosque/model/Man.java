package co.edu.unbosque.model;

import java.util.Date;

public class Man extends User{

	private double salary;
	
	public Man(String username, int age, String mail, String gender,int height, double salary, String name, boolean isAvailable, Date bornDate, String password, int likesAmount, int likesSent) {
		super(username, age, mail, gender, name ,height, isAvailable, bornDate, password, likesAmount, likesSent);
		
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Man [salary=" + salary + ", username=" + username + ", name=" + name + ", firstName=" + firstName
				+ ", firstSurname=" + firstSurname + ", lastSurname=" + lastSurname + ", age=" + age + ", mail=" + mail
				+ ", height=" + height + ", gender=" + gender + ", isAvailable=" + isAvailable + ", isAvailableString="
				+ isAvailableString + ", simpleBornDate=" + simpleBornDate + ", dateFormat=" + dateFormat
				+ ", password=" + password + ", likesAmount=" + likesAmount + ", sentLikesAmount=" + sentLikesAmount
				+ ", matchAmount=" + matchAmount + "]";
	}
	

}
