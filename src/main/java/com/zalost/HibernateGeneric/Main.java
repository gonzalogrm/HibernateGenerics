package com.zalost.HibernateGeneric;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.*;
import com.zalost.Test.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		DAOManager.getInstance().getAcceso().buildSessionFactory();
		
		Test1.executeTest();
		Test2.executeTest();
		Test3.executeTest();
		
		System.out.println("Cerramos Factory");
		DAOManager.getInstance().getAcceso().closeFactory();
	}
}
