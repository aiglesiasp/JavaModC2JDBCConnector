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
		c.createConnection("root", "Camila1234_");

		c.createDB("losalmacenes");
		
		c.createTable("losalmacenes", "almacenes",
				"( `CODIGO` int NOT NULL,\n"
				+ "  `LUGAR` varchar(100) NOT NULL,\n"
				+ "  `CAPACIDAD` int NOT NULL,\n"
				+ "  PRIMARY KEY (`CODIGO`));");
		
		c.createTable("losalmacenes", "cajas_",
				"(`NUMREFERENCIA` char(5) NOT NULL,\n"
				+ "  `CONTENIDO` varchar(100) NOT NULL,\n"
				+ "  `VALOR` double NOT NULL,\n"
				+ "  `ALMACEN` int NOT NULL,\n"
				+ "  PRIMARY KEY (`NUMREFERENCIA`),\n"
				+ "  KEY `ALMACEN` (`ALMACEN`),\n"
				+ "  CONSTRAINT `cajas_ibfk_1` FOREIGN KEY (`ALMACEN`) REFERENCES `almacenes` (`CODIGO`));");

		c.closeConnection();
	}

}