package unidades;


import EnumsAndEstandar.ValoresEstandar;
import interfaces.IDispararProyectil;
import interfaces.IMovimientoX;
import views.BateriaView;

/**
 * 
 */
public class Bateria extends FisicaObjeto implements IMovimientoX, IDispararProyectil {

    private int direccionX;
    
    private String imagen = "src/imagenes/BateriaRed.png";
    
        
    public Bateria(int direccionX) {
    	super(ValoresEstandar.PLAYER_LARGO, ValoresEstandar.PLAYER_ALTO, ValoresEstandar.PLAYER_X, ValoresEstandar.PLAYER_Y);
		this.direccionX = direccionX;
	}
    
    public String getImagen() {
		return this.imagen;
	}
    
    public void setDireccionX(int direccion) {
    	this.direccionX = direccion;
    }
    
    public BateriaView bateriaToView() {
    	return new BateriaView(this.toView(), this.imagen);
    }
	
    
	@Override
	public void moveX() {
		double nuevaPosicionX = this.getPosicionX() + (ValoresEstandar.MOVIMIENTO_GENERAL_X * this.direccionX);
		this.posicionX = nuevaPosicionX;
	}

	//Habria que controlar si el disparo deberia salir un poco mas arriba que la bateria
	@Override
	public Proyectil dispararProyectil() {
		int posicionY = ValoresEstandar.VALOR_ESTANDAR_SALIDA_PROYECTIL_Y;
		return new Proyectil(this.getPosicionX(), posicionY, (-1), "Bateria");
	}
}