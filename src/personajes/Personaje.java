package personajes;

import armas.Arma;
import juego.Fortaleza;

public abstract class Personaje implements Runnable{
	
	private String nombre;
	private Arma arma;
	private Integer salud = 100;
	private Fortaleza fortaleza;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Fortaleza getFortaleza() {
		return fortaleza;
	}

	public void setFortaleza(Fortaleza fortaleza) {
		this.fortaleza = fortaleza;
	}

	public Integer getSalud() {
		return salud;
	}

	public void setSalud(Integer salud) {
		if(this.getSalud() > 0) {
			this.salud = salud;
		}else {
			this.salud = 0;
		}
		
	}
	
	public abstract void atacar(Personaje p);
	public abstract boolean esCritico();
	
	public int esquivar() {
		int random = (int) (Math.random()*2); //genera numero aleatorio entre 0 y el 1
		return random;
	}
	
	public void run() {
		fortaleza.entrar(this);
	}
	
}
