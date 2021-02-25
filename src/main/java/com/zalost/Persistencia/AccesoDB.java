package com.zalost.Persistencia;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxyHelper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zalost.Modelo.*;

public class AccesoDB {	
	
	 private static SessionFactory sessionFactory = buildSessionFactory();
	 
	   public static SessionFactory buildSessionFactory() 
	   {
	      try
	      {
	         if (sessionFactory == null) 
	         {
	            StandardServiceRegistry standardRegistry = 
	            		new StandardServiceRegistryBuilder()
	                  .configure("hibernate.cfg.xml").build();
	             
	            Metadata metaData = new MetadataSources(standardRegistry)
	                  .getMetadataBuilder()
	                  .build();
	             
	            sessionFactory = metaData.getSessionFactoryBuilder().build();
	         }
	         return sessionFactory;
	      } catch (Throwable ex) {
	         throw new ExceptionInInitializerError(ex);
	      }
	   }
	 
	   public static SessionFactory getSessionFactory() {
	      return sessionFactory;
	   }
	 
	   public static void closeFactory() {
	      getSessionFactory().close();
	   }
	   
	   public static <T extends IHasIntID> T selectGenericByAutoID(Class<T> t, int ID) {
		T result =  null;

    	Session session = getSessionFactory().openSession();   	
    	//Comenzamos Transacción
    	session.beginTransaction();   
    	//Read
    	result =t.cast(session.get(t, ID));
    	//Commit
    	session.getTransaction().commit();
    	
    	return result;
	}
	
	//Example criteria: "from Empleado e where e.IdEmpleado > 20"
	public static <T> List<T> selectGenericFrom(Class<T> t, String criteria) {
		List<T> result = new ArrayList<T>();
    	
    	Session session = getSessionFactory().openSession();
    	
    	//Comenzamos Transacción
    	session.beginTransaction();   
    	//Read
    	result = (ArrayList<T>)session.createQuery(criteria).getResultList();
    	//Commit
    	session.getTransaction().commit();
    	
    	return result;	
	}
	
	public static <T> void executeHQLQuery(Class<T> t, String criteria) {
	    	
    	Session session = getSessionFactory().openSession();
    	
    	//Comenzamos Transacción
    	session.beginTransaction();   
    	//Read
    	session.createQuery(criteria).executeUpdate();
    	//Commit
    	session.getTransaction().commit();

	}
	
	public static <T extends IHasIntID> void updateGenericByID(
			Class<T> t, int ID, String propertyName, Object value){
		SessionFactory factory =
				new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(t).buildSessionFactory();
	    	
    	Session session = factory.openSession();
		
    	T result =  null;
    	
    	//Comenzamos Transacción
    	session.beginTransaction();   
    	//Obtenemos el objeto desde DB
    	result = t.cast(session.get(t, ID));        	
    	//Cambiamos el valor de la variable usando Reflection
    	invokeSetter(result, propertyName, value);        	
    	//Commit
    	session.getTransaction().commit();
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
