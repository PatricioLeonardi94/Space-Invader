package views;

public class MuroEnergiaView {

	private String imagen1;
	private String imagen2;
	private FisicaObjetoView fisicaObjeto;
	private int vida;
	
	public MuroEnergiaView() { }
	
	public MuroEnergiaView(FisicaObjetoView fisicaObjetoView, String imagen1, String imagen2, int vida) {
		this.fisicaObjeto = fisicaObjetoView;
		this.imagen1 =  imagen1;
		this.imagen2 = imagen2;
		this.vida = vida;
	}
	
	public int getLargo() {
		return this.fisicaObjeto.getLargo();
	}
	
	public int getAlto() {
		return this.fisicaObjeto.getAlto();
	}
	
	public int getPosicionX() {
		return this.fisicaObjeto.getPosicionX();
	}
	
	public int getPosicionY() {
		return this.fisicaObjeto.getPosicionY();
	}
	
	public String getImagenMuroCompleto() {
		return this.imagen1;
	}
	public String getImagenMuroMedio() {
		return this.imagen2;
	}
	
	public int getVida() {
		return this.vida;
	}
}
