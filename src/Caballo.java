/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Caballo extends Pieza {

	// Constructor
	public Caballo (int color, int x, int y) {
		
		super(color, x, y, "imagenes/c");
		System.out.println("Caballo.Caballo(): \tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "C";
		else
			return "c";
	}

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {
		
		int difFil, difCol;
		Pieza p;
		
		p = tablero.get(fF, cF);

		difFil = this.f - fF;
		difCol = this.c - cF;

		// el movimiento del caballo se caracteriza por un salto de
		// 1 en las filas y 2 en las columnas o viceversa (en valor absoluto)
		if (((Math.abs(difFil) == 1) && (Math.abs(difCol) == 2)) || ((Math.abs(difFil) == 2) && (Math.abs(difCol) == 1))) {
			// solo podemos comer al rival
			if (p != null )
				if (p.getColor() == this.color)
					return false;
			return true;
		}
		else 
			return false;
	}
}

