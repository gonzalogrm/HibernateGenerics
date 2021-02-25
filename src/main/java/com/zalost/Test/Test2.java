package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.AccesoDB;

public class Test2 {
	//Reflection
	public static void executeTest() {
		Empleado e = AccesoDB.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Antes del cambio");
		System.out.println(e);
		
		//Cambiamos el nombre
		AccesoDB.updateGenericByID(Empleado.class, 24, "NombreEmpleado", "REFLECTION");
		
		//Leemos desde DB
		e = AccesoDB.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Después del cambio");
		System.out.println(e);
		
		//Cambiamos el sueldo
		AccesoDB.updateGenericByID(Empleado.class, 24, "Sueldo", 9999);
		
		//Leemos desde DB
		e = AccesoDB.selectGenericByAutoID(Empleado.class, 24);
		System.out.println("Empleado por ID, Después del cambio de sueldo");
		System.out.println(e);
	}
}
