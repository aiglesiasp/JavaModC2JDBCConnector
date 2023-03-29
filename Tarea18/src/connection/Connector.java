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

import javax.swing.JOptionPane;

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
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", user, password);
			System.out.print("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
		this.conect = conexion; 
		return conexion;
	}

	
	// CLOSE CONNECTION
	public void closeConnection() {
		try {
			conect.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);

		}
	}
	//METODO QUE CREA BASE DE DATOS; 
	public void createDB (String name) {
		try{
			String Query = "CREATE DATABASE " + name; 
			Statement st = conect.createStatement();
			st.executeUpdate(Query); 
			
			//closeConnection();
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name);
			
			
		}catch(SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex); 
		}
	}


}
