package Zoo;

public class Exhibicion {
	
	String id_exhibicion, nombre, descripcion, id_animal;

	@Override
	public String toString() {
		return "Exhibicion [id_exhibicion=" + id_exhibicion + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", id_animal=" + id_animal + "]";
	}

	public String getId_exhibicion() {
		return id_exhibicion;
	}

	public void setId_exhibicion(String id_exhibicion) {
		this.id_exhibicion = id_exhibicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId_animal() {
		return id_animal;
	}

	public void setId_animal(String id_animal) {
		this.id_animal = id_animal;
	}

}
