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

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {

		Torre t;
		Alfil a;
		
		//la reina se mueve como una torre o un alfil
		t = new Torre(this.color, this.f, this.c);
		a = new Alfil(this.color, this.f, this.c);
		
		//si se mueve como una torre o como un alfil, está bien
		if (t.validarMovimiento(tablero, fF, cF) || a.validarMovimiento(tablero, fF, cF))
			return true;
		return false;
	}	
}

