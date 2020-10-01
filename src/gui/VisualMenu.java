package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import EnumsAndEstandar.ValoresEstandar;
import common.Controlador;
import common.Tablero;
import unidades.Player;
import views.TableroView;

public class VisualMenu extends JFrame{

	private JLabel spaceinvader;
	private JLabel addPlayerName;
	private JTextField playerName;
	private String playerNameString;
	private JButton inicarJuego;
	private JButton puntajeMaximo;

	public VisualMenu(){
		
		this.setSize(ValoresEstandar.MENU_LARGO, ValoresEstandar.MENU_ALTO);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);	
		this.getContentPane().setBackground(Color.WHITE);
		
		constructor();
		
		this.setVisible(true);
		
		eventos();
	}
	
	private void constructor() {
		int x = ValoresEstandar.MENU_LARGO / 2; 
		
		this.spaceinvader = new JLabel();
		this.spaceinvader.setText("Space Invaders");
		this.spaceinvader.setBounds(x - 150, 20, 300, 50);
			
		this.add(spaceinvader);
		
		this.addPlayerName = new JLabel();
		this.addPlayerName.setText("Ingrese nombre de jugador:");
		this.addPlayerName.setBounds(x - 150, 60, 300, 50);
			
		this.add(addPlayerName);
		
		this.playerName = new JTextField();
		this.playerName.setBounds(x - 150, 100, 300, 50);
		
		this.add(playerName);
				
		this.inicarJuego = new JButton();
		this.inicarJuego.setText("Inciar Juego");
		this.inicarJuego.setBounds(x - 150, 200, 300, 50);
		
		this.add(inicarJuego);
		
		this.puntajeMaximo = new JButton();
		this.puntajeMaximo.setText("Ver Puntaje Maximo");
		this.puntajeMaximo.setBounds(x - 150, 300, 300, 50);
		
		this.add(puntajeMaximo);
	}
	
	private void eventos() {
		
		
		inicarJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getGame();
			}
		});
		
		puntajeMaximo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				verPuntajesMaximosWindows();
			}
		});
	}
	
	private void getGame() {
		this.dispose();		
		TableroView tableroAux = Controlador.getInstance().iniciarJuego(playerName.getText());
		new VisualGameController(tableroAux);
	}
	
	
	private void verPuntajesMaximosWindows() {
		this.dispose();
		new VisualPuntajesMaximos(Controlador.getInstance().getPuntajes());
	}
}
