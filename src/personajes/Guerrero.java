package personajes;

import armas.Arco;
import armas.Espada;

public class Guerrero extends Personaje{
	
	private Integer fuerza = 10;

	public Integer getFuerza() {
		return fuerza;
	}

	public void setFuerza(Integer fuerza) {
		this.fuerza = fuerza;
	}
	
	@Override
	public void atacar(Personaje p) {
		int daño = this.getArma().dañoReal();
		System.out.println(this.getNombre() + " ha atacado a " + p.getNombre());
		if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			if(p.esquivar() == 0) {
				System.out.println("¡¡Que pena!! "+p.getNombre() + " ha esquivado");
			}else {
				if(esCritico()) {
					daño += fuerza + 20;
					p.setSalud(p.getSalud() - daño);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					daño += fuerza;
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
