package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.*;
import java.util.*;

public class Test1 {
	public static void executeTest() {
		System.out.println("\n\n----------TEST 1----------");
		System.out.println("----------Empleados----------");
		DAO acceso = DAOManager.getInstance().getAcceso();
		
		Empleado e = acceso.selectGenericByAutoID(Empleado.class, 24);
		
		List<Empleado> todosEmpleados =
				acceso.selectGenericFrom(
				Empleado.class, 
				"from Empleado e where e.IdEmpleado > 23");	
	
		//Print
		System.out.println("Empleado por ID");
		System.out.println(e);
		
		System.out.println("--------------------");
		System.out.println("Empleados solicitados:");
		for (Empleado empleado : todosEmpleados) {
			System.out.println(empleado);
		}
		
		System.out.println("----------Departamento----------");
		Departamento d = acceso.selectGenericByAutoID(Departamento.class, 1);
		
		List<Departamento> todosDepartamentos =
				acceso.selectGenericFrom(
				Departamento.class, 
				"from Departamento d where d.IdDep > 1");	
	
		//Print
		System.out.println("Departamento por ID");
		System.out.println(d);
		
		System.out.println("--------------------");
		System.out.println("Departamentos solicitados:");
		for (Departamento dep : todosDepartamentos) {
			System.out.println(dep);		
		}
	}
}
