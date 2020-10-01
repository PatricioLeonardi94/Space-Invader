package views;

public class ProyectilView {

	private String imagenProyectilInvasor;
	private String imagenProyectilPlayer;
	private FisicaObjetoView fisicaObjeto;
	private String propietario;
	
	public ProyectilView() { }
	
	public ProyectilView(FisicaObjetoView fisicaObjetoView, String imagenProyectilInvasor, String imagenProyectilPlayer, String propietario) {
		this.fisicaObjeto = fisicaObjetoView;
		this.imagenProyectilInvasor =  imagenProyectilInvasor;
		this.imagenProyectilPlayer =  imagenProyectilPlayer;
		this.propietario = propietario;
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
	
	public String getImagenProyectilInvasor() {
		return this.imagenProyectilInvasor;
	}
	
	public String getImagenProyectilPlayer() {
		return this.imagenProyectilPlayer;
	}

	public String getPropietario() {
		return propietario;
	}
	
	
}
