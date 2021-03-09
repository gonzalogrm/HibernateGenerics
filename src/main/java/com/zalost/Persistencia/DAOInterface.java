package com.zalost.Persistencia;

import java.util.List;

import com.zalost.Modelo.IHasIntID;

public interface DAOInterface {
	public void InsertAutoID(Object o);
	public <T extends IHasIntID> T selectGenericByAutoID(Class<T> t, int ID);	
	public <T> List<T> selectGenericFrom(Class<T> t, String criteria);
	public <T extends IHasIntID> void updateGenericByID(
			Class<T> t, int ID, String propertyName, Object value);
}
