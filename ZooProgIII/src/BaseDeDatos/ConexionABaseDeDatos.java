package BaseDeDatos;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;


import Zoo.Empleado;
import Zoo.Trabajador;

public class ConexionABaseDeDatos {

	private static Connection conexion;
	private static java.util.logging.Logger logger;
	
	public static Connection abrirConexion() {
		try {
			logger = java.util.logging.Logger.getLogger("Logger BD");
			logger.addHandler(new FileHandler("LoggerZOOYARZABAL.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:ZOOYARZABALBD.db");
			logger.log(Level.INFO, "Conexión establecida a BD");
			
			try {
				// Vamos a crear la base de datos desde 0
				Statement statement = conexion.createStatement();
				String sent = "CREATE TABLE Habitats (id_habitat INTEGER PRIMARY KEY, nombre TEXT NOT NULL, tipo TEXT);";
				statement.executeUpdate( sent );
				sent = "CREATE TABLE Animales (id_animal INTEGER PRIMARY KEY, nombre TEXT NOT NULL, especie TEXT NOT NULL, fecha_nacimiento DATE, genero TEXT, habitat TEXT NOT NULL, CONSTRAINT fk_habitat FOREIGN KEY (habitat) REFERENCES Habitats(nombre));";
				statement.executeUpdate( sent );
				sent = "CREATE TABLE Empleados (id_empleado INTEGER PRIMARY KEY, nombre TEXT NOT NULL, puesto TEXT, salario REAL, fecha_contratacion DATE);";
				statement.executeUpdate( sent );
				sent = "CREATE TABLE Visitantes (id_visitante INTEGER PRIMARY KEY, nombre TEXT NOT NULL, edad INTEGER, fecha_visita DATE);";
				statement.executeUpdate( sent );
				sent = "CREATE TABLE Exhibiciones (id_exhibicion INTEGER PRIMARY KEY, nombre TEXT NOT NULL, descripcion TEXT, id_animal INTEGER, CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES Animales(id_animal));";
				statement.executeUpdate( sent );
				logger.log(Level.INFO, "Tablas de la BD creadas correctamente");
				// Tablas ya creadas
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Error al crear las tablas, anteriormente creadas");
			}
			
			try {
				// Ahora introduciremos datos a las tablas
				String sent = "INSERT INTO Habitats (id_habitat, nombre, tipo) VALUES\r\n"
						+ "(99, 'Selva', 'Tropical'),\r\n"
						+ "(98, 'Savannah', 'Árido'),\r\n"
						+ "(97, 'Acuario', 'Acuático'),\r\n"
						+ "(96, 'Bosque', 'Templado'),\r\n"
						+ "(95, 'Desierto', 'Árido'),\r\n"
						+ "(94, 'Jungla', 'Tropical'),\r\n"
						+ "(93, 'Polar', 'Frío'),\r\n"
						+ "(92, 'Sabana', 'Árido'),\r\n"
						+ "(91, 'Océano', 'Acuático'),\r\n"
						+ "(90, 'Montaña', 'Frío');";
				Statement statement = conexion.createStatement();
				statement.execute( sent );
				
				sent = "INSERT INTO Animales (id_animal, nombre, especie, fecha_nacimiento, genero, habitat) VALUES\r\n"
				        + "(1, 'León', 'Panthera leo', '2010-05-15', 'Macho', 'Savannah'),\r\n"
				        + "(2, 'Tigre', 'Panthera tigris', '2012-02-28', 'Hembra', 'Selva'),\r\n"
				        + "(3, 'Delfín', 'Delphinidae', '2015-08-10', 'Macho', 'Acuario'),\r\n"
				        + "(4, 'Oso Polar', 'Ursus maritimus', '2013-12-20', 'Hembra', 'Polar'),\r\n"
				        + "(5, 'Elefante', 'Loxodonta africana', '2008-07-03', 'Macho', 'Sabana'),\r\n"
				        + "(6, 'Pingüino', 'Spheniscidae', '2016-04-05', 'Hembra', 'Polar'),\r\n"
				        + "(7, 'Jirafa', 'Giraffa camelopardalis', '2011-11-12', 'Macho', 'Savannah'),\r\n"
				        + "(8, 'Tortuga Marina', 'Cheloniidae', '2014-09-18', 'Hembra', 'Océano'),\r\n"
				        + "(9, 'Mono', 'Cercopithecidae', '2017-06-25', 'Macho', 'Jungla'),\r\n"
				        + "(10, 'Lince Ibérico', 'Lynx pardinus', '2019-03-08', 'Hembra', 'Bosque'),\r\n"
				        + "(11, 'Leopardo', 'Panthera pardus', '2014-09-05', 'Macho', 'Selva'),\r\n"
				        + "(12, 'Halcón', 'Falco peregrinus', '2016-12-08', 'Hembra', 'Montañas'),\r\n"
				        + "(13, 'Canguro', 'Macropus', '2018-02-20', 'Macho', 'Desierto'),\r\n"
				        + "(14, 'Oso Panda', 'Ailuropoda melanoleuca', '2010-06-15', 'Hembra', 'Bosque'),\r\n"
				        + "(15, 'Hipopótamo', 'Hippopotamus amphibius', '2012-11-30', 'Macho', 'Río'),\r\n"
				        + "(16, 'Puma', 'Puma concolor', '2017-07-18', 'Hembra', 'Montañas'),\r\n"
				        + "(17, 'Cocodrilo', 'Crocodylidae', '2013-04-25', 'Macho', 'Pantano'),\r\n"
				        + "(18, 'Águila', 'Aquila chrysaetos', '2015-10-10', 'Hembra', 'Cielo'),\r\n"
				        + "(19, 'Gorila', 'Gorilla', '2016-05-22', 'Macho', 'Selva'),\r\n"
				        + "(20, 'Tiburón', 'Carcharhinidae', '2011-08-03', 'Hembra', 'Océano'),\r\n"
				        + "(21, 'Cebra', 'Equus zebra', '2014-06-12', 'Macho', 'Savannah'),\r\n"
				        + "(22, 'Jaguar', 'Panthera onca', '2015-09-30', 'Hembra', 'Selva'),\r\n"
				        + "(23, 'Panda Rojo', 'Ailurus fulgens', '2017-04-15', 'Macho', 'Bosque'),\r\n"
				        + "(24, 'Camello', 'Camelus', '2019-01-22', 'Hembra', 'Desierto'),\r\n"
				        + "(25, 'Lechuza', 'Tyto alba', '2013-08-08', 'Macho', 'Bosque'),\r\n"
				        + "(26, 'Pantera', 'Panthera onca', '2014-06-07', 'Hembra', 'Selva');\r\n"
				        + "(271, 'León', 'Tyto alba', '2013-08-08', 'Macho', 'Bosque'),\r\n"
				        + "(281, 'León', 'Tyto alba', '2013-07-08', 'Hembra', 'Bosque'),\r\n"
				        + "(291, 'Tigre', 'Panthera tigris', '2002-02-28', 'Macho', 'Selva'),\r\n"
				 		+"(272, 'Tortuga Marina', 'Cheloniidae', '2014-09-18', 'Macho', 'Océano')," +
				    "(28, 'Tortuga Marina', 'Cheloniidae', '2016-03-22', 'Hembra', 'Océano')," +
				    "(29, 'Tortuga Marina', 'Cheloniidae', '2015-11-10', 'Macho', 'Océano')," +
				    "(30, 'Oso Polar', 'Ursus maritimus', '2012-12-15', 'Macho', 'Polar')," +
				    "(31, 'Oso Polar', 'Ursus maritimus', '2014-02-28', 'Hembra', 'Polar')," +
				    "(32, 'Pingüino', 'Spheniscidae', '2015-06-10', 'Macho', 'Polar')," +
				    "(33, 'Pingüino', 'Spheniscidae', '2017-04-15', 'Hembra', 'Polar')," +
				    "(34, 'León Marino', 'Otariidae', '2013-09-08', 'Macho', 'Océano')," +
				    "(35, 'León Marino', 'Otariidae', '2015-07-08', 'Hembra', 'Océano');";

				statement.executeUpdate(sent);
				logger.log(Level.INFO, "Animales insertados");

				
				sent = "INSERT INTO Empleados (id_empleado, nombre, puesto, salario, fecha_contratacion) VALUES\r\n"
						+ "(1, 'Juan Pérez', 'Guardián', 30000.00, '2010-03-15'),\r\n"
						+ "(2, 'María López', 'Biologo', 45000.00, '2012-08-22'),\r\n"
						+ "(3, 'Carlos Rodriguez', 'Veterinario', 50000.00, '2014-05-10'),\r\n"
						+ "(4, 'Ana Gómez', 'Cuidador', 28000.00, '2015-11-28'),\r\n"
						+ "(5, 'Pedro Martinez', 'Guía Turístico', 35000.00, '2018-02-14'),\r\n"
						+ "(6, 'Laura Sanchez', 'Cocinero', 32000.00, '2019-09-30'),\r\n"
						+ "(7, 'Roberto Castro', 'Limpiador', 25000.00, '2011-07-17'),\r\n"
						+ "(8, 'Elena Ramírez', 'Administrador', 55000.00, '2013-04-12'),\r\n"
						+ "(9, 'Javier González', 'Entrenador', 40000.00, '2016-06-08'),\r\n"
						+ "(10, 'Sofía Herrera', 'Contador', 48000.00, '2020-01-25');\r\n"
						+ "";
				statement.executeUpdate( sent );
				
				sent = "INSERT INTO Visitantes (id_visitante, nombre, edad, fecha_visita) VALUES\r\n"
						+ "(1, 'Familia López', 35, '2023-01-05'),\r\n"
						+ "(2, 'Juan Martínez', 25, '2023-02-12'),\r\n"
						+ "(3, 'María Sánchez', 28, '2023-03-20'),\r\n"
						+ "(4, 'Pedro Ramírez', 40, '2023-04-08'),\r\n"
						+ "(5, 'Laura Hernández', 22, '2023-05-15'),\r\n"
						+ "(6, 'Carlos Rodríguez', 50, '2023-06-23'),\r\n"
						+ "(7, 'Ana Gómez', 30, '2023-07-10'),\r\n"
						+ "(8, 'Roberto Castro', 45, '2023-08-18'),\r\n"
						+ "(9, 'Elena Ramírez', 55, '2023-09-25'),\r\n"
						+ "(10, 'Javier González', 38, '2023-10-30');\r\n"
						+ "";
				statement.executeUpdate( sent );
				
				sent = "INSERT INTO Exhibiciones (id_exhibicion, nombre, descripcion, id_animal) VALUES\r\n"
						+ "(1, 'Show de Leones', 'Increíble espectáculo de leones en acción.', 1),\r\n"
						+ "(2, 'Hábitat del Tigre', 'Observa a los tigres en su entorno natural.', 2),\r\n"
						+ "(3, 'Delfinario', 'Disfruta de acrobacias y saltos de delfines.', 3),\r\n"
						+ "(4, 'Encuentro Polar', 'Observa a los osos polares nadar y jugar.', 4),\r\n"
						+ "(5, 'Safari de Elefantes', 'Recorre la sabana y conoce a los elefantes.', 5),\r\n"
						+ "(6, 'Mundo Marino', 'Explora la vida marina y conoce a los pingüinos.', 6),\r\n"
						+ "(7, 'Cuello de Jirafa', 'Aprende sobre las jirafas y su cuello largo.', 7),\r\n"
						+ "(8, 'Tortugas en Acción', 'Descubre la vida de las tortugas marinas.', 8),\r\n"
						+ "(9, 'Selva de Monos', 'Observa a los monos jugando y interactuando.', 9),\r\n"
						+ "(10, 'Rincon del Lince', 'Conoce al lince ibérico en su hábitat natural.', 10);\r\n"
						+ "";
				statement.executeUpdate( sent );
				
				logger.log(Level.INFO, "Valores introducidos correctamente");
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Error en la introducción de datos a las tablas, ya estaban anteriormente creadas");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.log(Level.SEVERE, "Error en la creación e inserción de datos de la BD");
		}
		return conexion;
	}
	
	
	
	// Ya una vez que hayamos realizado las operaciones cerramos la conexión
	public static void cerramosConexion() {
		try {
			conexion.close();
			logger.log(Level.INFO, "Conexión a BD cerrada correctamente");
		}catch (SQLException e) {
			logger.log(Level.WARNING, "No se ha podido cerrar correctamente la conexión a la BD");
		}
	}
}