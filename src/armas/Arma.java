package armas;

public abstract class Arma {
	
	private int dañoMax;

	public int getDañoMax() {
		return dañoMax;
	}

	public void setDañoMax(int dañoMax) {
		this.dañoMax = dañoMax;
	}
	
	public int dañoReal() {
		return (int) (getDañoMax() + Math.random());
	}
}
