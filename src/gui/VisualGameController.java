package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import EnumsAndEstandar.Estado;
import EnumsAndEstandar.ValoresEstandar;
import common.Controlador;
import common.Tablero;
import views.TableroView;


public class VisualGameController{
	
	private Timer checkAll;
	private Timer moverNaves;
	private Timer moverProyectiles;
	private Timer dispararProyectiles;
		
	private List<Timer> timers = new ArrayList<Timer>();
	
	TableroView tableroView;
	
	VisualGame visualGame;
	
	private int velocidad;
	
	public VisualGameController(TableroView tableroView) {	
		this.tableroView = tableroView;
		this.velocidad = ValoresEstandar.VELOCIDAD_ESTANDAR;		
		this.visualGame = new VisualGame(tableroView);
		
		eventos();
	}
	
	
	private void eventos() {

    	this.visualGame.addKeyListener(new KeyListener() {
			
			
			@Override
	        public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();   
				
		        if(key==39) {
		        	if(tableroView.getPlayer().getBateria().getPosicionX() + tableroView.getPlayer().getBateria().getLargo() < tableroView.getLargo() - ValoresEstandar.MOVIMIENTO_GENERAL_X) {
		        		Controlador.getInstance().setDireccionBateria(1);
		        		Controlador.getInstance().moverBateria();
		        	}	        	
		        }else if(key == 37) {
		        	if(tableroView.getPlayer().getBateria().getPosicionX() > 0 + ValoresEstandar.MOVIMIENTO_GENERAL_X) {
		        		Controlador.getInstance().setDireccionBateria(-1);
		        		Controlador.getInstance().moverBateria();
		        	}	
		        }else if(key  ==32) {
		        	Controlador.getInstance().dispararProyectil();
		        }else if(key == 27) {
		        	terminado();	        	
		        }
		        
	        	
	        }
			
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }
	       
	        @Override
	        public void keyReleased(KeyEvent e) {
	        }
	    });
    	

    	
    	moverNaves = new Timer(velocidad, new MoverNaves());
    	moverNaves.start();
    	timers.add(moverNaves);
    	
    	moverProyectiles = new Timer(ValoresEstandar.VALOR_ESTANDAR_MOVIMIENTO_PROYECTILES, new MoverProyectiles());
    	moverProyectiles.start();
    	timers.add(moverProyectiles);
    	
    	dispararProyectiles = new Timer(ValoresEstandar.TIEMPO_ESTANDAR_DISPARO_INVASORES, new DisparoInvasores());
    	dispararProyectiles.start();
    	timers.add(dispararProyectiles);
    	
    	checkAll = new Timer(1, new RenewView());
    	checkAll.start();
    	timers.add(checkAll);
	}
	
	
	class RenewView implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			tableroView = Controlador.getInstance().getTableroView();
			Controlador.getInstance().corroborarEstadoNivel();
			
			visualGame.renewView(tableroView);
			
			
			if(Controlador.getInstance().corroborarEstadoNivel() == Estado.PERDER) {
				perder();
			}
			 
			if(Controlador.getInstance().corroborarEstadoNivel() == Estado.GANAR) {
				ganar();
			}
			
			if(Controlador.getInstance().corroborarEstadoNivel() == Estado.TERMINADO) {
				terminado();
			}
			
			if(tableroView.getEstado() == Estado.SUBIRNIVEL) {
				subirDificultad();	
				System.out.println("Velocidad: " + velocidad);
			}						
		}
	}
	
	
	 class MoverNaves implements ActionListener{
	        
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			moverNaves();		
		}
 		private void moverNaves() {
 			Controlador.getInstance().moverNavesInvasoras();
 		 }
	}
	 
	 class MoverProyectiles implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {			
				moverProyectiles();
			}
			
			private void moverProyectiles() {
				Controlador.getInstance().moverProyectiles();;
			 }
			 
	 }
	 
	 class DisparoInvasores implements ActionListener{
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				invasoresDispararProyectil();
			}
			
			private void invasoresDispararProyectil() {
				Controlador.getInstance().invasoresDispararProyectil();
			}
			
	 }
	 
	 private void stopTimers() {
		 this.timers.forEach(timer ->{
			 timer.stop();
		 });
	 }
	 
	 private void subirDificultad() {
		 this.moverNaves.stop();
		 
		 if(tableroView.getDificultad() == 2) {			 
			 this.velocidad = ValoresEstandar.VELOCIDAD_ESTANDAR /tableroView.getDificultad();				
		 }
		 if(tableroView.getDificultad() == 3) {
			 this.velocidad = ValoresEstandar.VELOCIDAD_ESTANDAR /tableroView.getDificultad();
		 }
		 
		 Timer moverNavesNew = new Timer(this.velocidad, new MoverNaves());
		 moverNavesNew.start();
	 }
	 
	 
	 
	 private void perder() {
		 stopTimers();
		 JOptionPane.showMessageDialog(new JFrame(), "Perdiste");
		 visualGame.dispose();
		 Controlador.getInstance().setPuntaje(this.tableroView.getPlayer().getPuntaje(), this.tableroView.getPlayer().getNombre());
		 new VisualMenu();
	 }
	 
	 private void ganar() {
		 stopTimers();
		 JOptionPane.showMessageDialog(new JFrame(), "GANASTE");
		 visualGame.dispose();
		 Controlador.getInstance().setPuntaje(this.tableroView.getPlayer().getPuntaje(), this.tableroView.getPlayer().getNombre());
		 new VisualMenu();
	 }
	 
	 private void terminado() {
		 stopTimers();
		 visualGame.dispose();
		 new VisualMenu();		 
	 }
	 
}
