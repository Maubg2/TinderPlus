package co.edu.unbosque.model;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

/**
 * <h2>AppDTO</h2>
 * 
 * Clase que sirve de central de datos e implementa el CRUD de la interface AppDAO
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
	
	/**
	 * Contructor de la clase
	 */
	public AppDTO() {
		
	}
	
	/**
	 * Metodo para añadir un nuevo usuario a la base de datos (archivo CSV)
	 * instanciando a FileWriter para escribir en el archivo el nuevo usuario.
	 */
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
	 			out.write(";");
	 			out.write(Integer.toString(user.getHeight()));
				
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
	/**
	 * Sirve para buscar usuarios en el archivo CSV usando como palabra clave
	 * el nombre de usuario de la persona, luego retorna el usuario que coincide.
	 */
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
	
	/**
	 * Sirve para buscar un administrador en el archivo CSV usando como palabra clave
	 * el nombre de usuario de la persona, luego retorna el administrador que coincide.
	 */
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
	
	/**
	 * Para modificar usuario, el metodo pide el parametro que se quiere cambiar, el nombre 
	 * de usuario de quien se va a modificar y el nuevo valor del parametro a modificar.
	 */
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
				//System.out.println(line[0]); //Line es todo el csv
				String[] rowLine = line[0].split(";");
				System.out.println(rowLine);
				//String targetCol = rowLine[col];
				//System.out.println(targetCol);
				//System.out.println(rowLine[col]);
				if(rowLine[col].equals(username)) {
					System.out.println(rowLine[col]);
				}
				
			}
		} catch (CsvValidationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		List<String[]> csvBody;
		try {
			csvBody = reader.readAll();
			//String[] rowLine = csvBody.get(col)
			//System.out.println("list: " + csvBody.get(0).length);
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
		*/
	}
	
	/**
	 * Metodo que retorna el ID del usuario que se ingrese.
	 */
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

	/**
	 * Metodo que pide el usuario para borrar todos los datos si es que coincide con
	 * alguno en la base de datos.
	 */
	@Override
	public void deleteUser(User user) {
		CSVReader reader2;
		try {
			reader2 = new CSVReader(new FileReader(file));
			List<String[]> allElements = reader2.readAll();
			System.out.println(retrieveUserID(user.getUsername()));
			//allElements.get(Integer.parseInt(retrieveUserID(user.getUsername())).remove());
			FileWriter sw = new FileWriter(file);
			CSVWriter writer = new CSVWriter(sw);
			writer.writeAll(allElements);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//Debug
	/**
	 * Sirve para mostrar la base de datos en la consola con la finalidad de hacer debug.
	 */
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

	/**
	 * Metodo que sirve para verificar que las credenciales de un usuario
	 * coincidan (verifica en base de datos), retornando un true si es correcto y un false de lo contrario.
	 */
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

	/**
	 * Metodo para verificar las credenciales del administrador.
	 */
	@Override
	public boolean checkAdmin(String username, String password) {
		
		String username1 = "admin";
		String password1 = "1234";
		
		if(username.equals(username1) && password.equals(password1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * En base a la cantidad de imagenes que estan cargadas, se busca un numero cualquiera
	 * en ese rango y retorna una imagen al azar.
	 * @return
	 */
	public String retrieveImageSrc() {
		int randomIndex = (int)(Math.random()*(srcImage.length));
		//System.out.println(randomIndex); //
		return srcImage[randomIndex];
	}
	

	/**
	 * Metodo que retorna un usuario al azar dependiendo de la cantidad de usuarios 
	 * ingresados en la base de datos.
	 * @return
	 */
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
	
	
	/**
	 * Metodo que retorna la cantidad de personas que estan en la base de datos.
	 * @return
	 */
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
	 * 
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
	
	/**
	 * Metodo que retorna todos los datos de una fila en base
	 * al ID que se ingrese.  
	 * 
	 * @param id
	 * @return
	 */
	public String[] retrieveAbsoluteRow(int id) {
		CSVReader reader;
		String[] returnableRow = null;
		try {
			reader = new CSVReader(new FileReader(file));
			String [] nextLine;
	        int columnIndexOfID = 0;
	        while ((nextLine = reader.readNext()) != null) {
	            if(nextLine[columnIndexOfID].matches(Integer.toString(id))){
	            	returnableRow = nextLine;
	            	break;
	                //System.out.println(nextLine[0] + nextLine[1] + "etc...");
	            }               
	        } 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnableRow;
        
	}
	
	/**
	 * Encargado de generar archivo PDF con el reporte correspondiente.
	 */
	public void generateReportPDF() {
		//Toolkit.generatePDF(file);
		
		Document doc = new Document();
		
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("data/reporte.pdf"));
			doc.open();
			PdfPTable table = new PdfPTable(4);
			/*
			table.addCell("ID");
			table.addCell("Nombre");
			table.addCell("Primer apellido");
			table.addCell("Segundo apellido");
			table.addCell("Sexo");
			table.addCell("Usuario");
			table.addCell("Contraseña");
			table.addCell("Correo");
			table.addCell("Nacimiento");
			table.addCell("Edad");
			table.addCell("Ingresos");
			table.addCell("Divorciada");
			table.addCell("Número de likes");
			table.addCell("Número de likes enviados");
			table.addCell("Número de matches");
			table.addCell("Estado");
			table.addCell("Altura");
			*/
			
			try {
				reader = new BufferedReader(new FileReader(file));
				
				while((line = reader.readLine()) != null) {
					
					String[] row = line.split(";");
					table.addCell(row[0]);
					table.addCell(row[1]);
					table.addCell(row[2]);
					table.addCell(row[3]);
					/*
					for(int i = 0; i < row.length; i++) {
						table.addCell(row[i]);
					}
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
			
			doc.add(table);
			doc.close();
		}catch(Exception e) {
			
		}
	}


}
