package com.zalost.Modelo;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado implements IHasIntID{
	
	public Empleado() {}	
	
	public Empleado(int idDepartamento, String nombreEmpleado, int sueldo) {
		IdDepartamento = idDepartamento;
		NombreEmpleado = nombreEmpleado;
		Sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return "Empleado [IdEmpleado=" + IdEmpleado + ", IdDepartamento=" + IdDepartamento + ", NombreEmpleado="
				+ NombreEmpleado + ", Sueldo=" + Sueldo + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementado
	@Column(name="IdEmpleado") 
	private int IdEmpleado;
	
	@Column(name="IdDepartamento") 
	private int IdDepartamento;
	
	@Column(name="NombreEmpleado") 
	private String NombreEmpleado;
	
	@Column(name="Sueldo") 
	private int Sueldo;

	
	//Getters Setters
	public int getIdDepartamento() {
		return IdDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		IdDepartamento = idDepartamento;
	}

	public String getNombreEmpleado() {
		return NombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}

	public int getSueldo() {
		return Sueldo;
	}

	public void setSueldo(int sueldo) {
		Sueldo = sueldo;
	}

	public int getId() {
		return IdEmpleado;
	}

	public void setId(int id) {
		IdEmpleado = id;
	}
}
