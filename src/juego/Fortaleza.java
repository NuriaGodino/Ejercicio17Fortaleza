package juego;

import personajes.Jefe;
import personajes.Personaje;

public class Fortaleza {
	
	private String nombre;
	private Personaje jefe;
	
	public Fortaleza(String nombre, Personaje jefe) {
		super();
		this.nombre = nombre;
		this.jefe = jefe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Personaje getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}
	
	public synchronized void entrar(Personaje p) {
		if(jefe.getSalud() > 0) {
			if(p.getSalud() > 0) {
				new test().combate(p, jefe); //Para que ataque el heroe antes
			}else {
				System.out.println("El heroe ha muerto");
			}
		}else {
			System.out.println("El jefe ha muerto, no es necesaria la lucha");
		}
	}
	
	
}
