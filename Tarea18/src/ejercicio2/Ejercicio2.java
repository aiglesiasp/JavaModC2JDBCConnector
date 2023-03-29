package ejercicio2;

import connection.Connector;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector c = new Connector("root", "root");

		c.createDB("empleados");
		
		c.createTable("empleados", "departamentos",
				"(CODIGO int NOT NULL,"
				+ "NOMBRE varchar(100) NOT NULL,"
				+ "PRESUPUESTO decimal(10,0) NOT NULL,"
				+ "PRIMARY KEY (CODIGO));");
		
		c.createTable("empleados", "empleados", 
				"(DNI int NOT NULL,"
				+ "NOMBRE varchar(100) NOT NULL,"
				+ "APELLIDOS varchar(255) NOT NULL,"
				+ "DEPARTAMENTO int NOT NULL,"
				+ "PRIMARY KEY (DNI),"
				+ "KEY DEPARTAMENTO (DEPARTAMENTO),"
				+ "CONSTRAINT empleados_ibfk_1 FOREIGN KEY (DEPARTAMENTO) REFERENCES departamentos (CODIGO));");

		c.closeConnection();
	}

}
