package unidades;

import views.FisicaObjetoView;

/**
 * 
 */
public abstract class FisicaObjeto {

	
    public FisicaObjeto(double largo, double alto, double posicionX, double posicionY) {
		this.largo = largo;
		this.alto = alto;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	/**
     * 
     */
    protected double largo;

    /**
     * 
     */
    protected double alto;

    /**
     * 
     */
    protected double posicionX;


    protected double posicionY;
    

	public double getLargo() {
		return largo;
	}

	public double getAlto() {
		return alto;
	}

	public double getPosicionX() {
		return posicionX;
	}

	public double getPosicionY() {
		return posicionY;
	}  
	
	public FisicaObjetoView toView() {
		return new FisicaObjetoView((int)this.largo, (int)this.alto, (int)this.posicionX, (int)this.posicionY);
	}
	
		
}