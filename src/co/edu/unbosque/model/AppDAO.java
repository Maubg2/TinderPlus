package co.edu.unbosque.model;

import java.io.IOException;

public interface AppDAO {
	void addUser(User user);
	User searchUser(String username);
	void modifyUser(String newValue, int row, int col) throws IOException;
	void deleteUser();
	
	void displayDB(); //Debug
	boolean checkUser(String username, String password);
	boolean checkAdmin(String username, String password);
	
}
