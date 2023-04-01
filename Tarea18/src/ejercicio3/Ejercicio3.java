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

		Connector c = new Connector();

		c.createDB("losalmacenes");

		c.createTable("losalmacenes", "almacenes", "(CODIGO int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "LUGAR varchar(100) NOT NULL," + "CAPACIDAD int NOT NULL);");

		c.createTable("losalmacenes", "cajas",
				"(NUMREFERENCIA char(5) NOT NULL PRIMARY KEY," + "CONTENIDO varchar(100) NOT NULL,"
						+ "VALOR int NOT NULL," + "ALMACEN int NOT NULL,"
						+ "CONSTRAINT FK_ALMACENES FOREIGN KEY (ALMACEN) REFERENCES almacenes(CODIGO));");

		c.insertData("losalmacenes", "almacenes", "LUGAR, CAPACIDAD", "'Madrid', 1000");
		c.insertData("losalmacenes", "almacenes", "LUGAR, CAPACIDAD", "'Barcelona', 800");
		c.insertData("losalmacenes", "almacenes", "LUGAR, CAPACIDAD", "'Valencia', 1200");
		c.insertData("losalmacenes", "almacenes", "LUGAR, CAPACIDAD", "'Sevilla', 500");
		c.insertData("losalmacenes", "almacenes", "LUGAR, CAPACIDAD", "'Bilbao', 700");

		c.insertData("losalmacenes", "cajas", "NUMREFERENCIA, CONTENIDO, VALOR, ALMACEN", "'001', 'Libros', 500, 1");
		c.insertData("losalmacenes", "cajas", "NUMREFERENCIA, CONTENIDO, VALOR, ALMACEN", "'002', 'Ropa', 200, 1");
		c.insertData("losalmacenes", "cajas", "NUMREFERENCIA, CONTENIDO, VALOR, ALMACEN", "'003', 'Juguetes', 100, 2");
		c.insertData("losalmacenes", "cajas", "NUMREFERENCIA, CONTENIDO, VALOR, ALMACEN",
				"'004', 'Electronica', 800, 2");
		c.insertData("losalmacenes", "cajas", "NUMREFERENCIA, CONTENIDO, VALOR, ALMACEN",
				"'005', 'Instrumentos', 600, 3");

		c.closeConnection();
	}

}