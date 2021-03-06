package com.zalost.Modelo;

import javax.persistence.*;

@Entity
@Table(name="departamentos")
public class Departamento implements IHasIntID {
	
	public Departamento(){}
	
	public Departamento(String nombreDep) {
		NombreDep = nombreDep;
	}
	
	public Departamento(int idDep, String nombreDep) {
		IdDep = idDep;
		NombreDep = nombreDep;
	}
	
	@Override
	public String toString() {
		return "Departamento [IdDep=" + IdDep + ", NombreDep=" + NombreDep + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	@Id
	@Column(name="IdDepartamento") 
	private int IdDep;
	
	@Column(name="NombreDepartamento") 
	private String NombreDep;

	
	//Getters Setters
	public String getNombreDep() {
		return NombreDep;
	}

	public void setNombreDep(String nombreDep) {
		NombreDep = nombreDep;
	}

	@Override
	public int getId() {
		return IdDep;
	}

	@Override
	public void setId(int id) {
		IdDep = id;		
	}	
}
