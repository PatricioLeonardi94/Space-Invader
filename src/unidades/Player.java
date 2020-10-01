package unidades;

import EnumsAndEstandar.ValoresEstandar;
import views.PlayerView;

/**
 * 
 */
public class Player {

    private String nombre;
    private int puntaje;
    private int vidas;
    private Bateria bateria;
   
    
    
    public Player(String nombre) {
		this.nombre = nombre;
		this.puntaje = ValoresEstandar.PLAYER_PUNTAJE_INICIAL;
		this.vidas = ValoresEstandar.PLAYER_VIDAS_INICIALES;
		this.bateria = new Bateria(ValoresEstandar.PLAYER_DIRECCION_X);
	}

	
    public String getNombre() {
       return this.nombre;
    }
    
    public int getPuntaje() {
    	return this.puntaje;
    }

    public int getVidas() {
       return this.vidas;
    }
    
    public Bateria getBateria() {
        return this.bateria;
      }

    public void setVidas(int newVidas) {
       this.vidas = newVidas;
    }
    
    public void setPuntaje(int puntaje) {
    	this.puntaje = puntaje;
    }
    
    public PlayerView playerToView() {
    	return new PlayerView(this.nombre, this.puntaje, this.vidas, this.bateria.bateriaToView());
    }

}