/**
 * 
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	private Connection createConnection() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC",
					"root", "root");
			System.out.print("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
		return conexion;
	}

	
	// INICIAR CONEXION
	public Connection getConnection() {
		this.conect = createConnection();
		return this.conect;

	}

	
	// CLOSE CONNECTION
	public void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

}
