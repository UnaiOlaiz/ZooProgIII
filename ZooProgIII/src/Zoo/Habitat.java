package Zoo;

public class Habitat {
	
	String id_habitat, nombre, tipo;
	@Override
	public String toString() {
		return "Habitat [id_habitat=" + id_habitat + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	public String getId_habitat() {
		return id_habitat;
	}

	public void setId_habitat(String id_habitat) {
		this.id_habitat = id_habitat;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
