package unidades;


import EnumsAndEstandar.ValoresEstandar;
import interfaces.IMovimientoY;
import interfaces.Impacto;
import views.ProyectilView;

public class Proyectil extends FisicaObjeto implements Impacto, IMovimientoY {

	private String imagenProyectilPlayer = "src/imagenes/Proyectil.png";
	private String imagenProyectilInvasor = "src/imagenes/ProyectilInvasor.png";
		
    private int direccionY;

    private String propietario;

    public Proyectil(double posicionX, double posicionY, int direccionY, String propietario) {
		super(ValoresEstandar.PROYECTIL_LARGO, ValoresEstandar.PROYECTIL_ALTO, posicionX, posicionY);
		this.direccionY = direccionY;
		this.propietario = propietario;
    }
    
    
    public String getPropietario() {
        return this.propietario;
    }
    
    public String getImagenPlayer() {
    	return this.imagenProyectilPlayer;
    }
    
    public String getImagenInvasor() {
    	return this.imagenProyectilInvasor;
    }
    
    public ProyectilView proyectilToView() {
    	return new ProyectilView(this.toView(), this.imagenProyectilInvasor, this.imagenProyectilPlayer, this.propietario);
    }
    

	@Override
	public void moveY() {
		this.posicionY = this.getPosicionY() + (ValoresEstandar.MOVIMIENTO_GENERAL_Y * this.direccionY);
	}


   
    public boolean proyectilHitNave(NaveInvasora nave) {
    	if( (this.getPosicionX() >= nave.getPosicionX()) &&
    			(this.getPosicionX() <= (nave.getPosicionX() + nave.getLargo())) &&
    			(this.getPosicionY() >= nave.getPosicionY()) &&
    			(this.getPosicionY() <= (nave.getPosicionY() + nave.getAlto()))) 
    		{
    			return true;
    		}else {
    			return false;
    		}
    }

    /**
     * @param Player 
     * @return
     */
    public boolean proyectilHitPlayer(Bateria bateria) {
    	if( (this.getPosicionX() >= bateria.getPosicionX()) &&
    			(this.getPosicionX() <= (bateria.getPosicionX() + bateria.getLargo())) &&
    			(this.getPosicionY() >= bateria.getPosicionY()) &&
    			(this.getPosicionY() <= (bateria.getPosicionY() + bateria.getAlto()))) 
    		{
    			return true;
    		}else {
    			return false;
    		}
    }

    /**
     * @param MuroEnergia 
     * @return
     */
    public boolean proyectilHitMuroEnergia(MuroEnergia muro) {
    	if( (this.getPosicionX() >= muro.getPosicionX()) &&
    			(this.getPosicionX() <= (muro.getPosicionX() + muro.getLargo())) &&
    			(this.getPosicionY() >= muro.getPosicionY()) &&
    			(this.getPosicionY() <= (muro.getPosicionY() + muro.getAlto()))) 
    		{
    			return true;
    		}else {
    			return false;
    		}
    }

}