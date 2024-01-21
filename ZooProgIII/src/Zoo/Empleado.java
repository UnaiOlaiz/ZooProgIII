package Zoo;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Empleado {
	String DNI, NombreEmpleado, PuestoEmpleado, Contrasena;
	
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	float SalarioEmpleado;
	Date FechaContratacion;
	
	public Empleado() {
		super();
		DNI = "";
		NombreEmpleado = "";
		PuestoEmpleado = "";
		SalarioEmpleado = 0;
		FechaContratacion = null;
		Contrasena = "";
	}
	public Empleado(String dNI, String nombreEmpleado, String puestoEmpleado, String contrasena) {
		super();
		DNI = dNI;
		NombreEmpleado = nombreEmpleado;
		PuestoEmpleado = puestoEmpleado;
		Contrasena = contrasena;
	}
	
	
	@Override
	public String toString() {
		return "Empleado [NombreEmpleado=" + NombreEmpleado + ", PuestoEmpleado=" + PuestoEmpleado + "]";
	}
	public String getDNI() { 
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombreEmpleado() {
		return NombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}
	public String getPuestoEmpleado() {
		return PuestoEmpleado;
	}
	public void setPuestoEmpleado(String puestoEmpleado) {
		PuestoEmpleado = puestoEmpleado;
	}
	public float getSalarioEmpleado() {
		return SalarioEmpleado;
	}
	public void setSalarioEmpleado(float salarioEmpleado) {
		SalarioEmpleado = salarioEmpleado;
	}
	public Date getFechaContratacion() {
		return FechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion2) {
		FechaContratacion = fechaContratacion2;
	}
}