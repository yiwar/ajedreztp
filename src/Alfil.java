/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Alfil extends Pieza {

	// Constructor
	public Alfil (int color, int x, int y) {
		
		super(color, x, y, "imagenes/a");
		System.out.println("Alfil.Alfil(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "A";
		else
			return "a";
	}

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {
		
		// diferencia entre filas y columnas para el movimiento
		int difFil, difCol;

		Pieza p;

		p = tablero.get(fF, cF);

		difFil = Math.abs(this.f - fF);
		difCol = Math.abs(this.c - cF);
		
		//un valor igual para ambas diferencias indica un moviento en diagonal
		if ( (difFil == difCol) ) {
			// la casilla destino no esta vacia
			if (p != null )
				//no se puede comer una pieza de igual color
				if (p.getColor() == this.color)
					return false;

			// el alfil no puede saltar a otras fichas
			for ( int i = 1; i < difFil; i++ ) {
				p = tablero.get( this.f + i * ((fF - this.f) / difFil), this.c + i * ((cF - this.c) / difFil));
				// trata de saltar a otra ficha
				if (p != null )
					return false;
			}
			return true;
		}
		// no es un movimiento en diagonal
		else 
			return false;
	}
}

