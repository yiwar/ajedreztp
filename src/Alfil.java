/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Alfil extends Pieza {

	// Constructor
	public Alfil (int color, int x, int y) {
		
		super(color, x, y);
		System.out.println("Alfil.Alfil(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}
}

