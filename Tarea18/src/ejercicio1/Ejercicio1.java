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
		c.createConnection("root", "Camila1234_");

		c.createDB("tienda_informatica");
		c.createTable("tienda_informatica", "fabricantes",
				"(`CODIGO` int NOT NULL,\n" + "  `NOMBRE` varchar(255) NOT NULL,\n" + "  PRIMARY KEY (`CODIGO`));");
		c.createTable("tienda_informatica", "articulos", "(`CODIGO` int NOT NULL,\n" + "  `NOMBRE` varchar(255) NOT NULL,\n"
				+ "  `PRECIO` decimal(10,0) NOT NULL,\n" + "  `FABRICANTE` int NOT NULL,\n"
				+ "  PRIMARY KEY (`CODIGO`),\n" + "  KEY `FABRICANTE` (`FABRICANTE`),\n"
				+ "  CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`FABRICANTE`) REFERENCES `fabricantes` (`CODIGO`));");

		c.closeConnection();
	}

}
