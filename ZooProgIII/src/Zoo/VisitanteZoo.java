package Zoo;

import java.util.Date;

public class VisitanteZoo {
	int idVisitante;
	String nombreVisitante;
	int cantidadVisitantes;
	public int getCantidadVisitantes() {
		return cantidadVisitantes;
	}
	public void setCantidadVisitantes(int cantidadVisitantes) {
		this.cantidadVisitantes = cantidadVisitantes;
	}
	String fechaCompra;
	
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public String getNombreVisitante() {
		return nombreVisitante;
	}
	public void setNombreVisitante(String nombreVisitante) {
		this.nombreVisitante = nombreVisitante;
	}
	
	public VisitanteZoo(int idVisitante, String nombreVisitante, int cantidadVisitantes, String fechaCompra) {
		super();
		this.idVisitante = idVisitante;
		this.nombreVisitante = nombreVisitante;
		this.cantidadVisitantes = cantidadVisitantes;
		this.fechaCompra = fechaCompra;
	}
	public VisitanteZoo(int idVisitante, String nombreVisitante, int cantidadVisitantes, Date fechaCompra) {
		super();
		this.idVisitante = idVisitante;
		this.nombreVisitante = nombreVisitante;
		this.cantidadVisitantes = cantidadVisitantes;
		this.fechaCompra = null;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	@Override
	public String toString() {
		return "El visitante: " + nombreVisitante + " con identificativo: " + idVisitante + " ha sido correctamente registrado el " + fechaCompra + ".";
	}
	
}
