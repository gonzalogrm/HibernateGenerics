package com.zalost.HibernateGeneric;

import com.zalost.Modelo.*;
import com.zalost.Persistencia.*;
import com.zalost.Test.*;

import java.util.*;

public class Main {

	public static void main(String[] args) {	
		AccesoDB.buildSessionFactory();
		
		Test1.executeTest();
		
		AccesoDB.shutdown();
	}
}
