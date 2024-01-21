package Zoo;

import java.sql.Date;

public class Animal {
	String id_animal, nombre, especie, habitat;
	Date fecha_nacimiento;
	public String getId_animal() {
		return id_animal;
	}
	public void setId_animal(String id_animal) {
		this.id_animal = id_animal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	@Override
	public String toString() {
	    return String.format("ID: %s | Nombre: %s | Especie: %s | Fecha Nacimiento: %s | Hábitat: %s",
	                         id_animal, nombre, especie, fecha_nacimiento, habitat);
	}
	

}