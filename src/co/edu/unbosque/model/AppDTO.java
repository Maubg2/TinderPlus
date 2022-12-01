package co.edu.unbosque.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

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
	
	//Images
	final String srcImage[] = {"media/RostroHombre10.jpg", "media/RostroHombre2.jpg", "media/RostroHombre3.jpg", "media/RostroHombre4.jpg", "media/RostroHombre7.jpg", "media/RostroHombre8.jpg", "media/RostroMujer10.png", "media/RostroMujer2.jpg", "media/RostroMujer3.jpg", "media/RostroMujer4.jpg", "media/RostroMujer5.jpg", "media/RostroMujer8.jpg", "media/RostroMujer9.jpg"};
	
	public AppDTO() {
		
	}
	
	@Override
	public void addUser(User user) {
		
		FileWriter out;
		
		switch(user.getClass().getSimpleName()) {
		case "Man":
			
			try {
				
				out = new FileWriter(file, true); //El true es para que no borre los datos que habían
				/*
				out.write(data);
				out.write(";");
				out.write(data2);
				*/
	 			out.write(Integer.toString(howManyInDataBase())); //ID
	 			out.write(";");
	 			out.write(user.getFirstName());
	 			out.write(";");
	 			out.write(user.getFirstSurname());
	 			out.write(";");
	 			out.write(user.getLastSurname());
	 			out.write(";");
	 			out.write(user.getGender());
	 			out.write(";");
	 			out.write(user.getUsername());
	 			out.write(";");
	 			out.write(user.getPassword());
	 			out.write(";");
	 			out.write(user.getMail());
	 			out.write(";");
	 			out.write(user.getSimpleBornDate());
	 			out.write(";");
	 			out.write(Integer.toString(user.getAge()));
	 			out.write(";");
	 			out.write(Double.toString(((Man) user).getSalary()));
	 			out.write(";");
	 			out.write("No Aplica");
	 			out.write(";");
	 			out.write(Integer.toString(user.getLikesAmount()));
	 			out.write(";");
	 			out.write(Integer.toString(user.getSentLikesAmount()));
	 			out.write(";");
	 			out.write(Integer.toString(user.getMatchAmount()));
	 			out.write(";");
	 			out.write(user.getIsAvailableString());
				
				out.close();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Error al abrir el archivo csv: Cierre el archivo e inténtelo de nuevo");
			} 
			
			break;
			
		case "Woman":
			try {
				
				out = new FileWriter(file, true); //El true es para que no borre los datos que habían
				/*
				out.write(data);
				out.write(";");
				out.write(data2);
				*/
	 			out.write(Integer.toString(howManyInDataBase())); //ID
	 			out.write(";");
	 			out.write(user.getFirstName());
	 			out.write(";");
	 			out.write(user.getFirstSurname());
	 			out.write(";");
	 			out.write(user.getLastSurname());
	 			out.write(";");
	 			out.write(user.getGender());
	 			out.write(";");
	 			out.write(user.getUsername());
	 			out.write(";");
	 			out.write(user.getPassword()); //Sale nula
	 			out.write(";");
	 			out.write(user.getMail());
	 			out.write(";");
	 			out.write(user.getSimpleBornDate());
	 			out.write(";");
	 			out.write(Integer.toString(user.getAge()));
	 			out.write(";");
	 			out.write(""); //Ingresos
	 			out.write(";");
	 			out.write(((Woman) user).getIsDivorced());
	 			out.write(";");
	 			out.write(Integer.toString(user.getLikesAmount()));
	 			out.write(";");
	 			out.write(Integer.toString(user.getSentLikesAmount()));
	 			out.write(";");
	 			out.write(Integer.toString(user.getMatchAmount()));
	 			out.write(";");
	 			out.write(user.getIsAvailableString());
				
				out.close();
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Error al abrir el archivo csv: Cierre el archivo e inténtelo de nuevo");
			} 
			
			break;
		}
		
		
		
	}

	@Override
	public User searchUser(String username) {
		
		User searchedUser = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				
				String[] row = line.split(";");
				//System.out.println("tamaño row: " + row.length);
				if(row[5].equals(username)) {
					if(row[4].equals("H")) {
						searchedUser = UserFactory.createMan(row[5], Integer.parseInt(row[9]), row[7], row[4], Integer.parseInt(row[16]), Float.parseFloat(row[10].replace(",", ".")), row[1] + " " + row[2] + " " + row[3], Boolean.parseBoolean(row[15]), Toolkit.parseDateAsString(row[8]), row[6], Integer.parseInt(row[12]), Integer.parseInt(row[13]));
					}else {
						boolean isDivorced = false;
						if(row[11].equals("SI")) {
							isDivorced = true;
						}
						if(!row[16].equals("0") || !row[16].isEmpty()) {
							searchedUser = UserFactory.createWoman(row[5], row[6], row[1] + " " + row[2] + " " + row[3], Integer.parseInt(row[9]), row[7], Toolkit.parseDateAsString(row[8]), Boolean.parseBoolean(row[15]), isDivorced, row[4], Integer.parseInt(row[16]), Integer.parseInt(row[12]), Integer.parseInt(row[13]));
						}else {
							searchedUser = UserFactory.createWoman(row[5], row[6], row[1] + " " + row[2] + " " + row[3], Integer.parseInt(row[9]), row[7], Toolkit.parseDateAsString(row[8]), Boolean.parseBoolean(row[15]), isDivorced, row[4], Integer.parseInt(row[12]), Integer.parseInt(row[13]));
						}
					}
				}
				
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
		return searchedUser;

	}
	
	public Admin searchAdmin(String username) {
		Admin returnableAdmin = null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				if(row[2].equals(username)) {
					returnableAdmin = UserFactory.createAdmin(row[1], row[2], row[3]);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return returnableAdmin;
	}

	//Para agregar o quitar likes
	//Como modificar una celda?
	@Override
	public void modifyUser(String newValue,  String username, String parameter) throws IOException {
		int row = Integer.parseInt(retrieveUserID(username))+ 1;
		int col = 0;
		//System.out.println("Fila (ID): " + row + "\nColumna: " + col);
		//Identificar la columna a modificar (atributo)
		parameter = parameter.toLowerCase();
		System.out.println("Parameter: " + parameter);
		
		switch(parameter) {
		case "nombre":
			//System.out.println("Entró");
			col = 1;
			//System.out.println("Col: " + col); //Funciona
			break;
		case "apellido1":
			col = 2;
			break;
		case "apellido2":
			col = 3;
			break;
		case "sexo":
			col = 4;
			break;
		case "usuario":
			col = 5;
			break;
		case "contrasena":
			col = 6;
			break;
		case "correo":
			col = 7;
			break;
		case "nacimiento":
			col = 8;
			break;
		case "edad":
			col = 9;
			break;
		case "ingresos":
			col = 10;
			break;
		case "divorcio":
			col = 11;
			break;
		case "estado":
			col = 15;
			break;
		case "altura":
			col = 16;
			break;
			
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
			 * row[16] = Altura
			 */
		}
		
		CSVReader reader = new CSVReader(new FileReader(file));
		String[] line;
		
		try {
			while((line = reader.readNext()) != null) {
				System.out.println(line[0] + " " + line[1] + " " + line[2]);
			}
		} catch (CsvValidationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<String[]> csvBody;
		try {
			csvBody = reader.readAll();
			//String[] rowLine = csvBody.get(col)
			System.out.println("list: " + csvBody.get(0).length);
			csvBody.get(row)[col] = newValue;
			reader.close();

			//Escribir los cambios
			CSVWriter writer = new CSVWriter(new FileWriter(file));
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}
	
	public String retrieveUserID(String username) {
		
		String returnableId = null; 
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				String[] row = line.split(";");
				if(row[5].equals(username)) {
					returnableId = row[0];
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return returnableId;
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
				 * row[16] = Altura
				 */
				
				for(String x : row) {
					System.out.printf("%-50s", x);
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

	@Override
	public boolean checkAdmin(String username, String password) {
		
		String username1 = "admin";
		String password1 = "1234";
		
		if(username.equals(username1) && password.equals(password1)) {
			return true;
		}
		return false;
	}
	
	public String retrieveImageSrc() {
		int randomIndex = (int)(Math.random()*(srcImage.length));
		//System.out.println(randomIndex); //
		return srcImage[randomIndex];
	}
	
	public User retrieveRandomUser() {
		int randomIndex = (int)(Math.random()*(howManyInDataBase()));
		User randomUser = null;
		
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				
				String[] row = line.split(";");
				
				if(row[0].equals(Integer.toString(randomIndex))) {
					if(row[4].equals("H")) {
						randomUser = UserFactory.createMan(row[5], Integer.parseInt(row[9]), row[7], row[4], Integer.parseInt(row[16]), Float.parseFloat(row[10].replace(",", ".")), row[1] + " " + row[2] + " " + row[3], Boolean.parseBoolean(row[15]), Toolkit.parseDateAsString(row[8]), row[6], Integer.parseInt(row[12]), Integer.parseInt(row[13]));
						break;
					}
					else if(row[4].equals("M")) {
						boolean isDivorced = false;
						if(row[11].equals("SI")) {
							isDivorced = true;
						}
						if(!row[16].equals("0") || !row[16].isEmpty()) {
							randomUser = UserFactory.createWoman(row[5], row[6], row[1] + " " + row[2] + " " + row[3], Integer.parseInt(row[9]), row[7], Toolkit.parseDateAsString(row[8]), Boolean.parseBoolean(row[15]), isDivorced, row[4], Integer.parseInt(row[16]), Integer.parseInt(row[12]), Integer.parseInt(row[13]));
						}else {
							randomUser = UserFactory.createWoman(row[5], row[6], row[1] + " " + row[2] + " " + row[3], Integer.parseInt(row[9]), row[7], Toolkit.parseDateAsString(row[8]), Boolean.parseBoolean(row[15]), isDivorced, row[4], Integer.parseInt(row[12]), Integer.parseInt(row[13]));
						}
						break;
					}
				}
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
				 * row[16] = altura
				 */
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
		System.out.println("ID del usuario random:" + randomIndex++);
		return randomUser;
	}
	
	public int howManyInDataBase() {
		int contador = 0;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			while((line = reader.readLine()) != null) {
				contador++;
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
		return contador;
	}
	
	/**
	 * Método usado exclusivamente para añadir un usuario administrador
	 * @param admin
	 */
	public void addUser(Admin admin) {
		FileWriter out;
		
		try {
			
			out = new FileWriter(file, true); //El true es para que no borre los datos que habían
			/*
			out.write(data);
			out.write(";");
			out.write(data2);
			*/
 			out.write("8080"); //Admin ID (exclusiva)
 			out.write(";");
 			out.write(admin.getName());
 			out.write(";");
 			out.write(admin.getUsername());
 			out.write(";");
 			out.write(admin.getPassword());
 			out.write(";");
			
			out.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error al abrir el archivo csv: Cierre el archivo e inténtelo de nuevo");
		} 
	}


}
