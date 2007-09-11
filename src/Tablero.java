/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class Tablero {

	private Pieza[][] tablero;

	// Constructor
	public Tablero () {
		
		tablero = new Pieza[8][8];
		System.out.println("Tablero.Tablero(): Me acaban de crear");
	}

	public void add (int x, int y, Pieza p) {
		
		tablero[x][y] = p;
	}

	public void mostrar () {
		
		System.out.println("Tablero.show():");
		for (int f=0; f<8; f++) {
			//System.out.print("F");
			for (int c=0; c<8; c++) {
				if (tablero[f][c] != null)
					System.out.print((tablero[f][c]).toString() + " "); //getClass().getName());
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}

