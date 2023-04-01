/**
 * 
 */
package ejercicio7;

import connection.Connector;

/**
 * @author aitor
 *
 */
public class Ejercicio7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connector c = new Connector();
		c.createDB("cientificos");

		c.createTable("cientificos", "cientificos",
				"(DNI varchar(8) NOT NULL," + "NOMAPELS varchar(255) NOT NULL," + "PRIMARY KEY(DNI));");

		c.createTable("cientificos", "proyecto", "(ID char(4) NOT NULL," + "NOMBRE varchar(255) NOT NULL,"
				+ "HORAS int NOT NULL," + "PRIMARY KEY(ID));");

		c.createTable("cientificos", "asignado_a",
				"(CIENTIFICO varchar(8) NOT NULL," + "PROYECTO char(4) NOT NULL," + "PRIMARY KEY(CIENTIFICO, PROYECTO),"
						+ "FOREIGN KEY(CIENTIFICO) REFERENCES cientificos (DNI) ON DELETE CASCADE ON UPDATE CASCADE,"
						+ "FOREIGN KEY(PROYECTO) REFERENCES proyecto (ID) ON DELETE CASCADE ON UPDATE CASCADE);");

		c.insertData("cientificos", "cientificos", "DNI, NOMAPELS", "'12345678', 'Aitor Iglesias Pubill'");
		c.insertData("cientificos", "cientificos", "DNI, NOMAPELS", "'12345679', 'Camila Garcia Perez'");
		c.insertData("cientificos", "cientificos", "DNI, NOMAPELS", "'12345670', 'Javier Perez'");
		c.insertData("cientificos", "cientificos", "DNI, NOMAPELS", "'12345671', 'Ignatius El Loco'");

		c.insertData("cientificos", "proyecto", "ID, NOMBRE, HORAS", "10, 'Proyecto Java', 300");
		c.insertData("cientificos", "proyecto", "ID, NOMBRE, HORAS", "11, 'Proyecto BBDD', 400");
		c.insertData("cientificos", "proyecto", "ID, NOMBRE, HORAS", "12, 'Proyecto Backend', 500");
		c.insertData("cientificos", "proyecto", "ID, NOMBRE, HORAS", "13, 'Proyecto Frontend', 600");

		c.insertData("cientificos", "asignado_a", "CIENTIFICO, PROYECTO", "'12345678', 10");
		c.insertData("cientificos", "asignado_a", "CIENTIFICO, PROYECTO", "'12345679', 11");
		c.insertData("cientificos", "asignado_a", "CIENTIFICO, PROYECTO", "'12345670', 12");
		c.insertData("cientificos", "asignado_a", "CIENTIFICO, PROYECTO", "'12345671', 13");
		c.closeConnection();
	}

}
