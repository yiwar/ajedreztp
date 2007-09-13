/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public abstract class Pieza implements Constantes {

	// color de la pieza
	int color;
	// posicion de la pieza en el tablero de juego	
	int x, y;

	// constructor
	public Pieza (int color, int x, int y) {

		this.color = color;
		this.x = x;
		this.y = y;
		//System.out.println("Pieza.Pieza(): Me acaban de crear");
	}

	public abstract String toString ();

	//public abstract boolean movimientoValido ();
}	
