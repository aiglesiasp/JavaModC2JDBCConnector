package ejercicio2;

import connection.Connector;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector c = new Connector();
		c.createConnection("root", "Camila1234_");

		c.createDB("empleados");
		
		c.createTable("empleados", "departamentos",
				"(`CODIGO` int NOT NULL,\n"
				+ "  `NOMBRE` varchar(255) NOT NULL,\n"
				+ "  `PRESUPUESTO` decimal(10,0) NOT NULL,\n"
				+ "  PRIMARY KEY (`CODIGO`));");
		
		c.createTable("empleados", "empleados", "( `DNI` int NOT NULL,\n"
				+ "  `NOMBRE` varchar(255) NOT NULL,\n"
				+ "  `APELLIDOS` varchar(255) NOT NULL,\n"
				+ "  `DEPARTAMENTO` int NOT NULL,\n"
				+ "  PRIMARY KEY (`DNI`),\n"
				+ "  KEY `DEPARTAMENTO` (`DEPARTAMENTO`),\n"
				+ "  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`DEPARTAMENTO`) REFERENCES `departamentos` (`CODIGO`));");

		c.closeConnection();
	}

}
