/**
 * 
 */
package ejercicio4;

import connection.Connector;

/**
 * @author Javier
 *
 */
public class Ejercicio4 {

	/**
	 * Main execution method
	 * @param args
	 */
	public static void main(String[] args) {
		
		final String DATABASE = "peliculas_y_salas";
		
		//Create a new connection to database
		Connector c = new Connector();
				
		//Create the "Peliculas_y_salas" database
		c.createDB(DATABASE);
		
		//Create tables for database
		createTables(c, DATABASE);
		
		//Inserts for all tables
		insertTables(c, DATABASE);
			
		//Close database connection
		c.closeConnection();
	}
	
	/**
	 * This method creates the database.
	 * @param c
	 * @param DATABASE
	 */
	public static void createTables(Connector c, String DATABASE) {
		//Create table "peliculas"
		c.createTable(DATABASE, "peliculas", "(" 
			+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
			+ "nombre VARCHAR(100) NOT NULL,"
			+ "calificaion_edad INT NOT NULL"
			+ ");");
				
		//Create table "salas"
		c.createTable(DATABASE, "salas", "("
			+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
			+ "nombre VARCHAR(100) NOT NULL,"
			+ "pelicula INT NOT NULL,"
			+ "FOREIGN KEY (pelicula) REFERENCES peliculas(codigo)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE"
			+ ");");
	}

	/**
	 * This method inserts data into the database.
	 * @param c
	 * @param DATABASE
	 */
	public static void insertTables(Connector c, String DATABASE) {
		//Insert into "peliculas"
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode I - The Phantom Menace', 12");
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode II - The Attack of the Clones', 12");
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode III - Revenge of the Sith', 12");
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode IV - A New Hope', 12");
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode V - The Empire Strikes Back', 12");
		c.insertData(DATABASE, "peliculas", "nombre, calificaion_edad", "'STAR WARS: Episode VI - Return of the Jedi', 12");
		
		//Insert into "salas"
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 1', 4");
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 2', 5");
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 3', 6");
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 4', 1");
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 5', 2");
		c.insertData(DATABASE, "salas", "nombre, pelicula", "'Sala 6', 3");
	}
}
