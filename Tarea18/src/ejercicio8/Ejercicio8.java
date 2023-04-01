/**
 * 
 */
package ejercicio8;

import connection.Connector;

/**
 * @author aitor
 *
 */
public class Ejercicio8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connector c = new Connector();
		c.createDB("grandes_almacenes");
		
		c.createTable("grandes_almacenes", "cajeros", 
				"(CODIGO int NOT NULL,"
				+ "NOMAPELS varchar(255) NOT NULL,"
				+ "PRIMARY KEY(CODIGO));");
		
		c.createTable("grandes_almacenes", "productos", 
				"(CODIGO int NOT NULL,"
				+ "NOMBRE varchar(100) NOT NULL,"
				+ "PRECIO int NOT NULL,"
				+ "PRIMARY KEY(CODIGO));");
		
		c.createTable("grandes_almacenes", "maquinas_registradoras", 
				"(CODIGO int NOT NULL,"
				+ "PISO int NOT NULL,"
				+ "PRIMARY KEY(CODIGO));");
		
		c.createTable("grandes_almacenes", "venta", 
				"(CAJERO int NOT NULL,"
				+ "MAQUINA int NOT NULL,"
				+ "PRODUCTO int NOT NULL,"
				+ "PRIMARY KEY(CAJERO, MAQUINA, PRODUCTO),"
				+ "FOREIGN KEY(CAJERO) REFERENCES cajeros (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(MAQUINA) REFERENCES maquinas_registradoras (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(PRODUCTO) REFERENCES productos (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE);");
		
		c.insertData("grandes_almacenes", "cajeros", "CODIGO, NOMAPELS", "10, 'Aitor Iglesias Pubill'");
		c.insertData("grandes_almacenes", "productos", "CODIGO, NOMBRE, PRECIO", "101, 'Lavadora', 500");
		c.insertData("grandes_almacenes", "maquinas_registradoras", "CODIGO, PISO", "50, 2");
		c.insertData("grandes_almacenes", "venta", "CAJERO, MAQUINA, PRODUCTO", "10, 50, 101");
		c.closeConnection();
	}

}
