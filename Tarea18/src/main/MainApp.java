/**
 * 
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import connection.Connector;;

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

		Connector conect = new Connector();
		conect.initConnection("root", "Camila1234_");
	}
}
