package views;

public class FisicaObjetoView {
	private int largo;
	private int alto;
	private int posicionX;
	private int posicionY;
	
	public FisicaObjetoView() {}

	public FisicaObjetoView(int largo, int alto, int posicionX, int posicionY) {
		super();
		this.largo = largo;
		this.alto = alto;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	public int getLargo() {
		return largo;
	}

	public int getAlto() {
		return alto;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	
	
}
