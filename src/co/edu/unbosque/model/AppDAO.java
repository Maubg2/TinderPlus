package co.edu.unbosque.model;

import java.io.IOException;

/**
 * <h2>AppDAO</h2>
 * Es la interface que contiene el CRUD que va a ser utilizado por el administrador.
 * 
 * @author J&M Sistemas
 */

public interface AppDAO {
	void addUser(User user);
	User searchUser(String username);
	void deleteUser(User user);
	void modifyUser(String newValue, String username, String parameter) throws IOException;
	
	void displayDB(); //Debug
	boolean checkUser(String username, String password);
	boolean checkAdmin(String username, String password);
	
	
	
}
