package com.zalost.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	protected Connection miConexion;
    
    public void abrirConexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String fullUrl = "jdbc:mysql://localhost:3306/"
                + "examen_agruposistemas" //Nombre BBDD
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true"
                + "&useSSL=false";
        
        String easyURL =
        		"jdbc:mysql://localhost:3306/examen_agruposistemas?useSSL=false&serverTimezone=UTC";
                 
        miConexion = DriverManager.getConnection(easyURL,"root", "root");          
        
        System.out.println("EXITO AL ABRIR CONEXION");
    }
    
    public void cerrarConexion() throws SQLException {
        miConexion.close();
    }
}
