
package unidades;

import EnumsAndEstandar.ValoresEstandar;
import interfaces.IDispararProyectil;
import interfaces.IMovimientoX;
import interfaces.IMovimientoY;
import views.NaveInvasoraView;

/**
 * 
 */
public class NaveInvasora extends FisicaObjeto implements IMovimientoX, IMovimientoY, IDispararProyectil{

	private String imagen = "src/imagenes/naveInvasora.png";
	
    private int direccionX;
    
    private int direccionY;

    public NaveInvasora(double posicionX, double posicionY) {
		super(ValoresEstandar.NAVEINVASORA_LARGO, ValoresEstandar.NAVEINVASORA_ALTO, posicionX, posicionY);
		this.direccionX = 1;
		this.direccionY = 1;
	}


	public int getDireccionX() {
		return direccionX;
	}


	public int getDireccionY() {
		return direccionY;
	}

	public String getImagen() {
		return this.imagen;
	}
	

	public void setDireccionX(int direccionX) {
		this.direccionX = direccionX;
	}
	
	public NaveInvasoraView naveToView() {
		return new NaveInvasoraView(this.toView(), this.imagen);
	}

	@Override
	public void moveX() {
		double nuevaPosicionX = this.getPosicionX() + (ValoresEstandar.MOVIMIENTO_GENERAL_X * this.direccionX);
		this.posicionX = nuevaPosicionX;
	}   

	@Override
	public void moveY() {
		double nuevaPosicionY = this.getPosicionY() + (ValoresEstandar.MOVIMIENTO_GENERAL_Y * this.getDireccionY());
		this.posicionY = nuevaPosicionY;
	}

	@Override
	public Proyectil dispararProyectil() {
		return new Proyectil(this.posicionX, this.posicionY, this.direccionY, "NaveInvasora");
	}

}