/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Reina extends Pieza {

	// Constructor
	public Reina (int color, int x, int y) {
		
		super(color, x, y, "imagenes/d");
		System.out.println("Reina.Reina(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "D";
		else
			return "d";
	}	
}

