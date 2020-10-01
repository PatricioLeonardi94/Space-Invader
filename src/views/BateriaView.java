package views;

public class BateriaView {
		
	
	private String imagen;
	private FisicaObjetoView fisicaObjeto;
	
	public BateriaView() { }
	
	public BateriaView(FisicaObjetoView fisicaObjetoView, String imagen) {
		this.fisicaObjeto = fisicaObjetoView;
		this.imagen =  imagen;
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
	
	public String getImagen() {
		return this.imagen;
	}
	
}
