package com.zalost.Persistencia;

import org.hibernate.SessionFactory;

public interface DAOHibernateInterface {
	public SessionFactory buildSessionFactory();
	public SessionFactory getSessionFactory();
	public void closeFactory();
	public void executeHQLQuery(String query);
}
