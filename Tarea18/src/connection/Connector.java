/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Aitor, Javier, Camila
 *
 */
public class Connector {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "Pa$$w0rd";

	private static Connection conexion = null;

	//CREAR CONEXIÓN
	public Connector() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Server Connected");
		} catch(SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
	
	public static Connection getConexion() {
		return conexion;
	}

	// CLOSE CONNECTION
	public void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion con el servidor");
		} catch(SQLException ex) {
			System.err.println("Error al cerrar la conexión con la base de datos");
			System.out.println(ex);
		}
	}

	// METODO QUE CREA BASE DE DATOS;
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE IF NOT EXISTS " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			// closeConnection();
			System.out.println("Se ha creado la base de datos " + name);

		} catch (SQLException ex) {
			System.out.println("Error al crear la base de datos "+name);
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// METODO CREAR TABLAS MYSQL
	public void createTable(String db, String name, String datos) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE IF NOT EXISTS " + name + "" + datos;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Tabla " +name+ " creada con exito");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla "+name);
		}
	}
	
	public void insertData(String db, String tableName, String entradas, String valores) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " +tableName+ " ("+entradas+") VALUE("+valores+");";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados correctamente en la table " +tableName);
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error insertando datos en la tabla "+tableName);
		}
		
	}
	
	

}
