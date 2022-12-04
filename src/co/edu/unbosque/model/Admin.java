package co.edu.unbosque.model;

/**
 * <h2>Admin</h2>
 * Clase que sirve como modelo del administrador, asi que contiene todos los atributos del administrador.
 * 
 * @author J&M Sistemas
 */

public class Admin {
	
	private String name;
	private String username;
	private String password;
	
	/**
	 * El constructor de la clase es usado para pasarle los atributos de administrador
	 * en los parametros del mismo.
	 * 
	 * @param name
	 * @param username
	 * @param password
	 */
	
	public Admin(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
