package BaseDeDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Zoo.Animal;
import Zoo.Empleado;
import Zoo.Exhibicion;
import Zoo.Habitat;
import Zoo.Puesto;
import Zoo.Visitante;

public class VisualizarBD {
	
	private static Connection conexion;
	private static Logger logger;
	
	public static ArrayList<Empleado> visualizarEmpleados() {
		try {
			logger = java.util.logging.Logger.getLogger("Logger BD");
			logger.addHandler(new FileHandler("LoggerZOOYARZABAL.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<Empleado> empleados = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Empleados";
				ResultSet rs = statement.executeQuery( sent );
				while ( rs.next() ) { 
					String DNI = rs.getString( "id_empleado" );
					String NombreEmpleado = rs.getString( "nombre" );
					String PuestoEmpleado = rs.getString( "puesto" );
					float SalarioEmpleado = rs.getFloat( "salario" );
					
					// String FechaContratacion = rs.getString( "fecha_contratacion" );
					// SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					// Date fechaContratacion = (Date) formatoFecha.parse(FechaContratacion);
					
					// java.util.Date fechaUtil = rs.getDate( "fecha_contratacion" );
					// java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
					
					String fechaString = rs.getString( "fecha_contratacion" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaContratacion = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaContratacion.getTime());
					
					Empleado empleado = new Empleado();
					empleado.setDNI(DNI);
					empleado.setNombreEmpleado(NombreEmpleado);
					empleado.setPuestoEmpleado(PuestoEmpleado);
					empleado.setSalarioEmpleado(SalarioEmpleado);
					
					// empleado.setFechaContratacion(fechaSQL);
					// empleado.setFechaContratacion(fechaContratacion);
					empleado.setFechaContratacion(fechaSQL);
					
//					empleados.add(empleado);
//					for ( Empleado emp : empleados ) {
//						System.out.println( emp + "\n" );
//					}
				}
				rs.close();
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return empleados;
	}
	
	public static ArrayList<Habitat> visualizarHabitats() {
		ArrayList<Habitat> habitats = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Habitats";
				ResultSet rs = statement.executeQuery( sent );
				while ( rs.next() ) {
					String id_habitat = rs.getString( "id_habitat" );
					String nombre = rs.getString( "nombre" );
					String tipo = rs.getString( "tipo" );
					
					Habitat habitat = new Habitat();
					habitat.setId_habitat(id_habitat);
					habitat.setNombre(nombre);
					habitat.setTipo(tipo);
					
					habitats.add(habitat);
					for ( Habitat h : habitats ) {
						System.out.println( h + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return habitats;
	}
	
	public static ArrayList<Animal> visualizarAnimales() {
		ArrayList<Animal> animales = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Animales";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_animal = rs.getString( "id_animal" );
					String nombre = rs.getString( "nombre" );
					String especie = rs.getString( "especie" );
					String habitat = rs.getString( "habitat" );
					
					String fechaString = rs.getString( "fecha_nacimiento" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaNacimiento = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaNacimiento.getTime());
					
					Animal animal = new Animal();
					animal.setId_animal(id_animal);
					animal.setNombre(nombre);
					animal.setEspecie(especie);
					animal.setFecha_nacimiento(fechaSQL);
					animal.setHabitat(habitat);
					
					animales.add(animal);
					
//					for ( Animal a : animales ) {
//						System.out.println( a + "\n" );
//					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return animales;
		
	}
	
	public static ArrayList<Visitante> visualizarVisitantes() {
		ArrayList<Visitante> visitantes = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Visitantes";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_visitante = rs.getString( "id_visitante" );
					String nombre = rs.getString( "nombre" );
					int edad = rs.getInt( "edad" );
					String fechaString = rs.getString( "fecha_visita" );
					SimpleDateFormat formatoFecha = new SimpleDateFormat( "yyyy-MM-dd" );
					java.util.Date fechaVisita = formatoFecha.parse(fechaString);
					java.sql.Date fechaSQL = new java.sql.Date(fechaVisita.getTime());
					
					Visitante visitante = new Visitante();
					visitante.setId_visitante(id_visitante);
					visitante.setNombre(nombre);
					visitante.setEdad(edad);
					visitante.setFecha_visita(fechaSQL);
					visitantes.add(visitante);
					
					for ( Visitante a : visitantes ) {
						System.out.println( a + "\n" );
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return visitantes;
		
	}
	
	public static ArrayList<Exhibicion> visualizarExhibiciones() {
		ArrayList<Exhibicion> exhibiciones = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			
			try {
				Statement statement = conexion.createStatement();
				String sent = "SELECT * FROM Exhibiciones";
				ResultSet rs = statement.executeQuery( sent );
				while (rs.next()) {
					String id_exhibicion = rs.getString( "id_exhibicion" );
					String nombre = rs.getString( "nombre" );
					String descripcion = rs.getString( "descripcion" );
					String id_animal = rs.getString( "id_animal" );
					
					Exhibicion exhibicion = new Exhibicion();
					exhibicion.setId_exhibicion(id_exhibicion);
					exhibicion.setNombre(nombre);
					exhibicion.setDescripcion(descripcion);
					exhibicion.setId_animal(id_animal);
					
					exhibiciones.add(exhibicion);
					
					for ( Exhibicion a : exhibiciones ) {
						System.out.println( a + "\n" );
					}
				}
			}catch (Exception e) {
			}
		}catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return exhibiciones;
		
	}
	
	

	public static ArrayList<Animal> obtenerAnimalesArticos() {
		ArrayList<Animal> animalesArticos = new ArrayList<>();
		try {
			String sentenciaSQL = "SELECT * FROM Animales WHERE habitat = ?;";
			PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setString(1, "Polar");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				String habitat = rs.getString("habitat");
				
				
				Animal animalPolar = new Animal();
				animalPolar.setId_animal(id_animal);
				animalPolar.setNombre(nombre);
				animalPolar.setEspecie(especie);
				animalPolar.setHabitat(habitat);
				
				animalesArticos.add(animalPolar);
				
				
				
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
		}
		return animalesArticos;
	}

	public static ArrayList<Animal> obtenerTortugas() {
		ArrayList<Animal> tortugas = new ArrayList<>();
		try {
			String statementSQL = "SELECT * FROM Animales WHERE nombre = ?";
			PreparedStatement preparedStatement = conexion.prepareStatement(statementSQL);
			preparedStatement.setString(1, "Tortuga Marina");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				String habitat = rs.getString("habitat");
				
				Animal tortuga = new Animal();
				tortuga.setId_animal(id_animal);
				tortuga.setNombre(nombre);
				tortuga.setEspecie(especie);
				tortuga.setHabitat(habitat);
				
				tortugas.add(tortuga);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tortugas;
		
	}

	public static ArrayList<Animal> obtenerTigres() {
		ArrayList<Animal> tigres = new ArrayList<>(); 
		try {
			String statementSQL = "SELECT * FROM Animales WHERE nombre = ?";
			PreparedStatement preparedStatement = conexion.prepareStatement(statementSQL);
			preparedStatement.setString(1, "Tigre");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				String habitat = rs.getString("habitat");
				
				Animal tortuga = new Animal();
				tortuga.setId_animal(id_animal);
				tortuga.setNombre(nombre);
				tortuga.setEspecie(especie);
				tortuga.setHabitat(habitat);
				
				tigres.add(tortuga);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tigres;
		
	}

	public static ArrayList<Animal> obtenerAnimalesAcuaticos() {
		ArrayList<Animal> animalesAcuaticos = new ArrayList<>();
		try {
			String sentenciaSQL = "SELECT * FROM Animales WHERE habitat = ?;";
			PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setString(1, "Océano");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				String habitat = rs.getString("habitat");
				
				Animal animalMarino = new Animal();
				animalMarino.setId_animal(id_animal);
				animalMarino.setNombre(nombre);
				animalMarino.setEspecie(especie);
				animalMarino.setHabitat(habitat);
				
				animalesAcuaticos.add(animalMarino);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animalesAcuaticos;
	}

	public static ArrayList<Animal> obtenerLeones() {
		ArrayList<Animal> leones = new ArrayList<>(); 
		try {
			String statementSQL = "SELECT * FROM Animales WHERE nombre = ?";
			PreparedStatement preparedStatement = conexion.prepareStatement(statementSQL);
			preparedStatement.setString(1, "León");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
				String nombre = rs.getString("nombre");
				String especie = rs.getString("especie");
				String habitat = rs.getString("habitat");
				
				Animal tortuga = new Animal();
				tortuga.setId_animal(id_animal);
				tortuga.setNombre(nombre);
				tortuga.setEspecie(especie);
				tortuga.setHabitat(habitat);
				
				leones.add(tortuga);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leones;
	}

	public static ArrayList<Animal> cargarAnimalesEnfermos(){
		ArrayList<Animal> animalesEnfermos = new ArrayList<>();
		try {
			String sentenciaSQL = "SELECT * FROM Animales";
			Statement statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery(sentenciaSQL);
			ArrayList<Animal> animales = new ArrayList<>();
			while (rs.next()) {
				String id_animal = rs.getString("id_animal");
                String nombre = rs.getString("nombre");
                String especie = rs.getString("especie");
                String habitat = rs.getString("habitat");
                
                Animal animalEnfermo = new Animal();
                animalEnfermo.setId_animal(id_animal);
                animalEnfermo.setNombre(nombre);
                animalEnfermo.setEspecie(especie);
                animalEnfermo.setHabitat(habitat);
                
                animales.add(animalEnfermo);
			}
			rs.close();
			// Sólo vamos a seleccionar 5 para que el combobox no esté sobrecargado
			Collections.shuffle(animales);
			if (animales.size() >= 5) {
				animalesEnfermos.addAll(animales.subList(0, 5));
			} else {
				System.err.println("Erro pa");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animalesEnfermos;
	}
	
	public static ArrayList<Empleado> cargarVeterinarios(){
		ArrayList<Empleado> veterinarios = new ArrayList<>();
		try {
			String SentSQL = "SELECT * FROM Empleados WHERE puesto = 'Veterinario'";
			Statement statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery(SentSQL);
			while (rs.next()) {
				int id_empleado = rs.getInt("id_empleado");
				String nombre = rs.getString("nombre");
				String puesto = rs.getString("puesto");
				Puesto puesto2 = Puesto.valueOf(puesto.toUpperCase());
				
				Empleado vet = new Empleado();
				vet.setNombreEmpleado(nombre);
//				vet.setPuestoEmpleado(puesto2);
			
				veterinarios.add(vet);
			}
		} catch (Exception e) {e.printStackTrace();}
		return veterinarios;
	}

	
	
}