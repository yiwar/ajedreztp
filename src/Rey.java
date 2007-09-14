/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Rey extends Pieza {

	// Constructor
	public Rey (int color, int x, int y) {
		
		super(color, x, y, "imagenes/r");
		System.out.println("Rey.Rey(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "R";
		else
			return "r";
	}	
}

