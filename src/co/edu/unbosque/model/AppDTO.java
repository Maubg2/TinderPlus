package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * 
 * Clase que sirve de central de datos
 * @author J&M Sistemas
 *
 */
public class AppDTO implements AppDAO{
	
	private ArrayList<User> DataBase = new ArrayList<User>();
	
	
	public AppDTO() {
		
	}
	
	@Override
	public void addUser(User user) {
		DataBase.add(user);
	}

	@Override
	public User searchUser(String username) {
		return null;
	}

	@Override
	public void modifyUser() {
		
	}

	@Override
	public void deleteUser() {
		
	}
}
