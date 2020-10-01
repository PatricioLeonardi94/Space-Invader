package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.SortedMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import EnumsAndEstandar.ValoresEstandar;
import views.TableroPuntajeView;

public class VisualPuntajesMaximos extends JFrame{
	
	private JLabel puntajeMaximoLabel;
	private JButton volver;
	private JTable tabla;
	
	private TableroPuntajeView puntajes;
	private SortedMap<Integer, String> puntajesView;

	public VisualPuntajesMaximos(TableroPuntajeView puntajes) {
		
		this.puntajes = puntajes;
		this.puntajesView = puntajes.getPuntajesMaximos();

		
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
		this.puntajeMaximoLabel = new JLabel();
		this.puntajeMaximoLabel.setText("Puntajes Maximos");
		this.puntajeMaximoLabel.setBounds(200, 25, 300, 100);
		this.add(puntajeMaximoLabel);
	

		int y = 100;
		
		for(Integer key : this.puntajesView.keySet()) {
			JLabel auxLabel = new JLabel();
			auxLabel.setText("Jugador: " + this.puntajesView.get(key) + " - Puntaje: " + key.toString());
			auxLabel.setBounds(100, y, 300, 50);
			this.add(auxLabel);
			y +=50;
		}
		
		
		this.volver = new JButton();
		this.volver.setText("Volver");
		this.volver.setBounds(150, 350, 200, 50);
		this.add(volver);
	}
	
	private void eventos() {
		
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
	}
	
	private void volver() {
		this.dispose();
		new VisualMenu();
	}

}
