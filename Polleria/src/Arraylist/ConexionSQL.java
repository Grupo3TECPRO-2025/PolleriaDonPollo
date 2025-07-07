package Arraylist;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {
	public static Connection getConexion() {
		Connection cnx = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			System.out.println("Driver Correcto");

			cnx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/PolleriaDonPolloDB", "root", "mysql12345"
					);

			System.out.println("Conexion correcta");
		}catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		return cnx;
		
	}
}
