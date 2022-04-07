package personajes;

import armas.Hechizos;


public class Mago extends Personaje {

	private int inteligencia = 10;

	@Override
	public void atacar(Personaje p) {
		int daño = this.getArma().dañoReal();
		System.out.println(this.getNombre() + " ha atacado a " + p.getNombre());
		if (this.getArma() instanceof Hechizos) {
			if(p.esquivar() == 0) {
				System.out.println("¡¡Que pena!! "+p.getNombre() + " a esquivado");
			}else {
				if(esCritico()) {
					daño += inteligencia + 20;
					p.setSalud(p.getSalud() - daño);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					daño += inteligencia;
					p.setSalud(p.getSalud() - daño);
					System.out.println("El ataque ha dado de pleno" + " a " + p.getNombre() + " le queda " + p.getSalud());
				}
			}
			
		} else {
			if(p.esquivar() == 0) {
				System.out.println("¡¡Que pena!! "+p.getNombre() + " a esquivado");
			}else {
				if(esCritico()) {
					daño += 20;
					p.setSalud(p.getSalud() - daño);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					daño += 0;
					p.setSalud(p.getSalud() - daño);
					System.out.println("El ataque ha dado de pleno" + " a " + p.getNombre() + " le queda " + p.getSalud());
				}	
			}	
		}
	}

	@Override
	public boolean esCritico() {
		int num = (int) (Math.random()*5);
		if(num == 0) { //Que sea critico es lo menos probable
			return true;
		}else {
			return false;
		}
	}

}
