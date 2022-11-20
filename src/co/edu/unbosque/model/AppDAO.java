package co.edu.unbosque.model;

public interface AppDAO {
	void addUser(User user);
	User searchUser(String username);
	void modifyUser();
	void deleteUser();
	
	void displayDB(); //Debug
	boolean checkUser(String username, String password);
	boolean checkAdmin(String username, String password);
}
