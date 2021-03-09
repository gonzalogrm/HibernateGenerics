package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.DAO;
import com.zalost.Persistencia.DAOManager;

public class Test4 {	
	public static void executeTest() {
		System.out.println("\n\n----------TEST 4----------");
		
		DAO acceso = DAOManager.getInstance().getAcceso();
		
		//Ejemplos de Inserts
		Empleado e = new Empleado(1,"InsertEmpleado", 1234);
		Departamento d = new Departamento(4, "InsertDepartamento");
		
		//Inserts usando el mismo método DAO
		//acceso.InsertAutoID(e);
		acceso.InsertAutoID(d);		
	}
}
