package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.AccesoDB;
import com.zalost.Persistencia.DAO;
import com.zalost.Persistencia.DAOManager;

public class Test3 {
	//Usamos métodos Hibernate y HQL
	public static void executeTest() {
		System.out.println("\n\n----------TEST 3----------");
		
		DAO acceso = DAOManager.getInstance().getAcceso();
		
		//Importante, usar los nombres definidos en Java
		acceso.executeHQLQuery(
		"update Departamento set "
		+ "NombreDep='NombreActualizado' "
		+ "where IdDep=2");
		
		//Se podría usar una query distinta para hacer delete
	}
}
