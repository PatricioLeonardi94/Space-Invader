package views;

import java.util.List;

import EnumsAndEstandar.Estado;


public class TableroView {
	
private Estado estado;
	
	private List<NaveInvasoraView> invasores;
	    
    private int cantidadFilas;

    private int cantidadNavesPorFila;
        
	private List<MuroEnergiaView> muros;
	
	private List<ProyectilView> proyectiles;
	
	private int largo;
	
	private int alto;
	
	private PlayerView player;
	
	private int dificultad;
	
	public TableroView() {}

	public TableroView(Estado estado, List<NaveInvasoraView> invasores, int cantidadFilas, int cantidadNavesPorFila,
			List<MuroEnergiaView> muros, List<ProyectilView> proyectiles, int largo, int alto, PlayerView player,
			int dificultad) {
		this.estado = estado;
		this.invasores = invasores;
		this.cantidadFilas = cantidadFilas;
		this.cantidadNavesPorFila = cantidadNavesPorFila;
		this.muros = muros;
		this.proyectiles = proyectiles;
		this.largo = largo;
		this.alto = alto;
		this.player = player;
		this.dificultad = dificultad;
	}

	public Estado getEstado() {
		return estado;
	}

	public List<NaveInvasoraView> getInvasores() {
		return invasores;
	}

	public int getCantidadFilas() {
		return cantidadFilas;
	}

	public int getCantidadNavesPorFila() {
		return cantidadNavesPorFila;
	}

	public List<MuroEnergiaView> getMuros() {
		return muros;
	}

	public List<ProyectilView> getProyectiles() {
		return proyectiles;
	}

	public int getLargo() {
		return largo;
	}

	public int getAlto() {
		return alto;
	}

	public PlayerView getPlayer() {
		return player;
	}

	public int getDificultad() {
		return dificultad;
	}
	
}
