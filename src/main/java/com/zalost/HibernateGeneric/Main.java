package com.zalost.HibernateGeneric;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.*;
import com.zalost.Test.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {	
		//Introducir los datos de acceso a DB
		ConexionDB.DBName = "examen_agruposistemas";
		ConexionDB.user = "root";
		ConexionDB.pass = "root";
		
		AccesoDB.buildSessionFactory();
		
		Test1.executeTest();
		
		AccesoDB.shutdown();
	}
}
