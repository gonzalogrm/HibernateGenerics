package com.zalost.Persistencia;

public class DAOManager {
	private AccesoDB acceso;
	private static DAOManager instance;

	private DAOManager() {
		acceso = new AccesoDB();
	}

	public static DAOManager getInstance() {
		if(instance == null) instance = new DAOManager();
		return instance;
	}
	
	public AccesoDB getAcceso() {		
		return acceso;
	}

	public void setAcceso(AccesoDB acceso) {
		this.acceso = acceso;
	}
}
