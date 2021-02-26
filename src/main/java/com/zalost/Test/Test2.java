package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.AccesoDB;
import com.zalost.Persistencia.DAOManager;

public class Test2 {
	//Reflection
	public static void executeTest() {
		System.out.println("\n\n----------TEST 2----------");
		
		AccesoDB acceso = DAOManager.getInstance().getAcceso();	
		
		Empleado e = acceso.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Antes del cambio");
		System.out.println(e);
		
		//Cambiamos el nombre
		acceso.updateGenericByID(Empleado.class, 24, "NombreEmpleado", "REFLECTION");
		
		//Leemos desde DB
		e = acceso.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Después del cambio");
		System.out.println(e);
		
		//Cambiamos el sueldo
		acceso.updateGenericByID(Empleado.class, 24, "Sueldo", 9999);
		
		//Leemos desde DB
		e = acceso.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Después del cambio de sueldo");
		System.out.println(e);
	}
}
