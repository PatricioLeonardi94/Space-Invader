package EnumsAndEstandar;

public interface ValoresEstandar {
	
	//TABLERO
	final double TABLERO_X = 1000;
	final double TABLERO_Y = 1000;
	
	//MUROENERGIA
	final double MUROENERGIA_LARGO = 125;
	final double MUROENERGIA_ALTO = 50;
	final double MUROENERGIA_Y = TABLERO_Y - 300;
	final int MUROENERGIA_VIDA = 100;
	
	//PLAYER
	final double PLAYER_LARGO = 50;
	final double PLAYER_ALTO = 50;
	final double PLAYER_X = PLAYER_LARGO;
	final double PLAYER_Y = 900;
	final int PLAYER_DIRECCION_X = 1;
	final int PLAYER_VIDAS_INICIALES = 3;
	final int PLAYER_PUNTAJE_INICIAL = 0;
	 
	
	//NAVEINVASORA
	final double NAVEINVASORA_LARGO = 50;
	final double NAVEINVASORA_ALTO = 50;
	final int NAVEINVASORA_DIRECCION_Y = 1;
	
	
	//PROYECTIL
	final double PROYECTIL_LARGO = 50;
	final double PROYECTIL_ALTO = 50;
	final int VALOR_ESTANDAR_SALIDA_PROYECTIL_Y = 880;

	
	//DISTRIBUCIONNIVEL
	//Estamos teniendo en cuenta que la cantidad de naves es multiplo de 5, para poner 5 por fila.
	final int CANTIDAD_NAVEINVASORA = 15;
	final int CANTIDAD_NAVEINVASORA_POR_FILA = 5;
	final int CANTIDAD_FILAS = 3;
	final int CANTIDAD_MUROENERGIA = 4;
	final int CANTIDAD_TRONERAS = 5;
	final double CANTIDAD_DISTANCIA_ENTRE_NAVES = 50;
	
	//Menu
	final int MENU_LARGO = 500;
	final int MENU_ALTO = 500;
	
	//GENERALES 
	//Crear un elemento general para saber la cantidad de desplazamiento de cada elemento a la hora de moverse
	final double MOVIMIENTO_GENERAL_X = 20;
	final double MOVIMIENTO_GENERAL_Y = 20;
	final int VELOCIDAD_ESTANDAR = 750;
	final int AUMENTO_VELOCIDAD_POR_NIVEL = 20;
	final int TIEMPO_ESTANDAR_DISPARO_INVASORES = 3000;
	final int VALOR_ESTANDAR_MOVIMIENTO_PROYECTILES = 100;
	final int VALOR_ESTANDAR_MAXIMO_PARA_NAVES_Y = 650;
}
