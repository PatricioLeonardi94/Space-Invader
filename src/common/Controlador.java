package common;


import java.util.*;

import EnumsAndEstandar.Estado;
import EnumsAndEstandar.ValoresEstandar;
import gui.VisualGameController;
import gui.VisualMenu;
import unidades.Player;
import views.TableroPuntajeView;
import views.TableroView;


public class Controlador {

	private Tablero tablero;
	
	private static Controlador controlador = null; 
	 
	private Controlador() {}    
	
	public static Controlador getInstance() 
    { 
        if (controlador == null) {
        	controlador = new Controlador(); 
        }
         
        return controlador; 
    } 
	   
    public TableroView iniciarJuego(String nombrePlayer) {
    	Player player = new Player(nombrePlayer);
    	this.tablero = new Tablero(player);
    	return this.tablero.tableroToView();
    }
    
    public void terminarJuego() {
    	this.tablero.terminarJuego();
    }
    
    public void moverBateria() {
    	this.tablero.moverBateria();;
    }
    
    public void setDireccionBateria(int direccion) {
    	this.tablero.setDireccionBateria(direccion);
    }
    
    public void dispararProyectil() {
    	this.tablero.playerDispararProyectil();;
    }
    
    public TableroView getTableroView() {
    	return this.tablero.tableroToView();
    }
    
    public void moverNavesInvasoras() {
    	this.tablero.moverNaves();
    }
    
    public void moverProyectiles() {
    	this.tablero.moverProyectiles();
    }
    
    public void invasoresDispararProyectil() {
    	this.tablero.invasoresDispararProyectil();
    }
    
    public Estado corroborarEstadoNivel() {
    	return this.tablero.corroborarEstadoNivel();
    }
    
    public TableroPuntajeView getPuntajes() {
    	return TableroPuntaje.getInstance().tableroPuntajeToView();
    }
    
    public void setPuntaje(Integer puntaje, String playerName) {
    	TableroPuntaje.getInstance().setPuntajesMaximos(puntaje, playerName);
    }
    

}