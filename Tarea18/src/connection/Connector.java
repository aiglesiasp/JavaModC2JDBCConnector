/**
 * 
 */
package connection;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import models.Fabricante;

/**
 * @author aitor
 *
 */
public class Connector {

	private Connection conect;

	public Connector() {
		this.conect = null;
	}

	public Connection getConect() {
		return conect;
	}

	// CREAR CONNECTION
	public Connection createConnection(String user, String password) {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC",
					user, password);
			System.out.println("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		this.conect = conexion;
		return conexion;
	}

	// CLOSE CONNECTION
	public void closeConnection() {
		try {
			conect.close();
			System.out.println("Se ha finalizado la conexion con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	// METODO QUE CREA BASE DE DATOS;
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE " + name;
			Statement st = conect.createStatement();
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
			Statement stdb = conect.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "CREATE TABLE " + name + "" + datos;
			Statement st = conect.createStatement();
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
			Statement stdb = conect.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "iNSERT INTO " +tableName+ " ("+entradas+") VALUE("+valores+");";
			
			Statement st = conect.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados correctamente en la table " +tableName);
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error insertando datos en la tabla "+tableName);
		}
		
	}
	
	

}
