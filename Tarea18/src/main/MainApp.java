/**
 * 
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

/**
 * @author camila
 *
 */


public class MainApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc-Driver");
			Connection conexion = DriverManager
					.getConnection("jdbc:mysql:localhost:3306?useTimezone-trueßserverTimezone-UTC", "root", "Camila1234_");
			System.out.print("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
	}
}
