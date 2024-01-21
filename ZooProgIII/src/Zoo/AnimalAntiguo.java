package Zoo;

public class AnimalAntiguo {
	
	protected String nombre, descripcion;
	protected int ID, edad;
	protected Genero genero;
	protected Trabajador cuidador;
	protected boolean isPadre, isEnfermo;;

	
	//Constructores
	public AnimalAntiguo(String nombre, int iD, Genero genero, int edad, Trabajador cuidador, String descripcion, boolean isPadre, boolean isEnfermo) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.genero = genero;
		this.edad = edad;
		this.cuidador = cuidador;
		this.descripcion = descripcion;
		this.isPadre = isPadre;
		this.isEnfermo = isEnfermo;
	}

	public AnimalAntiguo() {
		
		this.nombre = "";
		ID = 0;
		this.genero = null;
		this.edad = 0;
		this.cuidador = null;
		this.descripcion = "";
		this.isPadre = false;
		this.isEnfermo = false;
	}
	
	//Getters y Setters

	public boolean isEnfermo() {
		return isEnfermo;
	}

	public void setEnfermo(boolean isEnfermo) {
		this.isEnfermo = isEnfermo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Trabajador getCuidador() {
		return cuidador;
	}

	public void setCuidador(Trabajador cuidador) {
		this.cuidador = cuidador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPadre() {
		return isPadre;
	}

	public void setPadre(boolean isPadre) {
		this.isPadre = isPadre;
	}

	// To String
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", descripcion=" + descripcion + ", ID=" + ID + ", edad=" + edad
				+ ", genero=" + genero + ", cuidador=" + cuidador + ", isPadre=" + isPadre + ", isEnfermo=" + isEnfermo
				+ "]";
	}

	
	
	
	
	
	
	
	
	

}
