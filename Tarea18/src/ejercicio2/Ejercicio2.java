package ejercicio2;

import connection.Connector;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector c = new Connector();

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

		c.insertData("empleados", "departamentos", "CODIGO, NOMBRE, PRESUPUESTO","1, 'recursos humanos', 120.00"); 
		c.insertData("empleados", "departamentos", "CODIGO, NOMBRE, PRESUPUESTO","2, 'Servicios it', 120.00"); 
		c.insertData("empleados", "departamentos", "CODIGO, NOMBRE, PRESUPUESTO","3, 'Finanzas', 150.00"); 
		c.insertData("empleados", "departamentos", "CODIGO, NOMBRE, PRESUPUESTO","4, 'Vending', 320.00"); 
		c.insertData("empleados", "departamentos", "CODIGO, NOMBRE, PRESUPUESTO","5, 'Investigacion', 19 0.00"); 
		
		c.insertData("empleados", "empleados", "DNI, NOMBRE, APELLIDOS, DEPARTAMENTO",
				"77789227, 'MARC', 'PORTA', 1");
		c.insertData("empleados", "empleados", "DNI, NOMBRE, APELLIDOS, DEPARTAMENTO",
				"77789927, 'JOAN', 'GARCIA', 2");
		c.insertData("empleados", "empleados", "DNI, NOMBRE, APELLIDOS, DEPARTAMENTO",
				"77787227, 'CARLOS', 'PORTA', 3");
		c.insertData("empleados", "empleados", "DNI, NOMBRE, APELLIDOS, DEPARTAMENTO",
				"77789247, 'AITOR', 'FERNANDEZ', 4");
		c.insertData("empleados", "empleados", "DNI, NOMBRE, APELLIDOS, DEPARTAMENTO",
				"77789327, 'JORGE', 'GIL', 5");
		c.closeConnection();
	}

}
