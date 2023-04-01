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
				"(CODIGO int NOT NULL," + "NOMAPELS varchar(255) NOT NULL," + "PRIMARY KEY(CODIGO));");

		c.createTable("grandes_almacenes", "productos", "(CODIGO int NOT NULL," + "NOMBRE varchar(100) NOT NULL,"
				+ "PRECIO int NOT NULL," + "PRIMARY KEY(CODIGO));");

		c.createTable("grandes_almacenes", "maquinas_registradoras",
				"(CODIGO int NOT NULL," + "PISO int NOT NULL," + "PRIMARY KEY(CODIGO));");

		c.createTable("grandes_almacenes", "venta", "(CAJERO int NOT NULL," + "MAQUINA int NOT NULL,"
				+ "PRODUCTO int NOT NULL," + "PRIMARY KEY(CAJERO, MAQUINA, PRODUCTO),"
				+ "FOREIGN KEY(CAJERO) REFERENCES cajeros (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(MAQUINA) REFERENCES maquinas_registradoras (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(PRODUCTO) REFERENCES productos (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE);");

		c.insertData("grandes_almacenes", "cajeros", "CODIGO, NOMAPELS", "10, 'Aitor Iglesias Pubill'");
		c.insertData("grandes_almacenes", "cajeros", "CODIGO, NOMAPELS", "11, 'Camila Garcia Perez'");
		c.insertData("grandes_almacenes", "cajeros", "CODIGO, NOMAPELS", "12, 'Javier Perez'");
		c.insertData("grandes_almacenes", "cajeros", "CODIGO, NOMAPELS", "13, 'Ignatius El Loco'");

		c.insertData("grandes_almacenes", "productos", "CODIGO, NOMBRE, PRECIO", "101, 'Lavadora', 500");
		c.insertData("grandes_almacenes", "productos", "CODIGO, NOMBRE, PRECIO", "102, 'Secadora', 500");
		c.insertData("grandes_almacenes", "productos", "CODIGO, NOMBRE, PRECIO", "103, 'Nevera', 1000");
		c.insertData("grandes_almacenes", "productos", "CODIGO, NOMBRE, PRECIO", "104, 'Horno', 2000");

		c.insertData("grandes_almacenes", "maquinas_registradoras", "CODIGO, PISO", "50, 2");
		c.insertData("grandes_almacenes", "maquinas_registradoras", "CODIGO, PISO", "51, 2");
		c.insertData("grandes_almacenes", "maquinas_registradoras", "CODIGO, PISO", "52, 0");
		c.insertData("grandes_almacenes", "maquinas_registradoras", "CODIGO, PISO", "53, 1");

		c.insertData("grandes_almacenes", "venta", "CAJERO, MAQUINA, PRODUCTO", "10, 50, 101");
		c.insertData("grandes_almacenes", "venta", "CAJERO, MAQUINA, PRODUCTO", "11, 51, 102");
		c.insertData("grandes_almacenes", "venta", "CAJERO, MAQUINA, PRODUCTO", "12, 52, 103");
		c.insertData("grandes_almacenes", "venta", "CAJERO, MAQUINA, PRODUCTO", "13, 53, 104");
		c.closeConnection();
	}

}
