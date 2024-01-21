package Zoo;

public class Trabajador {
	//Declaracion de atributos
	protected String DNI;
	@Override
	public String toString() {
		return "Trabajador [DNI=" + DNI + ", nombre=" + nombre + ", puesto=" + puesto + "]";
	}


	protected String nombre;
	protected String apellido;
	protected int horasDeTrabajo;
	protected String puesto;
	protected int nTlf;
	protected String correo;
	protected String con;
	
	
	public Trabajador() {
		super();
	}


	public Trabajador(String dNI, String nombre, String apellido, int horasDeTrabajo, String puesto, int nTlf,
			String correo, String con) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.horasDeTrabajo = horasDeTrabajo;
		this.puesto = puesto;
		this.nTlf = nTlf;
		this.correo = correo;
		this.con = con;
	}


	public Trabajador(String p_tra, String nombre, String DNI, String con) {
		super();
		this.puesto = p_tra;
		this.nombre = nombre;
		this.DNI = DNI;
		this.con = con;
	}


	public Trabajador(String dNI, String nombre, String con) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.con = con;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getHorasDeTrabajo() {
		return horasDeTrabajo;
	}


	public void setHorasDeTrabajo(int horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public int getnTlf() {
		return nTlf;
	}


	public void setnTlf(int nTlf) {
		this.nTlf = nTlf;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCon() {
		return con;
	}


	public void setCon(String con) {
		this.con = con;
	}

	
	/*
	 * public int CalcularSueldo() {
		
		int sueldoPorHora;
		
		if (puesto == Puesto.ADMINISTRADOR) {
			sueldoPorHora = 14;
			
		} else if (puesto == Puesto.CUIDADOR) {
			sueldoPorHora = 15;
			
		} else if (puesto == Puesto.VETERINARIO) {
			sueldoPorHora = 18;
			
		} else {
			sueldoPorHora = 12;
		}
		
		return sueldoPorHora * horasDeTrabajo;
		
	}
	 */
	
}

