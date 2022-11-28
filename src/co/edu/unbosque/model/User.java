package co.edu.unbosque.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	protected String username;
	protected String name;
	protected String firstName;
	protected String firstSurname;
	protected String lastSurname;
	protected int age;
	protected String mail;
	protected int height; //Obligatorio para hombres, opcional para mujeres
	protected String gender;
	protected boolean isAvailable;
	protected String isAvailableString;
	protected String simpleBornDate;
	protected DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	protected String password;
	
	//Likes
	protected int likesAmount = 0;
	protected int sentLikesAmount = 0;
	protected int matchAmount = 0;
	
	//Para mujeres (Sin altura)
	public User(String username, int age, String mail, String gender, String name, boolean isAvailable, Date bornDate, String password, boolean isDivorced, int likesAmount, int likesSent) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.gender = gender;
		this.name = name;
		this.isAvailable = isAvailable;
		this.simpleBornDate = dateFormat.format(bornDate);
		this.likesAmount = likesAmount;
		this.sentLikesAmount = likesSent;
		divideName();
		setupData();
	}
	//Para mujeres (Con altura)
	public User(String username, int age, String mail, String gender, String name, boolean isAvailable, Date bornDate, String password, boolean isDivorced, int height, int likesAmount, int likesSent) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.gender = gender;
		this.name = name;
		this.isAvailable = isAvailable;
		this.simpleBornDate = dateFormat.format(bornDate);
		this.height = height;
		this.likesAmount = likesAmount;
		this.sentLikesAmount = likesSent;
		divideName();
		setupData();
	}
	
	//Para hombres, porque la altura es obligatoria
	public User(String username, int age, String mail, String gender, String name, int height, boolean isAvailable, Date bornDate, String password, int likesAmount, int likesSent) {
		this.username = username;
		this.age = age;
		this.mail = mail;
		this.height = height;
		this.gender = gender;
		this.name = name;
		this.password = password;
		this.isAvailable = isAvailable;
		this.simpleBornDate = dateFormat.format(bornDate);
		this.likesAmount = likesAmount;
		this.sentLikesAmount = likesSent;
		divideName();
		setupData();
		
	}
	
	public void divideName() {
		String[] names = name.split(" ");
		firstName = names[0];
		firstSurname = names[1];
		lastSurname = names[2];
	}
	public void setupData() {
		gender = gender.toLowerCase();
		switch(gender){
		case "hombre", "h":
			gender = "H";
			break;
		case "mujer", "m":
			gender = "M";
			break;
		default:
			System.out.println("El género no se reconoció (User: 87)");
			break;
		}
		
		if(isAvailable) {
			isAvailableString = "Disponible";
		}else {
			isAvailableString = "Inactivo";
		}
	}
	
	
	//Por completar
	public void sendLike() {
		
	}
	
	//por completar
	public void sendDislike() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getLastSurname() {
		return lastSurname;
	}

	public void setLastSurname(String lastSurname) {
		this.lastSurname = lastSurname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getSimpleBornDate() {
		return simpleBornDate;
	}

	public void setSimpleBornDate(String simpleBornDate) {
		this.simpleBornDate = simpleBornDate;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLikesAmount() {
		return likesAmount;
	}

	public void setLikesAmount(int likesAmount) {
		this.likesAmount = likesAmount;
	}

	public int getSentLikesAmount() {
		return sentLikesAmount;
	}

	public void setSentLikesAmount(int sentLikesAmount) {
		this.sentLikesAmount = sentLikesAmount;
	}

	public int getMatchAmount() {
		return matchAmount;
	}

	public void setMatchAmount(int matchAmount) {
		this.matchAmount = matchAmount;
	}

	public String getIsAvailableString() {
		return isAvailableString;
	}

	public void setIsAvailableString(String isAvailableString) {
		this.isAvailableString = isAvailableString;
	}
	
	
	
	
}
