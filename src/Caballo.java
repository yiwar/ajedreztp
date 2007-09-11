/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Caballo extends Pieza {

	// Constructor
	public Caballo (int color, int x, int y) {
		
		super(color, x, y);
		System.out.println("Caballo.Caballo(): \tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "C";
		else
			return "c";
	}
}

