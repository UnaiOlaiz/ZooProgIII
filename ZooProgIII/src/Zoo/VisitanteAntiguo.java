package Zoo;

import java.util.Objects;

public class VisitanteAntiguo {
	
	// Métodos hashCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(DNI, contrasenia, correo, edad, nVisitas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitanteAntiguo other = (VisitanteAntiguo) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(contrasenia, other.contrasenia)
				&& Objects.equals(correo, other.correo) && edad == other.edad && nVisitas == other.nVisitas
				&& Objects.equals(nombre, other.nombre);
	}



	//Declaracion de atributos
	protected String nombre;
	protected String DNI;
	protected int edad;
	protected int nVisitas;
	protected String correo;
	protected String contrasenia;
	
	//Constructores con y sin argumentos
	public VisitanteAntiguo(String nombre, String dNI, int edad, int nVisitas, String correo, String contrasenia) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.edad = edad;
		this.nVisitas = nVisitas;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	
	public VisitanteAntiguo() {
		this.nombre = "";
		DNI = "";
		this.edad = 0;
		this.nVisitas = 0;
		this.correo = "";
		this.contrasenia = "";
	}
	

	public VisitanteAntiguo(String nombre, String dNI, String contrasenia) {
		super();
		this.nombre = nombre;
		DNI = dNI;
		this.contrasenia = contrasenia;
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getnVisitas() {
		return nVisitas;
	}

	public void setnVisitas(int nVisitas) {
		this.nVisitas = nVisitas;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	// Método toString
	@Override
	public String toString() {
		return "Visistante [nombre=" + nombre + ", DNI=" + DNI + ", edad=" + edad + ", nVisitas=" + nVisitas
				+ ", correo=" + correo + ", contrasenia=" + contrasenia + "]";
	}

	
	
	// Otros métodos
	public int obtenerDscuento() {
		int edad = this.getEdad();
		if(edad < 7 || edad > 70) {
			return 1;
		}else if(edad > 7 && edad < 12) {
			return (int) 0.2;
		}else {
			return 0;
		}
	}

}
