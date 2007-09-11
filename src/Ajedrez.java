/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Ajedrez implements Constantes{

	public static void main(String[] args) {
	
		Tablero t;
		Jugador jH;
		Jugador jM;
		System.out.println("Ajedrez.main(): He empezado");

		t = new Tablero();
		jH = new JugadorHumano(BLANCO, t);
		jM = new JugadorMaquina(NEGRO, t);

		t.mostrar();
	}
}
