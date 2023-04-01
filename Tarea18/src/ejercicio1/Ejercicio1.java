/**
 * 
 */
package ejercicio1;

import connection.Connector;

/**
 * @author camila
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector c = new Connector();

		c.createDB("tienda_informatica");
		c.createTable("tienda_informatica", "fabricantes",
				"(CODIGO int NOT NULL," + "NOMBRE varchar(255) NOT NULL," + "PRIMARY KEY (CODIGO));");
		
		c.createTable("tienda_informatica", "articulos",
				"(CODIGO int NOT NULL," + " NOMBRE varchar(255) NOT NULL,"
				+ "PRECIO decimal(10,0) NOT NULL," + "FABRICANTE int NOT NULL,"
				+ "PRIMARY KEY (CODIGO)," + "  KEY FABRICANTE (`FABRICANTE`),"
				+ "CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (FABRICANTE) REFERENCES fabricantes (CODIGO));");

		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "1, 'Aitor Iglesias'");
		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "2, 'Camila Garcia'");
		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "3, 'Santiago Segura'");
		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "5, 'Paco Fiugueras'");
		c.insertData("tienda_informatica", "fabricantes", "CODIGO, NOMBRE", "4, 'Carlos Guimenez'"); 
		
		c.insertData("tienda_informatica", "articulos", "CODIGO, NOMBRE, PRECIO, FABRICANTE",
				"40, 'ORDENADOR', 150.00, 1");
		c.insertData("tienda_informatica", "articulos", "CODIGO, NOMBRE, PRECIO, FABRICANTE",
				"41, 'IMPRESORA', 80.00, 2");
		c.insertData("tienda_informatica", "articulos", "CODIGO, NOMBRE, PRECIO, FABRICANTE",
				"42, 'MONITOR', 200.00, 3");
		c.insertData("tienda_informatica", "articulos", "CODIGO, NOMBRE, PRECIO, FABRICANTE",
				"43, 'TECLADO', 25.00, 4");
		c.insertData("tienda_informatica", "articulos", "CODIGO, NOMBRE, PRECIO, FABRICANTE",
				"44, 'RATÓN', 15.00, 4");
		
		c.closeConnection();
	}

}
