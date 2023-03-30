package ejercicio5;

import connection.Connector;

public class Ejercicio5 {

	public static void main(String[] args) {
		final String USER = "root";
		final String PASSWORD = "Pa$$w0rd";
		
		final String DATABASE = "los_directores";
		
		//Create a new connection to database
		Connector c = new Connector(USER, PASSWORD);
				
		//Create the "Peliculas_y_salas" database
		c.createDB(DATABASE);
		
		//Create tables for database
		createTables(c, DATABASE);
		
		//Inserts for all tables
		insertTables(c, DATABASE);
			
		//Close database connection
		c.closeConnection();
	}
	
	public static void createTables(Connector c, String DATABASE) {
		//Create table "despachos"
		c.createTable(DATABASE, "despachos", "(" 
			+ "numero INT AUTO_INCREMENT PRIMARY KEY,"
			+ "capacidad INT NOT NULL"
			+ ");");
				
		//Create table "directores"
		c.createTable(DATABASE, "directores", "("
			+ "dni VARCHAR(8) PRIMARY KEY,"
			+ "nomApels VARCHAR(255) NOT NULL,"
			+ "dni_jefe VARCHAR(8),"
			+ "despacho INT,"
			+ "FOREIGN KEY (dni_jefe) REFERENCES directores(dni)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE,"
			+ "FOREIGN KEY (despacho) REFERENCES despachos(numero)"
			+ "ON DELETE CASCADE ON UPDATE CASCADE"
			+ ");");
	}
	
	public static void insertTables(Connector c, String DATABASE) {
		//Insert into "despachos"
		c.insertData(DATABASE, "despachos", "capacidad", "10");
		c.insertData(DATABASE, "despachos", "capacidad", "20");
		c.insertData(DATABASE, "despachos", "capacidad", "30");
		c.insertData(DATABASE, "despachos", "capacidad", "40");
		c.insertData(DATABASE, "despachos", "capacidad", "50");
		
		//Insert into "directores"
		c.insertData(DATABASE, "directores", "dni, nomApels, dni_jefe, despacho", "'1234567A', 'Javier Pérez', null, 1");
		c.insertData(DATABASE, "directores", "dni, nomApels, dni_jefe, despacho", "'1234567B', 'Camila Garcia', null, 2");
		c.insertData(DATABASE, "directores", "dni, nomApels, dni_jefe, despacho", "'1234567C', 'Aitor Iglesias', null, 3");
		c.insertData(DATABASE, "directores", "dni, nomApels, dni_jefe, despacho", "'1234567D', 'Alberto del Pozo', '1234567A', 4");
		c.insertData(DATABASE, "directores", "dni, nomApels, dni_jefe, despacho", "'1234567E', 'Josep Maria Pallàs', '1234567B', 5");

	}

}
