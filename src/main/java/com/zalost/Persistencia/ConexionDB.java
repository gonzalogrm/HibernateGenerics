package com.zalost.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	public static String user;
	public static String pass;
	public static String DBName;
	
	protected Connection miConexion;
    
    public void abrirConexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String fullUrl = "jdbc:mysql://localhost:3306/"
                + DBName //Nombre BBDD
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true"
                + "&useSSL=false";
        
        String easyURL =
        		"jdbc:mysql://localhost:3306/"
        		+ DBName
        		+ "useSSL=false&serverTimezone=UTC";
                 
        miConexion = DriverManager.getConnection(
        		easyURL,user, pass);          
        
        System.out.println("EXITO AL ABRIR CONEXION");
    }
    
    public void cerrarConexion() throws SQLException {
        miConexion.close();
    }
}
