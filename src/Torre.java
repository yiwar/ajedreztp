/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Torre extends Pieza {

	// Constructor
	public Torre (int color, int x, int y) {
		
		super(color, x, y, "imagenes/t");
		System.out.println("Torre.Torre(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "T";
		else
			return "t";
	}	
}

