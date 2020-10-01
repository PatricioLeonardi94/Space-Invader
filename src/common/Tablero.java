package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import EnumsAndEstandar.Estado;
import EnumsAndEstandar.ValoresEstandar;
import unidades.Bateria;
import unidades.MuroEnergia;
import unidades.NaveInvasora;
import unidades.Player;
import unidades.Proyectil;
import views.MuroEnergiaView;
import views.NaveInvasoraView;
import views.PlayerView;
import views.ProyectilView;
import views.TableroView;


public class Tablero {
	
	private Estado estado;
	
	private List<NaveInvasora> invasores;
	    
    private int cantidadFilas;

    private int cantidadNavesPorFila;
        
	private List<MuroEnergia> muros;
	
	private List<Proyectil> proyectiles;
	
	private double largo;
	
	private double alto;
	
	private Player player;
	
	private int puntajeAuxiliar = 0;
	
	private int dificultad;
		
	public Tablero(Player player) {
		
		
    	this.cantidadNavesPorFila = ValoresEstandar.CANTIDAD_NAVEINVASORA_POR_FILA;
    	this.cantidadFilas = ValoresEstandar.CANTIDAD_FILAS;
    	
    	this.largo = ValoresEstandar.TABLERO_X;
		this.alto = ValoresEstandar.TABLERO_Y;	
		this.invasores = new ArrayList<NaveInvasora>();
		this.player = player;
		
		this.muros = new ArrayList<MuroEnergia>();
		
		this.proyectiles = new ArrayList<Proyectil>();
		
		this.dificultad = 1;
		this.estado = Estado.JUGANDO;
		
		configurar();
		
		
	}
	
	private void configurar() {	
		generarNavesInvasoras();
    	generarMurosDeEnergia();
    	
	}
	
	//Configuracion del entorno 
	
	
    private void generarNavesInvasoras(){
    	//Estamos generando de la base que el (0,0) de nuestro sistema al ser para algo visual se ubica en la parte superior-izquierda
    	double posicionNaveY = 0;
    	
		for(int i = 0; i < this.cantidadFilas; i++) {
			double posicionNaveX= 10;
			for(int j = 0; j < this.cantidadNavesPorFila; j++) {
				
				NaveInvasora newNave = new NaveInvasora(posicionNaveX, posicionNaveY);	
				this.invasores.add(newNave);
							
							
				posicionNaveX =  posicionNaveX + ValoresEstandar.NAVEINVASORA_LARGO + ValoresEstandar.CANTIDAD_DISTANCIA_ENTRE_NAVES;
			}
			posicionNaveY = posicionNaveY + ValoresEstandar.NAVEINVASORA_ALTO + ValoresEstandar.CANTIDAD_DISTANCIA_ENTRE_NAVES;
		}		
    }
    
    private void generarMurosDeEnergia() {    	
    	/*
    	 * Al multiplicar el largo del muro por la cantidad eso nos da un reflejo de la cantidad de espacio que van a ocupar los muros
    	 * despues se lo restamos al largo del tablero y lo divimos por la cantidad de troneras que queremos tener.
    	 */
    	double distanciaEntreMuros = (this.largo - (ValoresEstandar.MUROENERGIA_LARGO * ValoresEstandar.CANTIDAD_MUROENERGIA)) / ValoresEstandar.CANTIDAD_TRONERAS;
    	
    	for(int i = 100; i < this.largo; ) {
    		MuroEnergia newMuro = new MuroEnergia(i, ValoresEstandar.MUROENERGIA_Y);
    		this.muros.add(newMuro);
    		   		
    		i = (int) (i + ValoresEstandar.MUROENERGIA_LARGO + distanciaEntreMuros);
    	}
    		
    }
    
    
    //NavesInvasoras
    
    public void moverNaves() {
    	boolean flagForMovingY = checkLimitesParaNaves();   	  	
    	    	
    	if(flagForMovingY) {
    		this.invasores.forEach(nave ->{
     			nave.moveX();
     		});
    	}else if(flagForMovingY == false) {
    		this.invasores.forEach(nave ->{    			
     			nave.moveY();
     		});
    	}   	
    }
    
    public void invasoresDispararProyectil() {
    	Random rand = new Random();
    	int randomInvasor = rand.nextInt(this.invasores.size());

    	NaveInvasora naveRandom = this.invasores.get(randomInvasor);
    	
    	Proyectil proyectil =  naveRandom.dispararProyectil();
    	
    	this.proyectiles.add(proyectil);
    }
    
    
    //Proyectiles
    
    public void moverProyectiles() {
		this.proyectiles.forEach(proyectil ->{
			proyectil.moveY();
		});		
		corroborarProyectilesFueraDeLimites();
		corroborarImpactos();
	}

    private void corroborarImpactos() {
        for(int i=0; i < this.proyectiles.size(); i++) {
        	Proyectil auxProyectil = this.proyectiles.get(i);
        	if(auxProyectil.getPropietario() == "Bateria") {
        		checkProyectilFromBateria(auxProyectil);
        	}
        	if(auxProyectil.getPropietario() == "NaveInvasora") {
        		checkProyectilFromNave(auxProyectil);
        	}
        
        }
    }
       
    private void checkProyectilFromBateria(Proyectil proyectil) {
    	//Corrobora si el proyectil de la bateria golpea una naveInvasora o algun muro
    	int flag = 0;
    	for(int i=0; i< this.invasores.size(); i++) {
    		NaveInvasora auxNave = this.invasores.get(i);
    		if(proyectil.proyectilHitNave(auxNave)) {
    			
    			//Removemos la nave porque fue golpeada por el proyectil  			
    			this.invasores.remove(this.invasores.get(i));
    			this.proyectiles.remove(proyectil);
    			
    			//Sumamos los puntos del Player
    			this.player.setPuntaje(this.player.getPuntaje() + 10);   			
    			this.puntajeAuxiliar += 10;

    			if(puntajeAuxiliar >= 500) {
    				this.player.setVidas(this.player.getVidas() +1);
    				this.puntajeAuxiliar -= 500;
    			}
    			
    			flag = 1;
    		}
    	}
    	
    	if(flag == 0) {
    		
    		for(int i=0; i< this.muros.size(); i++) {
        		MuroEnergia auxMuro = this.muros.get(i);
        		if(proyectil.proyectilHitMuroEnergia(auxMuro)) {
        			
        			auxMuro.setVida(auxMuro.getVida() - 10);
        			this.proyectiles.remove(proyectil);
        			     			
        			if(auxMuro.getVida() <= 0) {
        				this.muros.remove(auxMuro);
        			}
        		}
        	}
    		
    	}
    }

    private void checkProyectilFromNave(Proyectil proyectil) {
    	int flag = 0;
    	for(int i=0; i< this.muros.size(); i++) {
    		MuroEnergia auxMuro = this.muros.get(i);
    		if(proyectil.proyectilHitMuroEnergia(auxMuro)) {
    			
    			auxMuro.setVida(auxMuro.getVida() - 5);
    			
    			if(auxMuro.getVida() <= 0) {
    				this.muros.remove(auxMuro);
    			}
    			this.proyectiles.remove(proyectil);
    			flag=1;
    		}
    	}
    	
    	if(flag == 0) {
    		
    		if(proyectil.proyectilHitPlayer(this.player.getBateria())){
    			
    			this.player.setVidas(this.player.getVidas()-1);
    			this.proyectiles.remove(proyectil);
    			resetTablero();
    		}
    		
    	}
    }
    
    //Player
      
    public void moverBateria() {
    	double posicionX = this.player.getBateria().getPosicionX();
    	if(posicionX > 0 && posicionX < this.largo) {  		
        	this.player.getBateria().moveX();
    	}
    }
    
    public void setDireccionBateria(int direccion) {
    	this.player.getBateria().setDireccionX(direccion);
    }
         
    public void playerDispararProyectil() {
    	Bateria auxBateria = this.player.getBateria();
		Proyectil proyectilPlayer = auxBateria.dispararProyectil();	
			
		this.proyectiles.add(proyectilPlayer);
	}
    
    //Methodos internos de control
   
    private void resetTablero() {
    	generarMurosDeEnergia();
    }
    
    private boolean checkLimitesParaNaves() {
    	for(int i =0; i< this.invasores.size(); i++) {
    		NaveInvasora auxNave = this.invasores.get(i);
    		double auxLimiteDerecha = auxNave.getPosicionX() + auxNave.getLargo() + (ValoresEstandar.MOVIMIENTO_GENERAL_X * auxNave.getDireccionX());
    		double auxLimiteIzquierda = auxNave.getPosicionX() + (ValoresEstandar.MOVIMIENTO_GENERAL_X * auxNave.getDireccionX());
    		
    		if(auxLimiteDerecha >= this.largo) {
    			this.invasores.forEach(nave -> nave.setDireccionX(-1));
    			return false;
    			
    		}else if(auxLimiteIzquierda <= 0) {
    			this.invasores.forEach(nave -> nave.setDireccionX(1));
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean checkLimitsForNavesY() {
    	for(int i =0; i< this.invasores.size(); i++) {
    		NaveInvasora auxNave = this.invasores.get(i);
    		
    		if(auxNave.getPosicionY() >= ValoresEstandar.VALOR_ESTANDAR_MAXIMO_PARA_NAVES_Y) {
    			return true;
    		}
    	} 	
    	return false;
    }
    
    private void corroborarProyectilesFueraDeLimites() {
    	for(int i=0; i < this.proyectiles.size(); i++) {
    		Proyectil auxProyectil = this.proyectiles.get(i);
    		if(auxProyectil.getPosicionY() >= this.largo || auxProyectil.getPosicionY() < 0) {
    			this.proyectiles.remove(i);
    		}
    	}
    }

    public Estado corroborarEstadoNivel() {
    	
    	if(this.invasores.size() == 0 && this.dificultad < 4) {
    		this.dificultad += 1;
    		this.player.setPuntaje(this.player.getPuntaje() + 200); 
    		this.puntajeAuxiliar += 200;
    		
        	generarNavesInvasoras(); 
        	return Estado.SUBIRNIVEL;
    	}
    	
    	if(this.invasores.size() == 0 && this.dificultad == 4) {
    		this.estado =  Estado.GANAR;
    		return Estado.GANAR;
    	}
    	
    	if(this.player.getVidas() == 0 || checkLimitsForNavesY()) {
    		this.estado = Estado.PERDER;
    		return Estado.PERDER;
    	}
		return Estado.JUGANDO;
    }
     
    public void terminarJuego() {
		this.estado = Estado.TERMINADO;		
	}
   
    //To View
    
    private List<NaveInvasoraView> ListNavesToView(){
    	List<NaveInvasoraView> auxList = new ArrayList<>();
    	for(NaveInvasora auxNave: this.invasores) {
    		auxList.add(auxNave.naveToView());
    	}
    	return auxList;
    }
    
    private List<MuroEnergiaView> ListMurosToView(){
    	List<MuroEnergiaView> auxList = new ArrayList<>();
    	for(MuroEnergia muro: this.muros) {
    		auxList.add(muro.muroToView());
    	}
    	return auxList;
    }
    
    private List<ProyectilView> ListProyectilesToView(){
    	List<ProyectilView> auxList = new ArrayList<>();
    	for(Proyectil auxProyectil: this.proyectiles) {
    		auxList.add(auxProyectil.proyectilToView());
    	}
    	return auxList;
    }

    
    public TableroView tableroToView() {

    	return new TableroView(this.estado, ListNavesToView(), this.cantidadFilas, this.cantidadNavesPorFila, ListMurosToView(), ListProyectilesToView(),
    			(int)this.largo, (int)this.alto, this.player.playerToView(), this.dificultad);
    }
    
	
	
}
