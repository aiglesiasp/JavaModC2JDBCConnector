/**
 * 
 */
package ejercicio3;

import connection.Connector;

/**
 * @author camila
 *
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connector c = new Connector("root", "root");

		c.createDB("losalmacenes");
		
		c.createTable("losalmacenes", "almacenes",
				"(CODIGO int NOT NULL,"
				+ "LUGAR varchar(100) NOT NULL,"
				+ "CAPACIDAD int NOT NULL,"
				+ "PRIMARY KEY (CODIGO));");
		
		c.createTable("losalmacenes", "cajas",
				"(NUMREFERENCIA char(5) NOT NULL,"
				+ "CONTENIDO varchar(100) NOT NULL,"
				+ "VALOR double NOT NULL,"
				+ "ALMACEN int NOT NULL,"
				+ "PRIMARY KEY (NUMREFERENCIA),"
				+ "KEY ALMACEN (ALMACEN),"
				+ "CONSTRAINT cajas_ibfk_1 FOREIGN KEY (ALMACEN) REFERENCES almacenes (CODIGO));");

		c.closeConnection();
	}

}