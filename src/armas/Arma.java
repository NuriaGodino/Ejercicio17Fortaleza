package armas;

public abstract class Arma {
	
	private int da�oMax;

	public int getDa�oMax() {
		return da�oMax;
	}

	public void setDa�oMax(int da�oMax) {
		this.da�oMax = da�oMax;
	}
	
	public int da�oReal() {
		return (int) (getDa�oMax() + Math.random());
	}
}
