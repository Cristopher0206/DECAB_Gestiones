package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBDD {
	private static ConexionBDD conexionClass = null;
	private static Connection instancia = null;

	private ConexionBDD() {

		try {
			if (instancia == null) {
				String servidor = "localhost";
				String database = "gestionmaquinariadecab";
				String url = "jdbc:mysql://" + servidor + "/" + database;
				String usuario = "root";
				String password = "decab2022";

				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				instancia = DriverManager.getConnection(url, usuario, password);
				System.out.println("Conexion realizada!");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConexion() {
		if (instancia == null) {
			conexionClass = new ConexionBDD();
		}
		return instancia;
	}
	
	public static void cerrar(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs= null;
	}
	public static void cerrar(PreparedStatement pstm) {
		try {
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pstm= null;
	}
}
