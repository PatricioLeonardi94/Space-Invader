package views;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class TableroPuntajeView {

	SortedMap<Integer, String> puntajesMaximos = new TreeMap<Integer, String>(Collections.reverseOrder()); 
	
	public TableroPuntajeView() {}
	
	public TableroPuntajeView(SortedMap<Integer, String> puntajesMaximos ) {
		this.puntajesMaximos = puntajesMaximos;
	}

	public SortedMap<Integer, String> getPuntajesMaximos() {
		return puntajesMaximos;
	}
	
	public Object[][] toJTable(){
		
		Object[][] resp = new Object[this.puntajesMaximos.size()][2];
		
		this.puntajesMaximos.keySet().forEach(key->{
			int contador = 0;
			resp[contador][0] = puntajesMaximos.get(key).toString();
			resp[contador][1] = key.toString();
			contador++;
		});
		
		return resp;
	}
	
}
