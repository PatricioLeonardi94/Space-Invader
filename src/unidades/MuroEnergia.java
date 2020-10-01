package unidades;

import EnumsAndEstandar.ValoresEstandar;
import views.MuroEnergiaView;

/**
 * 
 */
public class MuroEnergia extends FisicaObjeto {
	
	private String imagen = "src/imagenes/MuroEnergia.png";
	private String imagen2 = "src/imagenes/MuroEnergia2.png";
	
    private int vida;

    public MuroEnergia(double posicionX, double posicionY) {
		super(ValoresEstandar.MUROENERGIA_LARGO, ValoresEstandar.MUROENERGIA_ALTO, posicionX, posicionY);
		this.vida =  ValoresEstandar.MUROENERGIA_VIDA;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public String getImagen() {
		return this.imagen;
	}
	
	public MuroEnergiaView muroToView() {
		return new MuroEnergiaView(this.toView(), this.imagen, this.imagen2, this.vida);
	}
	
}