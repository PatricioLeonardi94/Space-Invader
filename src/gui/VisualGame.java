package gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import views.BateriaView;
import views.MuroEnergiaView;
import views.NaveInvasoraView;
import views.ProyectilView;
import views.TableroView;

public class VisualGame extends JFrame {
		
	private TableroView tableroView;
	private JLabel playerName;
	private JLabel playerLives;
	private JLabel plyerPuntaje;
	
	public VisualGame(TableroView tableroView) {
		this.tableroView =  tableroView;
		
		this.setSize(tableroView.getLargo(), tableroView.getAlto() + 50);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// si aprieto la x se cierra
		this.setLocationRelativeTo(null);
	 	this.getContentPane().setBackground(Color.BLACK);
		
		this.setLayout(null);	
		
		constructor();
		
		this.setVisible(true);
	}
	
	private void constructor() {
		tableroView.getMuros().forEach(muro ->{
			createImagen(muro);
		});
		tableroView.getInvasores().forEach(nave ->{
			createImagen(nave);
		});
		tableroView.getProyectiles().forEach(proyectil ->{
			createImagen(proyectil);
		});
		createImagen(tableroView.getPlayer().getBateria());		
		
		this.playerName = new JLabel();
		this.playerName.setText("Player: " + this.tableroView.getPlayer().getNombre());
		this.playerName.setBounds(200, tableroView.getAlto() - 50, 200, 50);
		this.add(playerName);
		
		this.playerLives = new JLabel();
		this.playerLives.setText("Cantidad de Vidas: " + this.tableroView.getPlayer().getVidas());
		this.playerLives.setBounds(600, tableroView.getAlto() - 50, 200, 50);
		this.add(playerLives);
		
		this.plyerPuntaje = new JLabel();
		this.plyerPuntaje.setText("Puntaje: " + this.tableroView.getPlayer().getPuntaje());
		this.plyerPuntaje.setBounds(400, tableroView.getAlto() - 50, 200, 50);
		this.add(plyerPuntaje);
		
		
	}
	
	private void createImagen(NaveInvasoraView nave){
    	BufferedImage img = new BufferedImage((int)nave.getLargo() ,(int)nave.getAlto(), BufferedImage.TYPE_INT_RGB);
    	try {
    		   	
    	    img = ImageIO.read(new File(nave.getImagen()));
    	    
    	    ImageIcon icon = new ImageIcon(img);
    	    
    	    JLabel aux = new JLabel(icon, JLabel.CENTER);
    	   
    	    aux.setBounds(nave.getPosicionX(), nave.getPosicionY(), nave.getLargo(), nave.getAlto());
    	    
    	    this.add(aux);
    	} catch (IOException e) {
    		System.out.println("Error en cargar imagen");
    		e.printStackTrace();
    	}
    }
    
    private void createImagen(MuroEnergiaView newMuro){
    	BufferedImage img = new BufferedImage((int)newMuro.getLargo() ,(int)newMuro.getAlto(), BufferedImage.TYPE_INT_RGB);
    	try {
    		
    		if(newMuro.getVida() >= 50) {
    			img = ImageIO.read(new File(newMuro.getImagenMuroCompleto()));
    		}else {
    			img = ImageIO.read(new File(newMuro.getImagenMuroMedio()));
    		}
    	    
    	    
    	    ImageIcon icon = new ImageIcon(img);
    	       	    
    	    JLabel aux = new JLabel(icon, JLabel.CENTER);
    	  
    	    aux.setBounds(newMuro.getPosicionX(), newMuro.getPosicionY(), newMuro.getLargo(), newMuro.getAlto());
    	    
    	    this.add(aux);
    	} catch (IOException e) {
    		System.out.println("Error en cargar imagen");
    		e.printStackTrace();
    	}
    	
    }
    
    private void createImagen(BateriaView bateria){
    	BufferedImage img = new BufferedImage((int)bateria.getLargo() ,(int)bateria.getAlto(), BufferedImage.TYPE_INT_RGB);
    	try {
    		   	
    	    img = ImageIO.read(new File(bateria.getImagen()));
    	    
    	    ImageIcon icon = new ImageIcon(img);
    	    
    	    JLabel aux = new JLabel(icon, JLabel.CENTER);
    	    
    	    aux.setBounds(bateria.getPosicionX(), bateria.getPosicionY(), bateria.getLargo(), bateria.getAlto());
    	    
    	    this.add(aux);
    	} catch (IOException e) {
    		System.out.println("Error en cargar imagen");
    		e.printStackTrace();
    	}
    	
    }
    
    private void createImagen(ProyectilView proyectil) {
    	BufferedImage img = new BufferedImage(proyectil.getLargo() ,proyectil.getAlto(), BufferedImage.TYPE_INT_RGB);
    	try {
    		
    		if(proyectil.getPropietario() == "NaveInvasora") {
    			img = ImageIO.read(new File(proyectil.getImagenProyectilInvasor()));
    		}
    		if(proyectil.getPropietario() == "Bateria") {
    			img = ImageIO.read(new File(proyectil.getImagenProyectilPlayer()));
    		}
    	       	    
    		ImageIcon icon = new ImageIcon(img);
    	    
    	    JLabel aux = new JLabel(icon, JLabel.CENTER);
    	    
    	    aux.setBounds((int)proyectil.getPosicionX(), (int)proyectil.getPosicionY(), (int)proyectil.getLargo(), (int)proyectil.getAlto());
    	    
    	    this.add(aux);
    	    
    	} catch (IOException e) {
    		System.out.println("Error en cargar imagen");
    		e.printStackTrace();
    	}
    }
   
    public void renewView(TableroView tableroView) {
		this.getContentPane().removeAll();
		this.repaint();
    	this.tableroView = tableroView;
    	constructor();
    	
    }
}
