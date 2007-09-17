/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.util.*;
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

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {	

		int difFil, difCol;
		Pieza p;
		
		p = tablero.get(fF, cF);

		difFil = this.f - fF;
		difCol = this.c - cF;

		//solo se mueve una posicion alrededor
		if (Math.abs(difFil) <= 1 && Math.abs(difCol)<= 1) {
			// solo podemos comer piezas enemigas
			if (p != null )
				if (p.getColor() == this.color)
					return false;
			return true;
		}
		else 
			return false;
	}

	public ArrayList posiblesMovimientos(Tablero t) {

		return new ArrayList();
	}	
}

