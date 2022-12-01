package co.edu.unbosque.model;

import java.io.IOException;

public interface AppDAO {
	void addUser(User user);
	User searchUser(String username);
	void deleteUser();
	void modifyUser(String newValue, String username, String parameter) throws IOException;
	
	void displayDB(); //Debug
	boolean checkUser(String username, String password);
	boolean checkAdmin(String username, String password);
	
	
}
