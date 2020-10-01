package views;

public class PlayerView {
	

    private String nombre;
    private int puntaje;
    private int vidas;
    private BateriaView bateria;
    
    public PlayerView() {}
    
    public PlayerView(String nombre, int puntaje, int vidas, BateriaView bateria) {
    	this.nombre = nombre;
    	this.puntaje = puntaje;
    	this.vidas = vidas;
    	this.bateria = bateria;
    }

	public String getNombre() {
		return nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public int getVidas() {
		return vidas;
	}

	public BateriaView getBateria() {
		return bateria;
	}
    
}
