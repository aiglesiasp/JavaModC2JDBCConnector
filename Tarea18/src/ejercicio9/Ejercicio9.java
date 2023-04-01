/**
 * 
 */
package ejercicio9;

import connection.Connector;

/**
 * @author aitor
 *
 */
public class Ejercicio9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connector c = new Connector();
		c.createDB("investigadores");
		c.createTable("investigadores", "facultad",
				"(CODIGO int NOT NULL," + "NOMBRE varchar(100) NOT NULL," + "PRIMARY KEY(CODIGO));");

		c.createTable("investigadores", "equipos",
				"(NUMSERIE char(4) NOT NULL," + "NOMBRE varchar(100) NOT NULL," + "FACULTAD int NOT NULL,"
						+ "PRIMARY KEY(NUMSERIE)," + "FOREIGN KEY(FACULTAD) REFERENCES facultad (CODIGO));");

		c.createTable("investigadores", "investigadores",
				"(DNI varchar(8) NOT NULL," + "NOMAPELS varchar(255) NOT NULL," + "FACULTAD int NOT NULL,"
						+ "PRIMARY KEY(DNI)," + "FOREIGN KEY(FACULTAD) REFERENCES facultad (CODIGO));");

		c.createTable("investigadores", "reserva",
				"(DNI varchar(8) NOT NULL," + "NUMSERIE char(4) NOT NULL," + "COMIENZO datetime," + "FIN datetime,"
						+ "PRIMARY KEY(DNI, NUMSERIE),"
						+ "FOREIGN KEY(DNI) REFERENCES investigadores (DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "FOREIGN KEY(NUMSERIE) REFERENCES equipos (NUMSERIE) ON DELETE CASCADE ON UPDATE CASCADE);");

		c.insertData("investigadores", "facultad", "CODIGO, NOMBRE", "1200, 'UPC-Politecnica de Catalunya'");
		c.insertData("investigadores", "facultad", "CODIGO, NOMBRE", "1201, 'UPV-Politecnica de Valencia'");
		c.insertData("investigadores", "facultad", "CODIGO, NOMBRE", "1202, 'UPN-Politecnica de Navarra'");
		c.insertData("investigadores", "facultad", "CODIGO, NOMBRE", "1203, 'UOC-Oberta de Catalunya'");

		c.insertData("investigadores", "equipos", "NUMSERIE, NOMBRE, FACULTAD", "2727, 'Equipo Forense', 1200");
		c.insertData("investigadores", "equipos", "NUMSERIE, NOMBRE, FACULTAD", "2728, 'Equipo Urgencias', 1201");
		c.insertData("investigadores", "equipos", "NUMSERIE, NOMBRE, FACULTAD", "2729, 'Equipo Trauma', 1202");
		c.insertData("investigadores", "equipos", "NUMSERIE, NOMBRE, FACULTAD", "2726, 'Equipo Primera Visita', 1203");

		c.insertData("investigadores", "investigadores", "DNI, NOMAPELS, FACULTAD","'12345678', 'Aitor Iglesias', 1200");
		c.insertData("investigadores", "investigadores", "DNI, NOMAPELS, FACULTAD","'12345679', 'Camila Garcia', 1201");
		c.insertData("investigadores", "investigadores", "DNI, NOMAPELS, FACULTAD", "'12345670', 'Javier Perez', 1202");
		c.insertData("investigadores", "investigadores", "DNI, NOMAPELS, FACULTAD","'12345671', 'Ignatius Loco', 1203");

		c.insertData("investigadores", "reserva", "DNI, NUMSERIE, COMIENZO, FIN",
				"\'12345678\', 2727,'2018-05-18 14:10:30', '2020-05-18 14:10:30'");
		c.insertData("investigadores", "reserva", "DNI, NUMSERIE, COMIENZO, FIN",
				"\'12345679\', 2728,'2118-06-18 14:10:30', '2020-06-18 14:10:30'");
		c.insertData("investigadores", "reserva", "DNI, NUMSERIE, COMIENZO, FIN",
				"\'12345670\', 2729,'2018-07-18 14:10:30', '2020-07-18 14:10:30'");
		c.insertData("investigadores", "reserva", "DNI, NUMSERIE, COMIENZO, FIN",
				"\'12345671\', 2726,'2018-08-18 14:10:30', '2020-08-18 14:10:30'");

		c.closeConnection();

	}

}
