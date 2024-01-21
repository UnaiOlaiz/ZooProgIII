package Ventanas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Zoo.Trabajador;
import Zoo.VisitanteAntiguo;
import Zoo.VisitanteAntiguo;

public class Zoo {
	private static List<VisitanteAntiguo> visitantes = new ArrayList<>();
	private static List<Trabajador> trabajadores = new ArrayList<>();
	
	public static void aniadirVisitante(VisitanteAntiguo v) {
		if(buscarVisitante(v.getDNI())==null)
			visitantes.add(v);
	}
	
	public static VisitanteAntiguo buscarVisitante(String dni) {
		boolean enc = false;
		int pos = 0;
		VisitanteAntiguo v = null;
		while(!enc && pos<visitantes.size()) {
			v = visitantes.get(pos);
			if(v.getDNI().equals(dni)) {
				enc = true;
			}else {
				pos++;
			}
		}
		if(enc) {
			return v;
		}else {
			return null;
		}
	}
	
	public static void aniadirTrabajador (Trabajador t) {
		if(buscarTrabajador(t.getDNI())==null)
			trabajadores.add(t);
	}
	
	public static Trabajador buscarTrabajador(String dni) {
		boolean enc = false;
		int pos = 0;
		Trabajador t = null;
		while(!enc && pos<trabajadores.size()) {
			t = trabajadores.get(pos);
			if(t.getDNI().equals(dni)) {
				enc = true;
			}else {
				pos++;
			}
		}
		if(enc) {
			return t;
		}else {
			return null;
		}
	}
	
	public static void cargarFicheroVisitantesEnLista(String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			//linea = dni;nom;fnac;con
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				System.out.println( "Línea: " + linea );
				String [] partes = linea.split(";");
				String dni = partes[0];
				String nom = partes[1];
				String con = partes[2];
				VisitanteAntiguo c = new VisitanteAntiguo(dni, nom, con);
				if(buscarVisitante(dni) == null)
					visitantes.add(c);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public static void guardarListaVisitantesEnFichero(String nomfich) {
		try {
			PrintWriter pw = new PrintWriter(nomfich);
			for(VisitanteAntiguo c: visitantes) {
				pw.println(c.getDNI()+";"+c.getNombre()+";"+c.getContrasenia());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarFicheroTrabajadoresEnLista(String nomfich) {
		try {
			Scanner sc = new Scanner(new FileReader(nomfich));
			//linea = dni;nom;fnac;con
			String linea;
			while(sc.hasNext()) {
				linea = sc.nextLine();
				System.out.println( "Línea: " + linea );
				String [] partes = linea.split(";");
				String dni = partes[0];
				String nom = partes[1];
				String con = partes[2]; 
				Trabajador t = new Trabajador(dni,nom, con);
				if(buscarTrabajador(dni) == null)
					trabajadores.add(t);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public static void guardarListaTrabajadoresEnFichero(String nomfich) {
		try {
			PrintWriter pw = new PrintWriter(nomfich);
//			for(Trabajador t: trabajadores) {
//				pw.println(t.getDNI()+";"+t.getNombre()+";"+t.getCon());
//			}
			
			
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block //
			System.err.println( "No se ha podido registrar el trabajador, compruebe la ubicación del fichero." );
			e.printStackTrace();
		}
	}
	
}