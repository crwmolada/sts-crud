package com.edu.certus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionDB {

	private static final String usuario = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/sysventa";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	
	public static Connection getConexion() {
		// Si no se inicializa como null el método devolverá una variable no inicializada
		// lo que generará un error de compilación y Java no permite devolver variable que
		// no tengan un valor asignado.
		Connection conn = null;
		try {
			// Carga la clase del driver de mysql apuntando a la variable 'driver'		
			Class.forName(driver).newInstance(); // Crea instancia del driver (usado para compatibilidad de otras verciones de JDBC)
			conn = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexión establecida con éxito.");
		} catch (Exception e) {
			System.out.println("Error al establecer conexión: " + e.getMessage());
			e.printStackTrace(); //Muestra rastro de errres para obtener más detalles
			conn = null; //En caso de error se asegura de devolver null
					
		}
		
		return conn;
	}
	
	
	//Método para cerrar la conexión (void porque no devuelve un valor)
	public static void closeConexion(Connection conn) { // Resive la conexion que desea cerrar
		try {
			//Se verifica si existe conexión, si es null entonces no se estableció conexion
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet: objeto que guarda resultados de querys sql que unicamente devulve datos(SELECT)
	// Metodo que cierra el objeto ResultSet para liberar recursos utilizados 
	// evitando problemas de rendimiento en la app
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// Previene inyecciones sql, mejora rendimiento, buena práctica cerrar objetos
	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
