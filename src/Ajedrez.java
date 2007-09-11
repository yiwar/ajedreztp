/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Ajedrez {

	public static void main(String[] args) {
	
		Tablero t;
		Jugador jH;
		Jugador jM;
		System.out.println("Ajedrez.main(): He empezado");

		t = new Tablero();
		jH = new JugadorHumano();
		jM = new JugadorMaquina();
	}
}
