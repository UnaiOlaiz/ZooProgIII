package Zoo;

import java.sql.Date;

public class Visitante {
	
	String id_visitante;
	String nombre;
	int edad;
	Date fecha_visita;
	@Override
	public String toString() {
		return "Visitante [id_visitante=" + id_visitante + ", nombre=" + nombre + ", edad=" + edad + ", fecha_visita="
				+ fecha_visita + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFecha_visita() {
		return fecha_visita;
	}
	public void setFecha_visita(Date fechaSQL) {
		this.fecha_visita = fechaSQL;
	}

	public String getId_visitante() {
		return id_visitante;
	}

	public void setId_visitante(String id_visitante) {
		this.id_visitante = id_visitante;
	}

	public Visitante(String id_visitante, String nombre, int edad, Date fecha_visita) {
		super();
		this.id_visitante = id_visitante;
		this.nombre = nombre;
		this.edad = edad;
		this.fecha_visita = fecha_visita;
	}

	public Visitante() {
		super();
		this.id_visitante = "";
		this.nombre = "";
		this.edad = 0;
		this.fecha_visita = null;
	}

	


	
	
	
	
	
}
