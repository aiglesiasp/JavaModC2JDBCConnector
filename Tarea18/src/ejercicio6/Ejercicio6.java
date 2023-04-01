package ejercicio6;

import connection.Connector;

/**
 * @author Javier
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		
		final String DATABASE = "piezas_y_proveedores";
		
		//Create a new connection to database
		Connector c = new Connector();
				
		//Create the "piezas_y_proveedores" database
		c.createDB(DATABASE);
		
		//Create tables for database
		createTables(c, DATABASE);
		
		//Inserts for all tables
		insertTables(c, DATABASE);
			
		//Close database connection
		c.closeConnection();
	}
	
	public static void createTables(Connector c, String DATABASE) {
		//Create table "piezas"
		c.createTable(DATABASE, "piezas", "(" 
			+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
			+ "nombre VARCHAR(100) NOT NULL"
			+ ");");
		
		//Create table "proveedores"
		c.createTable(DATABASE, "proveedores", "(" 
			+ "id CHAR(4) PRIMARY KEY,"
			+ "nombre VARCHAR(100) NOT NULL"
			+ ");");
				
		//Create table "sumistra"
		c.createTable(DATABASE, "sumistra", "("
			+ "codigopieza INT NOT NULL,"
			+ "idproveedor CHAR(4) NOT NULL,"
			+ "precio INT NOT NULL,"
			+ "PRIMARY KEY (codigopieza, idproveedor),"
			+ "FOREIGN KEY (codigopieza) REFERENCES piezas(codigo),"
			+ "FOREIGN KEY (idproveedor) REFERENCES proveedores(id)"
			+ ");");
	}
	
	public static void insertTables(Connector c, String DATABASE) {
		//Insert into "piezas"
		c.insertData(DATABASE, "piezas", "nombre", "'GeForce RTX 3060'");
		c.insertData(DATABASE, "piezas", "nombre", "'GeForce RTX 3070'");
		c.insertData(DATABASE, "piezas", "nombre", "'GeForce RTX 3080'");
		c.insertData(DATABASE, "piezas", "nombre", "'GeForce RTX 3090'");
		c.insertData(DATABASE, "piezas", "nombre", "'GeForce RTX 4080'");
		
		//Insert into "proveedores"
		c.insertData(DATABASE, "proveedores", "id, nombre", "'M', 'MSI'");
		c.insertData(DATABASE, "proveedores", "id, nombre", "'A', 'ASUS'");
		c.insertData(DATABASE, "proveedores", "id, nombre", "'G', 'GIGABYTE'");
		c.insertData(DATABASE, "proveedores", "id, nombre", "'E', 'EVGA'");
		c.insertData(DATABASE, "proveedores", "id, nombre", "'N', 'NVIDIA'");
		
		//Insert into "sumistra"
		c.insertData(DATABASE, "sumistra", "codigopieza, idproveedor, precio", "1, 'N', 299.90");
		c.insertData(DATABASE, "sumistra", "codigopieza, idproveedor, precio", "2, 'E', 549.90");
		c.insertData(DATABASE, "sumistra", "codigopieza, idproveedor, precio", "3, 'G', 659.90");
		c.insertData(DATABASE, "sumistra", "codigopieza, idproveedor, precio", "4, 'E', 870.00");
		c.insertData(DATABASE, "sumistra", "codigopieza, idproveedor, precio", "5, 'M', 1449.90");

	}

}
