package BaseDeDatos;

public class MainBD {

	public static void main(String[] args) {
		ConexionABaseDeDatos.abrirConexion();
		// VisualizarBD.visualizarEmpleados();
		// VisualizarBD.visualizarHabitats();
		// VisualizarBD.visualizarAnimales();
		// VisualizarBD.visualizarVisitantes();
//		 VisualizarBD.visualizarExhibiciones();
		ConexionABaseDeDatos.cerramosConexion();
	}
}