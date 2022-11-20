package co.edu.unbosque.model;

public class Woman extends User{

	private boolean isDivorced = false;
	
	public Woman(String username, int age, String mail, String name) {
		super(username, age, mail, "mujer", name);
		
	}

}
