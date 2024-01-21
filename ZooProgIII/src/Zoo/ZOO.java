package Zoo;

import java.util.ArrayList;

public class ZOO {


protected ArrayList<AnimalAntiguo> animales;

protected ArrayList<Trabajador> trabajadores;

protected ArrayList<VisitanteAntiguo> visitantes;

public ArrayList<AnimalAntiguo> getAnimales() {

	return animales;

}

public void setAnimales(ArrayList<AnimalAntiguo> animales) {

this.animales = animales;

}

public ArrayList<Trabajador> getTrabajadores() {

	return trabajadores;

}

public void setTrabajadores(ArrayList<Trabajador> trabajadores) {

	this.trabajadores = trabajadores;

}

public ArrayList<VisitanteAntiguo> getVisitantes() {
	// Por aquí vamos a empezar a crear unos visitantes:
	 VisitanteAntiguo visitante1 = new VisitanteAntiguo("Juan Perez", "123456789", 25, 3, "juan@gmail.com", "clave123");
	 visitantes.add(visitante1);
     VisitanteAntiguo visitante2 = new VisitanteAntiguo("Maria Gomez", "987654321", 30, 5, "maria@gmail.com", "pass456");
     visitantes.add(visitante2);
     VisitanteAntiguo visitante3 = new VisitanteAntiguo("Carlos Rodriguez", "555555555", 22, 1, "carlos@gmail.com", "qwerty");
     visitantes.add(visitante3);
     VisitanteAntiguo visitante4 = new VisitanteAntiguo("Ana Sanchez", "111122223", 28, 2, "ana@gmail.com", "abcd");
     visitantes.add(visitante4);
     VisitanteAntiguo visitante5 = new VisitanteAntiguo("Luis Torres", "999988887", 35, 4, "luis@gmail.com", "p@ssword");
     visitantes.add(visitante5);
     VisitanteAntiguo visitante6 = new VisitanteAntiguo("Laura Fernandez", "666677778", 31, 6, "laura@gmail.com", "securePass");
     visitantes.add(visitante6);
     VisitanteAntiguo visitante7 = new VisitanteAntiguo("Pedro Martinez", "444455556", 27, 7, "pedro@gmail.com", "peter123");
     visitantes.add(visitante7);
     VisitanteAntiguo visitante8 = new VisitanteAntiguo("Elena Castro", "888877776", 26, 8, "elena@gmail.com", "elenaPass");
     visitantes.add(visitante8);
     VisitanteAntiguo visitante9 = new VisitanteAntiguo("Diego Ramirez", "333322221", 29, 9, "diego@gmail.com", "diegoPass");
     visitantes.add(visitante9);
     VisitanteAntiguo visitante10 = new VisitanteAntiguo("Sofia Diaz", "777766665", 24, 10, "sofia@gmail.com", "sofiaPass");
     visitantes.add(visitante10);
	return visitantes;
}


public void setVisitantes(ArrayList<VisitanteAntiguo> visitantes) {

	this.visitantes = visitantes;

}

public ZOO(ArrayList<AnimalAntiguo> animales, ArrayList<Trabajador> trabajadores, ArrayList<VisitanteAntiguo> visitantes) {

	super();

	this.animales = animales;

	this.trabajadores = trabajadores;

	this.visitantes = visitantes;

}

public ZOO() {

	super();

	this.animales = new ArrayList<>();

	this.trabajadores = new ArrayList<>();

	this.visitantes = new ArrayList<>();

}



}
