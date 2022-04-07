package juego;

import java.util.ArrayList;
import java.util.List;

import armas.Arco;
import armas.Arma;
import armas.Espada;
import armas.Hechizos;
import armas.Rezos;
import personajes.Curandero;
import personajes.Jefe;
import personajes.Mago;
import personajes.Personaje;

public class test {

	public static void main(String[] args) {
		System.out.println("Bienvenidos al juego MARVEL RPG");
		
		List<Personaje> personajes = creacionPersonajes();
		
		Thread t1 = new Thread(personajes.get(1));
		Thread t2 = new Thread(personajes.get(2));
		Thread t3 = new Thread(personajes.get(3));
		
		t1.start();
		t2.start();
		t3.start();
	}

	private static List<Arma> creacionDeArmas() {
		List<Arma> armas = new ArrayList<Arma>();

		Arma a1 = new Espada();
		Arma a2 = new Rezos();
		Arma a3 = new Hechizos();
		Arma a4 = new Arco();
		Arma a5 = new Rezos();

		a1.setDañoMax(10);
		a2.setDañoMax(10);
		a3.setDañoMax(10);
		a4.setDañoMax(10);
		a5.setDañoMax(10);

		armas.add(a1);
		armas.add(a2);
		armas.add(a3);
		armas.add(a4);
		armas.add(a5);

		return armas;
	}

	private static List<Personaje> creacionPersonajes() {
		List<Personaje> personajes = new ArrayList<Personaje>();

		Personaje p1 = new Jefe();
		Fortaleza f = new Fortaleza("Titan", p1);
		Personaje p2 = new Curandero();
		Personaje p3 = new Mago();
		Personaje p4 = new Curandero();
		Personaje p5 = new Mago();

		p1.setArma(creacionDeArmas().get(0));
		p1.setNombre("Peter Parker");
		p1.setSalud(500);
		p1.setFortaleza(f);

		p2.setArma(creacionDeArmas().get(1));
		p2.setNombre("Viuda Negra");
		p2.setSalud(200);
		p2.setFortaleza(f);

		p3.setArma(creacionDeArmas().get(2));
		p3.setNombre("Capitan America");
		p3.setSalud(200);
		p3.setFortaleza(f);

		p4.setArma(creacionDeArmas().get(3));
		p4.setNombre("Iron Man");
		p4.setSalud(200);
		p4.setFortaleza(f);

		p5.setArma(creacionDeArmas().get(4));
		p5.setNombre("Dr Strange");
		p5.setSalud(200);
		p5.setFortaleza(f);

		personajes.add(p1);
		personajes.add(p2);
		personajes.add(p3);
		personajes.add(p4);
		personajes.add(p5);

		return personajes;
	}

	public void combate(Personaje p1, Personaje p2) {
		while (p1.getSalud() > 0 && p2.getSalud() > 0) {
			p1.atacar(p2);
			p2.atacar(p1);
		}

		if (p1.getSalud() <= 0) {
			System.out.println("El ganador ha sido " + p2.getNombre());
		} else if (p2.getSalud() <= 0) {
			System.out.println("El ganador ha sido " + p1.getNombre());
		}
	}
}
