package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Clase que sirve de central de datos
 * @author J&M Sistemas
 *
 */
public class AppDTO implements AppDAO{
	
	
	//CSV
	String file = "data/datos.csv";
	BufferedReader reader = null;
	String line = "";
	
	
	public AppDTO() {
		
	}
	
	@Override
	public void addUser(User user) {
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

	
	//Debug
	@Override
	public void displayDB() {
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				
				String[] row = line.split(";");
				/*
				 * row[0] = ID
				 * row[1] = Nombre
				 * row[2] = Apellido1
				 * row[3] = Apellido2
				 * row[4] = Sexo
				 * 
				 * row[5] = Usuario
				 * row[6] = Contraseña
				 * 
				 * row[7] = Correo
				 * row[8] = Fecha Nacimiento
				 * row[9] = Edad
				 * row[10] = Ingresos
				 * row[11] = Divorcio
				 * row[12] = No.LikesRecibidos
				 * row[13] = No.LikesEnviados
				 * row[14] = No.Matches
				 * row[15] = Estado
				 * 
				 */
				
				for(String x : row) {
					System.out.printf("%-30s", x);
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

	@Override
	public boolean checkUser(String username, String password) {
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				
				String row[] = line.split(";");
				//Checkear columna de usuario y contraseña
				if(row[5].equals(username) && row[6].equals(password)) {
					return true;
				}
			}
			return false;
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Falló el reader");
			return false;
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
