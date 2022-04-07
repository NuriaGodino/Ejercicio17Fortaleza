package personajes;

import armas.Rezos;

public class Curandero extends Personaje {

	private int sabiduria = 10;

	@Override
	public void atacar(Personaje p) {
		int daño = this.getArma().dañoReal();
		System.out.println(this.getNombre() + " ha atacado a " + p.getNombre());
		if (this.getArma() instanceof Rezos) {
			if(p.esquivar() == 0) {
				System.out.println("¡¡Que pena!! "+p.getNombre() + " ha esquivado");
			}else {
				if(esCritico()) {
					daño += sabiduria + 20;
					p.setSalud(p.getSalud() - daño);
					System.out.println(this.getNombre() + " ha dado un golpe critico" + p.getNombre() + " le queda " + p.getSalud());
				}else {
					daño += sabiduria;
					p.setSalud(p.getSalud() - daño);
					System.out.println("El ataque ha dado de pleno" + " a " + p.getNombre() + " le queda " + p.getSalud());
				}
			}
			
		} else {
			if(p.esquivar() == 0) {
				System.out.println("¡¡Que pena!! "+p.getNombre() + " ha esquivado");
			}else {
				if(esCritico()) {
					daño += 20;
					p.setSalud(p.getSalud() - daño);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					daño += daño + 0;
					p.setSalud(p.getSalud() - daño);
					System.out.println("El ataque ha dado de pleno " + "a " + p.getNombre() + " le queda " + p.getSalud());
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
