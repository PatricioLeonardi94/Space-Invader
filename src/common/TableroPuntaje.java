package common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import views.TableroPuntajeView;


public class TableroPuntaje {

	SortedMap<Integer, String> puntajesMaximos = new TreeMap<Integer, String>(Collections.reverseOrder()); 
	
	
	private static TableroPuntaje tableroPuntajes = null; 
	 
	private TableroPuntaje() {}    
	
	public static TableroPuntaje getInstance() 
    { 
        if (tableroPuntajes == null) {
        	tableroPuntajes = new TableroPuntaje(); 
        }
              
        return tableroPuntajes; 
    } 
	
	
	private void puntajeToFile() {
		try {
			FileWriter myObj = new FileWriter("src/files/puntajes.txt");
			BufferedWriter writer = new BufferedWriter(myObj);
			this.puntajesMaximos.keySet().forEach(key ->{
				String aux = puntajesMaximos.get(key) + " " + key.toString();
				try {
					writer.write(aux);
					writer.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});		   
		    writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void puntajeFromFile() {
		try {
			File myObj = new File("src/files/puntajes.txt");
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] parole = data.split("\\s+");
		        Integer aux = Integer.parseInt(parole[1]);
		        this.puntajesMaximos.put(aux, parole[0]);
		        }
		    }
	      catch(IOException e) {
	    	  e.printStackTrace();
	      }
	}
	
	
    public SortedMap<Integer, String> getPuntajesMaximos() {
		return puntajesMaximos;
	}

	public void agregarPuntaje(Integer puntaje, String nombreJugador) {
		this.puntajesMaximos.put(puntaje, nombreJugador);
	}
	
	public TableroPuntajeView tableroPuntajeToView() {
		this.puntajeFromFile();
		return new TableroPuntajeView(this.puntajesMaximos);
	}

	public void setPuntajesMaximos(Integer puntaje, String nombre) {
		puntajesMaximos.put(puntaje, nombre);
		checkValorMaximo();
		puntajeToFile();
	}
	
	private void checkValorMaximo() {
		if(this.puntajesMaximos.size() > 5) {
			while(this.puntajesMaximos.size() > 5) {		
				Integer aux = this.puntajesMaximos.lastKey();
				this.puntajesMaximos.remove(aux);
			}
		}		
	}
	
}