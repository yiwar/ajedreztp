/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Peon extends Pieza {

	// Constructor
	public Peon (int color, int x, int y) {
		
		super(color, x, y, "imagenes/p");
		
		System.out.println("Peon.Peon(): \t\tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "P";
		else
			return "p";
	}

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {

		Pieza p;

		p = tablero.get(fF, cF);

		System.out.println("Peon.validarMovimiento(): posicion actual del peon <"+this.f+","+this.c+">");
		System.out.println("Peon.validarMovimiento(): lo movemos a             <"+fF+","+cF+">");
		
		// las negras se mueven hacia abajo
		if ( this.color == NEGRO ) {

			// movimiento normal de los peones
			if ( (this.c == cF) && (this.f + 1 == fF) ) {
				// no puede comer asi
				if ( p != null )
					return false;
				return true;
			}
			//movimiento inicial de los peones
			else if ( (this.c == cF) && (this.f == 1) && (fF == 3) ) {
				// no puede comer asi
				if ( p != null ) 
					return false;

				// verificamos que no haya una ficha en la mitad
				p = tablero.get(2, this.c);
				// no puede saltar a otra ficha
				if ( p != null ) 
					return false;
				return true;
			}
			//movimiento de comer
			else if ( ((cF == this.c + 1) || (cF == this.c - 1)) && (fF == this.f + 1) ) {
				// no hay nada que comer
				if ( p == null ) 
					return false;
				// no es una ficha rival
				if ( p.getColor() == NEGRO ) 
					return false;
				return true;
			}
		}
		//las blancas hacia arriba
		else {
			// movimiento normal de los peones
			if ( (this.c == cF) && (this.f - 1 == fF) ) {
				System.out.println("Peon.validarMovimiento(): movimiento normal del peon");
				// no puede comer asi
				if ( p != null )
					return false;
				return true;
			}
			//movimiento inicial de los peones
			else if ( (this.c == cF) && (this.f == 6) && (fF == 4) ) {
				System.out.println("Peon.validarMovimiento(): movimiento inicial del peon");
				// no puede comer asi
				if ( p != null ) 
					return false;

				// verificamos que no haya una ficha en la mitad
				p = tablero.get(5, this.c);
				// no puede saltar a otra ficha
				if ( p != null ) 
					return false;
				return true;
			}
			//movimiento de comer
			else if ( ((cF == this.c + 1) || (cF == this.c - 1)) && (fF == this.f - 1) ) {
				System.out.println("Peon.validarMovimiento(): movimiento de comer del peon");
				// no hay nada que comer
				if ( p == null ) 
					return false;
				// no es una ficha rival
				if ( p.getColor() == BLANCO ) 
					return false;
				return true;
			}
			System.out.println("Peon.validarMovimiento(): no entro en nada");
		}
		return false;
	}
}

