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
				"(CODIGO int NOT NULL,"
				+ "NOMBRE varchar(100) NOT NULL,"
				+ "PRIMARY KEY(CODIGO));");
		
		c.createTable("investigadores", "equipos", 
				"(NUMSERIE char(4) NOT NULL,"
				+ "NOMBRE varchar(100) NOT NULL,"
				+ "FACULTAD int NOT NULL,"
				+ "PRIMARY KEY(NUMSERIE),"
				+ "FOREIGN KEY(FACULTAD) REFERENCES facultad (CODIGO));");
		
		c.createTable("investigadores", "investigadores", 
				"(DNI varchar(8) NOT NULL,"
				+ "NOMAPELS varchar(255) NOT NULL,"
				+ "FACULTAD int NOT NULL,"
				+ "PRIMARY KEY(DNI),"
				+ "FOREIGN KEY(FACULTAD) REFERENCES facultad (CODIGO));");
		
		c.createTable("investigadores", "reserva", 
				"(DNI varchar(8) NOT NULL,"
				+ "NUMSERIE char(4) NOT NULL,"
				+ "COMIENZO datetime,"
				+ "FIN datetime,"
				+ "PRIMARY KEY(DNI, NUMSERIE),"
				+ "FOREIGN KEY(DNI) REFERENCES investigadores (DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(NUMSERIE) REFERENCES equipos (NUMSERIE) ON DELETE CASCADE ON UPDATE CASCADE);");
		
		c.insertData("investigadores", "facultad","CODIGO, NOMBRE", "1200, 'UOC-Politecnica de Catalunya'");
		c.insertData("investigadores", "equipos","NUMSERIE, NOMBRE, FACULTAD", "2727, 'Equipo Forense', 1200");
		c.insertData("investigadores", "investigadores","DNI, NOMAPELS, FACULTAD", "'12345678', 'Aitor Iglesias', 1200");
		//c.insertData("investigadores", "reserva","DNI, NUMSERIE, COMIENZO, FIN", "\'12345678\', 2727,"+ d("2020-05-18T14:10:30.000Z")  , ISODate(\"2020-05-20T14:10:30.000Z\")");
		c.closeConnection();
	
	}

}
