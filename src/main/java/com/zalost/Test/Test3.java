package com.zalost.Test;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.AccesoDB;

public class Test3 {
	//Usamos métodos Hibernate y HQL
	public static void executeTest() {
		//Importante, usar los nombres definidos en Java
		AccesoDB.executeHQLQuery(Departamento.class, 
		"update Departamento set "
		+ "NombreDep='NombreActualizado' "
		+ "where IdDep=2");
		
		//Se podría usar una query distinta para hacer deletes
		
	}
}
