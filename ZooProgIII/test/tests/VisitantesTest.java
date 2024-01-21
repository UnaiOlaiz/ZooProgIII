package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ventanas.VentanaPrincipal;
import Zoo.VisitanteAntiguo;
import Zoo.ZOO;

class VisitantesTest {

	private ZOO main;
	private ArrayList<VisitanteAntiguo> visitantes = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		main = new ZOO();
		visitantes = main.getVisitantes();
	}
	
	@Test
	// En este apartado testearemos características relacionadas con los visitantes
	public void testAforo() {
		assertEquals( 10, visitantes.size() ); // Comprobar si la cantidad de visitantes del día supera las 10 personas
	}
	
	@Test
	// Aquí veremos si la persona Juan Pérez con DNI 123456789 acudió al zoo este día o no
	public void testVisitante1() {
		VisitanteAntiguo visitante1 = visitantes.get(0);
		assertEquals( "Juan Perez", visitante1.getNombre() );
		assertEquals( "123456789", visitante1.getDNI() );
	}
	
	@Test 
	// En este apartado añadiremos un nuevo visitante y veremos si luego éste está incluido en la lista de visitantes
	public void nuevoVisitante() {
		VisitanteAntiguo visitante = new VisitanteAntiguo("Antoine Griezmann", "73238011T", 32, 0, "antxon@gmail.com", "agote" );
		visitantes.add(visitante);
		assertTrue(visitantes.contains(visitante));
	}
	
	@Test
	// Eliminaremos un visitante
	public void eliminarVisitante() {
		VisitanteAntiguo visitante = visitantes.get(3);
		visitantes.remove(visitante);
		assertFalse(visitantes.contains(visitante));
	}
	
	@Test
	// Aquí veremos si alguno de los visitantes de hoy se encuentra en edad avanzada
	public void hayPersonaMayor() {
		for (VisitanteAntiguo visitante : visitantes) {
			int edad = visitante.getEdad();
			assertFalse( edad > 65 );
		}
	}
	
}	