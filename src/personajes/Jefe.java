package personajes;

public class Jefe extends Personaje{
	
	private Integer maldad = 10;

	public Integer getMaldad() {
		return maldad;
	}

	public void setMaldad(Integer maldad) {
		this.maldad = maldad;
	}

	@Override
	public void atacar(Personaje p) {
		int da�o = this.getArma().da�oReal();
		System.out.println(this.getNombre() + " ha atacado a " + p.getNombre());
		if(p.esquivar() == 0) {
			System.out.println("��Que pena!! "+ p.getNombre() + " ha esquivado");
		}else {
			if(esCritico()) {
				da�o += maldad + 30;
				p.setSalud(p.getSalud() - da�o);
				System.out.println(this.getNombre() + " ha dado un golpe critico " + p.getNombre() + " le queda " + p.getSalud());
			}else {
				da�o += maldad;
				p.setSalud(p.getSalud() - da�o);
				System.out.println("El ataque ha dado de pleno" + " a " + p.getNombre() + " le queda " + p.getSalud());
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
