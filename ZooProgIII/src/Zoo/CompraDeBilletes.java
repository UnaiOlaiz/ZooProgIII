package Zoo;

import java.util.ArrayList;
import java.util.Date;

public class CompraDeBilletes {
	
	int precio;
	Date fecha;
	
	ArrayList<CompraDeBilletes> compras = new ArrayList<>();
	public CompraDeBilletes() {
		super();
		this.precio = 0;
		this.fecha = null;
		this.compras = new ArrayList<>();
	}
	public CompraDeBilletes(int precio, Date fecha, ArrayList<CompraDeBilletes> compras) {
		super();
		this.precio = precio;
		this.fecha = fecha;
		this.compras = compras;
	}
	public ArrayList<CompraDeBilletes> getCompras() {
		return compras;
	}
	public void setCompras(ArrayList<CompraDeBilletes> compras) {
		this.compras = compras;
	}
	public CompraDeBilletes(int precio, Date fecha) {
		super();
		this.precio = precio;
		this.fecha = fecha;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "CompraDeBilletes [precio=" + precio + ", fecha=" + fecha + "]";
	}
	
	

}
