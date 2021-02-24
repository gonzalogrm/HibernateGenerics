package com.zalost.Persistencia;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zalost.Modelo.*;

public class AccesoDB {
	public static <T extends IHasIntID> T SelectGenericByAutoID(Class<T> t, int ID) {
		T result =  null;
		
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(t).buildSessionFactory();
	    	
    	Session session = factory.openSession();   	

    	try {
        	//Comenzamos Transacción
        	session.beginTransaction();   
        	//Read
        	result =t.cast(session.get(t, ID));
        	//Commit
        	session.getTransaction().commit();
        	//Cerramos session
        	session.close();

		}finally{
			factory.close();
		}    	
    	return result;
	}
	
	//Example criteria: "from Empleado e where e.IdEmpleado > 20"
	public static <T> List<T> SelectGenericFrom(Class<T> t, String criteria) {
		List<T> result = new ArrayList<T>();
		
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(t).buildSessionFactory();
	    	
    	Session session = factory.openSession();
    	
    	try {
        	//Comenzamos Transacción
        	session.beginTransaction();   
        	//Read
        	result = (ArrayList<T>)session.createQuery(criteria).getResultList();
        	//Commit
        	session.getTransaction().commit();
        	//Cerramos session
        	session.close();

		}finally{
			factory.close();
		}
    	
    	return result;
	}
	
	public static <T extends IHasIntID> void UpdateGenericByID(
			Class<T> t, int ID, String propertyName, Object value){
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(t).buildSessionFactory();
	    	
    	Session session = factory.openSession();
		
    	T result =  null;
    	
    	try {
        	//Comenzamos Transacción
        	session.beginTransaction();   
        	//Obtenemos el objeto desde DB
        	result = t.cast(session.get(t, ID));        	
        	//Cambiamos el valor de la variable usando Reflection
        	invokeSetter(result, propertyName, value);        	
        	//Commit
        	session.getTransaction().commit();
        	//Cerramos session
        	session.close();
		}finally{
			factory.close();
		}
	}	
	
	//Más información y explicación: 
	//https://java2blog.com/invoke-getters-setters-using-reflection-java/
	
	public static void invokeSetter(Object obj, String propertyName, Object variableValue)
    {
        PropertyDescriptor descriptor;
        try {
        	descriptor = 
        			new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = 
            		descriptor.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
 
    }
	
	public void invokeGetter(Object obj, String variableName)
    {
        try {
            PropertyDescriptor descriptor = 
            		new PropertyDescriptor(variableName, obj.getClass());
            Method getter = 
            		descriptor.getReadMethod();
            Object o = getter.invoke(obj);
            System.out.println(o);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
