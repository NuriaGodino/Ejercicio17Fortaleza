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
		int da�o = this.getArma().da�oReal();
		System.out.println(this.getNombre() + " ha atacado a " + p.getNombre());
		if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			if(p.esquivar() == 0) {
				System.out.println("��Que pena!! "+p.getNombre() + " ha esquivado");
			}else {
				if(esCritico()) {
					da�o += fuerza + 20;
					p.setSalud(p.getSalud() - da�o);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					da�o += fuerza;
					p.setSalud(p.getSalud() - da�o);
					System.out.println("El ataque ha dado de pleno" + " a " + p.getNombre() + " le queda " + p.getSalud());
				}
			}
		} else {
			if(p.esquivar() == 0) {
				System.out.println("��Que pena!! "+p.getNombre() + " a esquivado");
			}else {
				if(esCritico()) {
					da�o += 20;
					p.setSalud(p.getSalud() - da�o);
					System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
				}else {
					da�o += 0;
					p.setSalud(p.getSalud() - da�o);
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
